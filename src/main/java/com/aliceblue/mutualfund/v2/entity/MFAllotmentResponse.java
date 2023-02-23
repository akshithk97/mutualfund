package com.aliceblue.mutualfund.v2.entity;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "mf_allotment_response")
@Getter
public class MFAllotmentResponse {

    @Id
    Long id;
    String AllotedDate;
    String REPORTDATE;
    String ORDERNO;
    String SETTLEMENT_TYPE;
    String SETTLEMENT_NO;
    String ORDER_DATE;
    String SCHEMECODE;
    String ISIN;
    Double AMOUNT;
    String QUANTITY;
    String MEMBER_ID;
    String BRANCH_CODE;
    String USERID;
    String FOLIONO;
    String RTASCHEMECODE;
    String RTATRANSNO;
    String CLIENT_CODE;
    String CLIENT_NAME;
    String BENEFICIARYID;
    String ALLOTTED_NAV;
    String ALLOTTED_UNIT;
    String ALLOTMENT_AMOUNT;
    String VALIDFLAG;
    String REMARKS;
    String STT;
    String INTERNAL_REF_NO;
    String ORDER_TYPE;
    String SIP_REGN_NO;
    String SIP_REGN_DATE;
    String SUBBRCODE;
    String EUIN;
    String EUIN_DECL;
    String DPC_FLAG;
    String DP_TRANS;
    String ORDER_SUB_TYPE;
    Date createdAt;
    Date updatedAt;
}
