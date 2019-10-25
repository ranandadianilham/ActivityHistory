package com.eluon.nu.activityhistory.api.ActivityHistory.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "transaction")
public class TransactionDetailsEntity implements Serializable {

    private static final long serialVersionUID = 4678625221653324446L;
    @Id
    @GeneratedValue
    private String trx_id;
    @Column(nullable = false)
    private String calling_date;
    @Column(nullable = false)
    private String calling_time;
    @Column(nullable = false)
    private String user_id;
    @Column(nullable = false)
    private String user_type;
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

    public String getCalling_date() {
        return calling_date;
    }

    public void setCalling_date(String calling_date) {
        this.calling_date = calling_date;
    }

    public String getCalling_time() {
        return calling_time;
    }

    public void setCalling_time(String calling_time) {
        this.calling_time = calling_time;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
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
}
