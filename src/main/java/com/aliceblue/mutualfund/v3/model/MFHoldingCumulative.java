package com.aliceblue.mutualfund.v3.model;

import com.aliceblue.mutualfund.v3.model.util.BaseModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "mf_holding_cumulative")
@Getter @Setter
public class MFHoldingCumulative extends BaseModel {

    @Column(unique = true, nullable = false)
    String UniqueReferenceNumber;
    String ClientId;
    String SchemeCode;
    String Unit;

}
