package com.demo.account.manager.accountmanager.model.domain;

import com.demo.account.manager.accountmanager.util.AppsConstants;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "t_account_transaction")
public class AccountTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name = "ACCOUNT_TRANSACTION_ID")
    private Integer accountTransactionID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_ID")
    private Account account;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TRANSACTION_DATE_TIME")
    private Date transactionDateTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "TRANSACTION_TYPE")
    private AppsConstants.TransactionType transactionType;

    @Column(name = "TRANSACTION_AMOUNT")
    private BigDecimal transactionAmount;

    public Integer getAccountTransactionID() {
        return accountTransactionID;
    }

    public void setAccountTransactionID(Integer accountTransactionID) {
        this.accountTransactionID = accountTransactionID;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Date getTransactionDateTime() {
        return transactionDateTime;
    }

    public void setTransactionDateTime(Date transactionDateTime) {
        this.transactionDateTime = transactionDateTime;
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
