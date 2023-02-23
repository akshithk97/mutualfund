package com.aliceblue.mutualfund.v2.repository;

import com.aliceblue.mutualfund.v2.entity.MFAllotmentResponse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllotmentRepository extends JpaRepository<MFAllotmentResponse, Long> {
}
