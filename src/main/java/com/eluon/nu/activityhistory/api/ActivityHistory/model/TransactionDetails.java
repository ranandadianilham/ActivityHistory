package com.eluon.nu.activityhistory.api.ActivityHistory.model;

import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;

@Repository
public class TransactionDetails {
    @NotNull(message = "user type cannot be null")
    private String user_type;
    @NotNull(message = "trx_id cannot be null")
    private String trx_id;
    @NotNull(message = "service_id cannot be null")
    private String service_id;
    @NotNull(message = "service_message cannot be null")
    private String service_message;
    @NotNull(message = "user id cannot be null")
    private String user_id;

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public String getTrx_id() {
        return trx_id;
    }

    public void setTrx_id(String trx_id) {
        this.trx_id = trx_id;
    }

    public String getService_id() {
        return service_id;
    }

    public void setService_id(String service_id) {
        this.service_id = service_id;
    }

    public String getService_message() {
        return service_message;
    }

    public void setService_message(String service_message) {
        this.service_message = service_message;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
