package com.aliceblue.mutualfund.v3.repository;

import com.aliceblue.mutualfund.v3.model.MFHoldingList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MFHoldingListRepository extends JpaRepository<MFHoldingList, Long> {

    @Query(value = "select * from mf_holding_list where UniqueReferenceNumber = :uniqueReferenceNumber", nativeQuery = true)
    Optional<MFHoldingList> getByUniqueRefNumber(@Param("uniqueReferenceNumber") String uniqueReferenceNumber);
}
