package com.aliceblue.mutualfund.v3.repository;


import com.aliceblue.mutualfund.v3.model.MFAllotmentResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MFAllotmentRepository extends JpaRepository<MFAllotmentResponse, Long> {

    @Query(value = "select * from mf_allotment_response where OrderId = :orderId", nativeQuery = true)
    Optional<MFAllotmentResponse> findByOrderId(@Param("orderId") String orderId);
}
