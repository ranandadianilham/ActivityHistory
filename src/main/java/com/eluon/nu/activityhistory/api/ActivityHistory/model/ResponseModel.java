package com.eluon.nu.activityhistory.api.ActivityHistory.model;

import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class ResponseModel {
    private int response_code;
    private String response_message;
    private List<Object> data;

    public List<Object> getData() {
        return data;
    }

    public void setData(List<Object> data) {
        this.data = data;
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
