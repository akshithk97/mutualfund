package com.aliceblue.mutualfund.v2.repository;

import com.aliceblue.mutualfund.v2.entity.MFOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<MFOrder, Long> {
}
