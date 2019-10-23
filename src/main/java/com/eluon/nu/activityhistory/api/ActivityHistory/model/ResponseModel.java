package com.eluon.nu.activityhistory.api.ActivityHistory.model;

import org.springframework.stereotype.Repository;

@Repository
public class ResponseModel {
    private int response_code;
    private String response_message;

    public ResponseModel() {
    }

    public ResponseModel(int response_code, String response_message) {
        this.response_code = response_code;
        this.response_message = response_message;
    }

    public int getResponse_code() {
        return response_code;
    }

    public void setResponse_code(int response_code) {
        this.response_code = response_code;
    }

    public String getResponse_message() {
        return response_message;
    }

    public void setResponse_message(String response_message) {
        this.response_message = response_message;
    }
}
