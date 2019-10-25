package com.eluon.nu.activityhistory.api.ActivityHistory.model;

import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "transaction")
public class TransactionDetails {
    @Id
    @GeneratedValue
    private String trx_id;
    @Column(nullable = false)
    private String user_id;
    @Column(nullable = false)
    private String calling_type;
    @Column(nullable = false)
    private String information;

    public String getTrx_id() {
        return trx_id;
    }
    public void setTrx_id(String trx_id) {
        this.trx_id = trx_id;
    }

    public String getCalling_type() {
        return calling_type;
    }

    public void setCalling_type(String calling_type) {
        this.calling_type = calling_type;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
