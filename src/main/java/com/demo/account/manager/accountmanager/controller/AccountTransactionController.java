package com.demo.account.manager.accountmanager.controller;

import com.demo.account.manager.accountmanager.model.dto.AccountTransactionFilterRQ;
import com.demo.account.manager.accountmanager.model.dto.AccountTransactionFilterRS;
import com.demo.account.manager.accountmanager.model.dto.ResponseDTO;
import com.demo.account.manager.accountmanager.service.AccountTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "account-transaction")
public class AccountTransactionController {

    @Autowired
    private AccountTransactionService accountTransactionService;

    @RequestMapping(value = "/getAccountTransactionByFilterRQ", headers = "Accept=application/json", method = RequestMethod.POST)
    public ResponseEntity<ResponseDTO<List<AccountTransactionFilterRS>>> getUserDTO(@RequestBody AccountTransactionFilterRQ filterRQ) {

        ResponseDTO<List<AccountTransactionFilterRS>> response = new ResponseDTO<>();
        List<AccountTransactionFilterRS> transactionFilterRS = null;

        try {
            transactionFilterRS = this.accountTransactionService.getAccountTransactionByFilterRQ(filterRQ);

            response.setStatus("SUCCESS");
        } catch (Exception e) {
            response.setStatus("FAILED");
        }

        response.setResult(transactionFilterRS);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
