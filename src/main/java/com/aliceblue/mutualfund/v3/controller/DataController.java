package com.aliceblue.mutualfund.v3.controller;

import com.aliceblue.mutualfund.v3.service.AllotmentService;
import com.aliceblue.mutualfund.v3.service.OrderService;
import com.aliceblue.mutualfund.v3.service.RedemptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v3/data")
public class DataController {

    @Autowired
    OrderService orderService;

    @Autowired
    AllotmentService allotmentService;

    @Autowired
    RedemptionService redemptionService;

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
}
