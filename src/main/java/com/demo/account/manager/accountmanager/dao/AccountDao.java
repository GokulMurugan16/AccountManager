package com.demo.account.manager.accountmanager.dao;

import com.demo.account.manager.accountmanager.model.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDao extends JpaRepository<Account, Integer> {

    Account findByAccountNumber(String accountNumber);
}
