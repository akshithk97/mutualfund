package com.aliceblue.mutualfund.v3.repository;

import com.aliceblue.mutualfund.v3.model.MFHoldingCumulative;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MFHoldingCumulativeRepository extends JpaRepository<MFHoldingCumulative, Long> {

    @Query(value = "select * from mf_holding_cumulative where RefNumber = :refNo", nativeQuery = true)
    Optional<MFHoldingCumulative> getByRefNo(@Param("refNo") String refNo);
}
