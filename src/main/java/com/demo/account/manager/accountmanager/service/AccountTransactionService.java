package com.demo.account.manager.accountmanager.service;

import com.demo.account.manager.accountmanager.dao.AccountTransactionJDBCDao;
import com.demo.account.manager.accountmanager.model.dto.AccountTransactionFilterRQ;
import com.demo.account.manager.accountmanager.model.dto.AccountTransactionFilterRS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.List;

@Service
public class AccountTransactionService {

    @Autowired
    private AccountTransactionJDBCDao accountTransactionJDBCDao;

    @Transactional(propagation = Propagation.SUPPORTS)
    public List<AccountTransactionFilterRS> getAccountTransactionByFilterRQ(AccountTransactionFilterRQ filterRQ) throws ParseException {
        return this.accountTransactionJDBCDao.getAccountTransactionByFilterRQ(filterRQ);
    }
}
