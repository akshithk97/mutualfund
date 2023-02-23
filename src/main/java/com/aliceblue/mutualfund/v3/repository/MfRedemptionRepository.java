package com.aliceblue.mutualfund.v3.repository;

import com.aliceblue.mutualfund.v3.model.MFRedemptionResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MfRedemptionRepository extends JpaRepository<MFRedemptionResponse, Long> {

    @Query(value = "select * from mf_redemption_response where OrderId = :orderId", nativeQuery = true)
    Optional<MFRedemptionResponse> findByOrderId(@Param("orderId") String orderId);
}
