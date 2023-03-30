package com.aliceblue.mutualfund.v3.service;

import com.aliceblue.mutualfund.v3.model.MFOrder;

import java.util.List;

public interface OrderService {

    void migrateAllOrders();

    MFOrder findByOrderId(String orderId);

    List<MFOrder> findAllClientsBySchemeCode();
}
