package com.aliceblue.mutualfund.v3.model;

import com.aliceblue.mutualfund.v3.model.util.BaseModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "mf_allotment_response")
@Getter @Setter
public class MFAllotmentResponse extends BaseModel {

    String AllottedDate;
    String ReportDate;
    String OrderId;
    String SettlementType;
    String SettlementNo;
    String OrderDate;
    String SchemeCode;
    String ISIN;
    Double Amount;
    Double Quantity;
    @Column(columnDefinition = "varchar(10) default '6670'")
    String MemberId;
    @Column(columnDefinition = "varchar(10) default '667001'")
    String UserId;
    String BranchCode;
    String FolioNo;
    String RTASchemeCode;
    String RTATransNo;
    String ClientId;
    String ClientName;
    String BeneficiaryId;
    Double AllottedNAV;
    Double AllottedUnit;
    Double AllotmentAmount;
    String ValidFlag;
    String Remarks;
    String STT;
    String InternalRefNo;
    String OrderType;
    String SIPRegnNo;
    String SIPRegnDate;
    String SubBrCode;
    String EUIN;
    String EUINDecl;
    String DPCFlag;
    String DPTrans;
    String OrderSubType;
}
