package com.demo.account.manager.accountmanager.controller;

import com.demo.account.manager.accountmanager.model.dto.ResponseDTO;
import com.demo.account.manager.accountmanager.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping(value = "account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/getAccountLatestBalance/{accountNumber}", headers = "Accept=application/json", method = RequestMethod.GET)
    public ResponseEntity<ResponseDTO<BigDecimal>> getUserDTO(@PathVariable String accountNumber) {

        ResponseDTO<BigDecimal> response = new ResponseDTO<>();
        BigDecimal latestBalance = null;

        try {
            latestBalance = this.accountService.getAccountLatestBalance(accountNumber);

            response.setStatus("SUCCESS");
        } catch (Exception e) {
            response.setStatus("FAILED");
        }

        response.setResult(latestBalance);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
