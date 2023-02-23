package com.aliceblue.mutualfund.v3.repository;

import com.aliceblue.mutualfund.v3.model.MFOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MFOrderRepository extends JpaRepository<MFOrder, Long> {

    @Query(value = "select * from mf_order where UniqueReferenceNumber = :uniqueRefNum", nativeQuery = true)
    Optional<MFOrder> findByUniqueRefNumber(@Param("uniqueRefNum") String uniqueReferenceNumber);
}
