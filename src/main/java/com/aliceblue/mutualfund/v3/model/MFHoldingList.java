package com.aliceblue.mutualfund.v3.model;

import com.aliceblue.mutualfund.v3.model.util.BaseModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "mf_holding_list")
@Getter
@Setter
public class MFHoldingList extends BaseModel {

    @Column(nullable = false, unique = true)
    String UniqueReferenceNumber;
    @Column(nullable = false)
    String OrderId;
    String RefNo;
    String OrderRefNo;
    @Column(nullable = false)
    String AllottedDate;
    @Column(nullable = false)
    String SchemeCode;
    @Column(nullable = false)
    String ClientId;
    @Column(nullable = false)
    String AllottedNAV;
    @Column(nullable = false)
    String AllottedUnit;
}
