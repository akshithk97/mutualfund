package com.aliceblue.mutualfund.v3.model;

import com.aliceblue.mutualfund.v3.model.util.BaseModel;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "mf_password")
@Getter
public class MFPassword extends BaseModel {

    @Column(name = "password", nullable = false)
    String password;
}
