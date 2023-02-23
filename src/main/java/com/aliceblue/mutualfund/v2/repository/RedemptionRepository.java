package com.aliceblue.mutualfund.v2.repository;


import com.aliceblue.mutualfund.v2.entity.MFRedemptionResponse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RedemptionRepository extends JpaRepository<MFRedemptionResponse, Long> {
}
