package com.demo.account.manager.accountmanager.util;

public class AppsConstants {

    public enum TransactionType {
        DEPOSIT("Deposit"),
        WITHDRAW("Withdraw");

        private String description;

        TransactionType(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }
}
