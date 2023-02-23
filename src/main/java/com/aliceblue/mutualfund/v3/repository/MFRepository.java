package com.aliceblue.mutualfund.v3.repository;

import com.aliceblue.mutualfund.v3.model.MFOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MFRepository extends JpaRepository<MFOrder, Long> {

    @Query(value = "select t1.*, t3.CLIENT_ID_MAIL, t3.MOBILE_NO, t3.BANK_ACNO, t2.scheme_name, t2.settlement_type from mf_order t1 join scheme_master_data t2 on t1.SchemeCd = t2.scheme_code join client_dp t3 on t1.ClientCode = t3.CLIENT_ID where t1.OrderDate < :cutOffTime and t1.OrderStatus = 'Pending Order' and t1.BuySell = 'R' and  t3.company_code = 'MF_BSE';", nativeQuery = true)
    List<MFOrder> getOrdersForRedemption(@Param("cutOffTime") String cutOffTime);
}
