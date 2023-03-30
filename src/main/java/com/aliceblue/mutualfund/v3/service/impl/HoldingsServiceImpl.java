package com.aliceblue.mutualfund.v3.service.impl;

import com.aliceblue.mutualfund.v3.model.*;
import com.aliceblue.mutualfund.v3.repository.MFHoldingCumulativeRepository;
import com.aliceblue.mutualfund.v3.repository.MFHoldingListRepository;
import com.aliceblue.mutualfund.v3.service.AllotmentService;
import com.aliceblue.mutualfund.v3.service.HoldingsService;
import com.aliceblue.mutualfund.v3.service.OrderService;
import com.aliceblue.mutualfund.v3.service.RedemptionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class HoldingsServiceImpl implements HoldingsService {

    @Autowired
    OrderService orderService;

    @Autowired
    AllotmentService allotmentService;

    @Autowired
    RedemptionService redemptionService;

    @Autowired
    MFHoldingCumulativeRepository holdingCumulativeRepository;

    @Autowired
    MFHoldingListRepository holdingListRepository;

    @Override
    public void calculateAllClientsHolding()
    {
        List<MFOrder> orders = orderService.findAllClientsBySchemeCode();
        log.info("Total orders - {}",  orders.size());
        Map<String, Map<String, Double>> clients = new HashMap<>();
        for (MFOrder order : orders)
        {
            Map<String, Double> cumulated = clients.getOrDefault(order.getClientId(), new HashMap<>());
            String schemeCode = order.getSchemeCode();
            if (schemeCode.endsWith("-L1") || schemeCode.endsWith("-L0"))
            {
                schemeCode = schemeCode.replace("-L1", "");
                schemeCode = schemeCode.replace("-L0", "");
            }
            List<MFAllotmentResponse> allotmentList = allotmentService.getAllAllotments(order.getClientId(), order.getSchemeCode());
            double redeemedUnits = redemptionService.getAllRedeemedUnits(order.getClientId(), schemeCode);
            double totalRedeemed = redeemedUnits;
            double cumulative = cumulated.getOrDefault(schemeCode, 0.0);
            String refNo = "";

//            log.info("Client - {}", order.getClientId());
//            log.info("Scheme - {}", schemeCode);
//            log.info("Total Allotments - {}", allotmentList.size());
//            log.info("Total Redeemed Units - {}", redeemedUnits);
            for (MFAllotmentResponse allotment : allotmentList)
            {
//                log.info("Redeemed Units - {}", redeemedUnits);
                double allottedUnits = allotment.getAllottedUnit();
                cumulative = cumulative + allottedUnits;
//                log.info("cumulative - {}",cumulative);
//                log.info("allottedUnits - {}",allottedUnits);
                if (redeemedUnits > allottedUnits) {
                    allottedUnits = 0;
                    redeemedUnits = redeemedUnits - allottedUnits;
                }
                else {
                    allottedUnits = allottedUnits - redeemedUnits;
                    redeemedUnits = 0;
                }

                MFOrder allottedOrder = orderService.findByOrderId(allotment.getOrderId());
                refNo = allottedOrder.getRefNo();
                if (refNo==null)
                    continue;
//                log.info("Order Id - {}",allotment.getOrderId());
//                log.info("Ref No - {}",refNo);

                cumulated.put(schemeCode, cumulative);
                clients.put(order.getClientId(), cumulated);

                if (allottedUnits == 0)
                    continue;

                MFHoldingList mfHoldingList = holdingListRepository.getByUniqueRefNumber(allottedOrder.getUniqueReferenceNumber()).orElse(new MFHoldingList());
                mfHoldingList.setAllottedUnit(allottedUnits);
                mfHoldingList.setClientId(order.getClientId());
                mfHoldingList.setOrderId(allotment.getOrderId());
                mfHoldingList.setRefNo(allottedOrder.getRefNo());
                mfHoldingList.setSchemeCode(order.getSchemeCode());
                mfHoldingList.setAllottedNAV(allotment.getAllottedNAV());
                mfHoldingList.setAllottedDate(allotment.getAllottedDate());
                mfHoldingList.setOrderRefNo(allottedOrder.getOrderRefNo());
                mfHoldingList.setUniqueReferenceNumber(allottedOrder.getUniqueReferenceNumber());
                holdingListRepository.save(mfHoldingList);
            }
            if (refNo==null)
                continue;
            MFHoldingCumulative mfHoldingCumulative= holdingCumulativeRepository.getByRefNo(refNo).orElse(new MFHoldingCumulative());
            mfHoldingCumulative.setUnit(cumulative - totalRedeemed);
            mfHoldingCumulative.setRefNumber(refNo);
            mfHoldingCumulative.setClientId(order.getClientId());
            mfHoldingCumulative.setSchemeCode(schemeCode);
            MFHoldingCumulative saved = holdingCumulativeRepository.save(mfHoldingCumulative);
            log.info("saved entry - {}", saved.getId());
        }
    }
}
