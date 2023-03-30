package com.aliceblue.mutualfund.v3.service.impl;

import com.aliceblue.mutualfund.v2.service.DataService;
import com.aliceblue.mutualfund.v3.model.MFOrder;
import com.aliceblue.mutualfund.v3.repository.MFOrderRepository;
import com.aliceblue.mutualfund.v3.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    DataService v2DataService;

    @Autowired
    MFOrderRepository orderRepository;

    @Override
    public void migrateAllOrders()
    {
//        int index = v2DataService.getTotalPages() -1;
//        while (index >= 0)
//        {
//            System.out.println("index - "+index);
            List<com.aliceblue.mutualfund.v2.entity.MFOrder> v2OrderList = v2DataService.getAllOrders(0, 1000);
            System.out.println("orders - "+v2OrderList.size());
            for (com.aliceblue.mutualfund.v2.entity.MFOrder v2Order : v2OrderList)
            {
                MFOrder order = orderRepository.findByUniqueRefNumber(v2Order.getUniqueReferenceNumber()).orElse(new MFOrder());
                order.setDPC(v2Order.getDPC());
                order.setEUIN(v2Order.getEUIN());
                order.setIPAdd(v2Order.getIPAdd());
                order.setDPTxn(v2Order.getDPTxn());
                order.setRefNo(v2Order.getRefNo());
                order.setUPIId(v2Order.getUPIID());
                order.setAmount(v2Order.getAMOUNT());
                order.setPARAM1(v2Order.getPARAM1());
                order.setPARAM2(v2Order.getPARAM2());
                order.setPARAM3(v2Order.getPARAM3());
                order.setSIPTry(v2Order.getSIPTry());
                order.setUserId(v2Order.getUserID());
                order.setBuySell(v2Order.getBuySell());
                order.setFolioNo(v2Order.getFolioNo());
                order.setRemarks(v2Order.getRemarks());
                order.setQuantity(v2Order.getQty());
                order.setCategory(v2Order.getCategory());
                order.setEUINFlag(v2Order.getEUINflag());
                order.setMemberId(v2Order.getMemberId());
                order.setClientId(v2Order.getClientCode());
                order.setOrderDate(v2Order.getOrderDate());
                order.setKYCStatus(v2Order.getKYCStatus());
                order.setAllRedeem(v2Order.getAllRedeem());
                order.setMinRedeem(v2Order.getMinRedeem());
                order.setSIPAmount(v2Order.getSIPAmount());
                order.setSubBrCode(v2Order.getSubBrCode());
                order.setCreatedAt(v2Order.getCreatedAt());
                order.setUpdatedAt(v2Order.getUpdatedAt());
                order.setSchemeCode(v2Order.getSchemeCd());
                order.setOrderRefNo(v2Order.getOrderRefNo());
                order.setBuySellType(v2Order.getBuySellType());
                order.setOrderStatus(v2Order.getOrderStatus());
                order.setSIPFreqType(v2Order.getSIPFreqType());
                order.setOrderSentDate(v2Order.getOrderSentDate());
                order.setFirstOrderFlag(v2Order.getFirstOrderFlag());
                order.setOrderSentRemark(v2Order.getOrderSentRemark());
                order.setTransactionCode(v2Order.getTransactionCode());
                order.setTotalInstallment(v2Order.getTotalInstallment());
                order.setCurrentInstallment(v2Order.getCurrentInstallment());
                order.setUniqueReferenceNumber(v2Order.getUniqueReferenceNumber());
                order.setOrderStatusLastUpdatedAt(v2Order.getOrderStatusLastUpdatedAt());

                if (!v2Order.getOrderId().isEmpty() && !v2Order.getOrderId().equalsIgnoreCase("0"))
                    order.setOrderId(v2Order.getOrderId());

                orderRepository.save(order);
            }
//            index--;
////            break;
//        }
    }

    @Override
    public MFOrder findByOrderId(String orderId) {
        return orderRepository.findByOrderId(orderId).orElse(new MFOrder());
    }

    @Override
    public List<MFOrder> findAllClientsBySchemeCode() {
        return orderRepository.findAllClientsBySchemeCode();
    }
}
