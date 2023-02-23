package com.aliceblue.mutualfund.v2.entity;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "mf_order")
@Getter
public class MFOrder {

    @Id
    Long id;
    Date OrderDate;
    String Category;
    String TransactionCode;
    String UniqueReferenceNumber;
    String OrderId;
    String UserID;
    String MemberId;
    String ClientCode;
    String SchemeCd;
    String BuySell;
    String BuySellType;
    String DPTxn;
    String AMOUNT;
    String Qty;
    String AllRedeem;
    String FolioNo;
    String Remarks;
    String KYCStatus;
    String RefNo;
    String SubBrCode;
    String EUIN;
    String EUINflag;
    String MinRedeem;
    String DPC;
    String IPAdd;
    String PARAM1;
    String PARAM2;
    String PARAM3;
    String SIPFreqType;
    String TotalInstallment;
    String CurrentInstallment;
    String FirstOrderFlag;
    String OrderRefNo;
    String SIPAmount;
    String SIPTry;
    String OrderStatusLastUpdatedAt;
    String UPIID;
    String OrderStatus;
    String OrderSentDate;
    String OrderSentRemark;
    Date createdAt;
    Date updatedAt;
}
