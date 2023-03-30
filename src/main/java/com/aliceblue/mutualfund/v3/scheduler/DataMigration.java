package com.aliceblue.mutualfund.v3.scheduler;

import com.aliceblue.mutualfund.v3.service.AllotmentService;
import com.aliceblue.mutualfund.v3.service.HoldingsService;
import com.aliceblue.mutualfund.v3.service.OrderService;
import com.aliceblue.mutualfund.v3.service.RedemptionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableAsync
@Slf4j
public class DataMigration {

    @Autowired
    OrderService orderService;
    @Autowired
    AllotmentService allotmentService;
    @Autowired
    RedemptionService redemptionService;
    @Autowired
    HoldingsService holdingsService;

    @Scheduled(cron = "0 45 7,11,13,15,17,19 * * *")
    @Async
    public void migrateOrders()
    {
        orderService.migrateAllOrders();
        log.info("Orders migrated successfully");
    }

    @Scheduled(cron = "0 15 8,12,14,16,18,20 * * *")
    @Async
    public void migrateAllotment()
    {
        allotmentService.migrateAllAllotments();
        log.info("Allotments migrated successfully");
    }

    @Scheduled(cron = "0 15 8,12,14,16,18,20 * * *")
    @Async
    public void migrateRedemption()
    {
        redemptionService.migrateAllRedemptions();
        log.info("Redemptions migrated successfully");
    }

    @Scheduled(cron = "0 30 8,12,14,16,18,20 * * *")
    @Async
    public void calculateHoldings()
    {
        holdingsService.calculateAllClientsHolding();
        log.info("Holdings are updated successfully");
    }
}
