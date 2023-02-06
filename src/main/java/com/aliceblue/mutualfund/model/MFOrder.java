package com.aliceblue.mutualfund.model;

import com.aliceblue.mutualfund.model.util.BaseModel;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "mf_order")
@Getter @Setter
public class MFOrder extends BaseModel {

    private Date OrderDate;
    @Column(nullable = false)
    private String Category;
    @Column(columnDefinition = "varchar(10) default 'NEW'")
    private String TransactionCode;
    @Column(nullable = false, unique = true)
    private String UniqueReferenceNumber;
    @Column(unique = true)
    private String OrderId;
    @Column(columnDefinition = "varchar(10) default '667001'")
    private String UserID;
    @Column(columnDefinition = "varchar(10) default '6670'")
    private String MemberId;
    @Column(nullable = false)
    private String ClientCode;
    @Column(nullable = false)
    private String SchemeCd;
    private String BuySell;
    private String BuySellType;
    @Column(columnDefinition = "varchar(10) default 'C'")
    private String DPTxn;
    private String AMOUNT;
    private String Qty;
    private String AllRedeem;
    private String FolioNo;
    private String Remarks;
    @Column(columnDefinition = "varchar(10) default 'Y'")
    private String KYCStatus;
    private String RefNo;
    private String SubBrCode;
    @Column(columnDefinition = "varchar(10) default 'E123456'")
    private String EUIN;
    private String EUINflag;
    private String MinRedeem;
    private String DPC;
    private String IPAdd;
    private String PARAM1;
    private String PARAM2;
    private String PARAM3;
    private String SIPFreqType;
    private String TotalInstallment;
    private String CurrentInstallment;
    private String FirstOrderFlag;
    private String OrderRefNo;
    private String SIPAmount;
    private String SIPTry;
    private String OrderStatusLastUpdatedAt;
    private String UPIID;
    private String OrderStatus;
    private String OrderSentDate;
    private String OrderSentRemark;
}
