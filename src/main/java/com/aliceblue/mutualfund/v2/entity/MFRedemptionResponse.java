package com.aliceblue.mutualfund.v2.entity;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "mf_redemption_response")
@Getter
public class MFRedemptionResponse {

    @Id
    Long id;
    String RedeemedDate;
    String ReportDate;
    String OrderNo;
    String SettType;
    String SettNo;
    String OrderDate;
    String SchemeCode;
    String ISIN;
    Double Amount;
    Double Qty;
    String MemberCode;
    String BranchCode;
    String UserId;
    String FolioNo;
    String RTASchemeCode;
    String RTATransNo;
    String ClientCode;
    String ClientName;
    String BeneficiaryId;
    Double NAV;
    Double Unit;
    Double Amt;
    String ValidFlag;
    String Remarks;
    String STT;
    String DPCFlag;
    String DPTrans;
    String OrderType;
    String SubOrderType;
    Date createdAt;
    Date updatedAt;
}
