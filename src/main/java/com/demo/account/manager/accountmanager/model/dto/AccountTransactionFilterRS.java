package com.demo.account.manager.accountmanager.model.dto;

import com.demo.account.manager.accountmanager.util.AppsConstants;

import java.math.BigDecimal;

public class AccountTransactionFilterRS {

    private Integer accountTransactionID;

    private Integer accountID;

    private String accountNumber;

    private String transactionDateTimeStr;

    private AppsConstants.TransactionType transactionType;

    private BigDecimal transactionAmount;

    public Integer getAccountTransactionID() {
        return accountTransactionID;
    }

    public void setAccountTransactionID(Integer accountTransactionID) {
        this.accountTransactionID = accountTransactionID;
    }

    public Integer getAccountID() {
        return accountID;
    }

    public void setAccountID(Integer accountID) {
        this.accountID = accountID;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getTransactionDateTimeStr() {
        return transactionDateTimeStr;
    }

    public void setTransactionDateTimeStr(String transactionDateTimeStr) {
        this.transactionDateTimeStr = transactionDateTimeStr;
    }

    public AppsConstants.TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(AppsConstants.TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(BigDecimal transactionAmount) {
        this.transactionAmount = transactionAmount;
    }
}
