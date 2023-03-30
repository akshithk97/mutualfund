package com.aliceblue.mutualfund.v3.service;

import com.aliceblue.mutualfund.v3.model.MFAllotmentResponse;

import java.util.List;

public interface AllotmentService {

    void migrateAllAllotments();

    List<MFAllotmentResponse> getAllAllotments(String clientId, String schemeCode);
}
