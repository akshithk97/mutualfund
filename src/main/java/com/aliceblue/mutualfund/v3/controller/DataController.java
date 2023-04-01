package com.aliceblue.mutualfund.v3.controller;

import com.aliceblue.mutualfund.v3.service.AllotmentService;
import com.aliceblue.mutualfund.v3.service.HoldingsService;
import com.aliceblue.mutualfund.v3.service.OrderService;
import com.aliceblue.mutualfund.v3.service.RedemptionService;
import com.aliceblue.mutualfund.v3.soapclient.MFOrderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.soap.SOAPException;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/v3/data")
public class DataController {

    @Autowired
    OrderService orderService;

    @Autowired
    AllotmentService allotmentService;

    @Autowired
    RedemptionService redemptionService;

    @Autowired
    HoldingsService holdingsService;

    @Autowired
    MFOrderClient mfOrderClient;

    @GetMapping(value = "/orders")
    public String migrateOrders()
    {
        orderService.migrateAllOrders();
        return "Orders migrated successfully";
    }

    @GetMapping(value = "/allotment")
    public String migrateAllotment()
    {
        allotmentService.migrateAllAllotments();
        return "Allotments migrated successfully";
    }

    @GetMapping(value = "/redemption")
    public String migrateRedemption()
    {
        redemptionService.migrateAllRedemptions();
        return "Redemptions migrated successfully";
    }

    @GetMapping(value = "/holdings")
    public String calculateHoldings()
    {
        holdingsService.calculateAllClientsHolding();
        return "Holdings are updated successfully";
    }

    @GetMapping(value = "getPassword")
    public String getPassword() throws URISyntaxException, SOAPException {
        return mfOrderClient.getPassword("667001");
    }
}
