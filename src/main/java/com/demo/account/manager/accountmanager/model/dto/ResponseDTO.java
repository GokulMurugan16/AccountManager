package com.demo.account.manager.accountmanager.model.dto;

public class ResponseDTO<T> {

    private String status;

    private T result;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
