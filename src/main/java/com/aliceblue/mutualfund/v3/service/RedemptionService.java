package com.aliceblue.mutualfund.v3.service;

import com.aliceblue.mutualfund.v3.model.MFRedemptionResponse;

import java.util.List;

public interface RedemptionService {

    void migrateAllRedemptions();

    List<MFRedemptionResponse> getAllRedemptions(String clientId, String schemeCode);

    Double getAllRedeemedUnits(String clientId, String schemeCode);
}
