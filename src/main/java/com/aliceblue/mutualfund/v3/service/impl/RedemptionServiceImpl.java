package com.aliceblue.mutualfund.v3.service.impl;

import com.aliceblue.mutualfund.v2.service.DataService;
import com.aliceblue.mutualfund.v3.model.MFRedemptionResponse;
import com.aliceblue.mutualfund.v3.repository.MfRedemptionRepository;
import com.aliceblue.mutualfund.v3.service.RedemptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RedemptionServiceImpl implements RedemptionService {

    @Autowired
    MfRedemptionRepository redemptionRepository;

    @Autowired
    DataService v2DataService;

    @Override
    public void migrateAllRedemptions() {

        List<com.aliceblue.mutualfund.v2.entity.MFRedemptionResponse> v2RedemptionList = v2DataService.getAllRedemptions();
        for (com.aliceblue.mutualfund.v2.entity.MFRedemptionResponse v2Redemption : v2RedemptionList)
        {
            MFRedemptionResponse redemptionResponse = redemptionRepository.findByOrderId(v2Redemption.getOrderNo()).orElse(new MFRedemptionResponse());
            redemptionResponse.setNAV(v2Redemption.getNAV());
            redemptionResponse.setSTT(v2Redemption.getSTT());
            redemptionResponse.setUnit(v2Redemption.getUnit());
            redemptionResponse.setISIN(v2Redemption.getISIN());
            redemptionResponse.setAmount(v2Redemption.getAmount());
            redemptionResponse.setUserId(v2Redemption.getUserId());
            redemptionResponse.setFolioNo(v2Redemption.getFolioNo());
            redemptionResponse.setDPCFlag(v2Redemption.getDPCFlag());
            redemptionResponse.setDPTrans(v2Redemption.getDPTrans());
            redemptionResponse.setRemarks(v2Redemption.getRemarks());
            redemptionResponse.setOrderId(v2Redemption.getOrderNo());
            redemptionResponse.setQuantity(v2Redemption.getQty());
            redemptionResponse.setMemberId(v2Redemption.getMemberCode());
            redemptionResponse.setOrderDate(v2Redemption.getOrderDate());
            redemptionResponse.setOrderType(v2Redemption.getOrderType());
            redemptionResponse.setCreatedAt(v2Redemption.getCreatedAt());
            redemptionResponse.setUpdatedAt(v2Redemption.getUpdatedAt());
            redemptionResponse.setValidFlag(v2Redemption.getValidFlag());
            redemptionResponse.setBranchCode(v2Redemption.getBranchCode());
            redemptionResponse.setClientCode(v2Redemption.getClientCode());
            redemptionResponse.setClientName(v2Redemption.getClientName());
            redemptionResponse.setReportDate(v2Redemption.getReportDate());
            redemptionResponse.setRTATransNo(v2Redemption.getRTATransNo());
            redemptionResponse.setSchemeCode(v2Redemption.getSchemeCode());
            redemptionResponse.setSettlementNo(v2Redemption.getSettNo());
            redemptionResponse.setSubOrderType(v2Redemption.getSubOrderType());
            redemptionResponse.setRedeemedDate(v2Redemption.getRedeemedDate());
            redemptionResponse.setBeneficiaryId(v2Redemption.getBeneficiaryId());
            redemptionResponse.setRTASchemeCode(v2Redemption.getRTASchemeCode());
            redemptionResponse.setRedeemedAmount(v2Redemption.getAmt());
            redemptionResponse.setSettlementType(v2Redemption.getSettType());
            redemptionRepository.save(redemptionResponse);
        }
    }
}
