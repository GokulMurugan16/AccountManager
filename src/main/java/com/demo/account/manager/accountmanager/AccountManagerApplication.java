package com.demo.account.manager.accountmanager;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.demo.account.manager.accountmanager.model.domain")
public class AccountManagerApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(AccountManagerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
