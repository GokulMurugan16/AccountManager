package com.demo.account.manager.accountmanager.service;

import com.demo.account.manager.accountmanager.dao.AccountDao;
import com.demo.account.manager.accountmanager.model.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class AccountService {

    @Autowired
    private AccountDao accountDao;

    @Transactional(propagation = Propagation.SUPPORTS)
    public BigDecimal getAccountLatestBalance(String accountNumber) throws Exception {
        Account account = this.accountDao.findByAccountNumber(accountNumber);
        return account.getBalance();
    }
}
