package com.demo.account.manager.accountmanager.model.dto;

import com.demo.account.manager.accountmanager.util.AppsConstants;

public class AccountTransactionFilterRQ {

    private String accountNumber;

    private String transactionFromDateStr;

    private String transactionToDateStr;

    private AppsConstants.TransactionType transactionType;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getTransactionFromDateStr() {
        return transactionFromDateStr;
    }

    public void setTransactionFromDateStr(String transactionFromDateStr) {
        this.transactionFromDateStr = transactionFromDateStr;
    }

    public String getTransactionToDateStr() {
        return transactionToDateStr;
    }

    public void setTransactionToDateStr(String transactionToDateStr) {
        this.transactionToDateStr = transactionToDateStr;
    }

    public AppsConstants.TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(AppsConstants.TransactionType transactionType) {
        this.transactionType = transactionType;
    }
}
