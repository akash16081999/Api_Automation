package com.api.models.request.payloads;

import java.util.List;

public class TransactionControllerReqPayload {

    private String accountNumber;
    private double amount;
    private String description;
    private String fromAccount;
    private String toAccount;


    private TransactionControllerReqPayload(String accountNumber, double amount, String description, String fromAccount, String toAccount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.description = description;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;

    }

    private List<TransactionControllerReqPayload> content;

    public void setContent(List<TransactionControllerReqPayload> content) {
        this.content = content;
    }

    public List<TransactionControllerReqPayload> getContent() {
        return content;
    }

//    TransactionControllerPayload(String fromAccount, String toAccount, double amount, String description) {
//        this.fromAccount = fromAccount;
//        this.toAccount = toAccount;
//        this.amount = amount;
//        this.description = description;
//
//    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(String fromAccount) {
        this.fromAccount = fromAccount;
    }

    public String getToAccount() {
        return toAccount;
    }

    public void setToAccount(String toAccount) {
        this.toAccount = toAccount;
    }

    public static class Builder {

        private String accountNumber;
        private double amount;
        private String description;
        private String fromAccount;
        private String toAccount;


        public Builder setAccountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
            return this;
        }

        public Builder setAmount(double amount) {
            this.amount = amount;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setFromAccount(String fromAccount) {
            this.fromAccount = fromAccount;
            return this;
        }

        public Builder setToAccount(String toAccount) {
            this.toAccount = toAccount;
            return this;
        }

        public TransactionControllerReqPayload build() {
            return new TransactionControllerReqPayload(accountNumber, amount, description, fromAccount, toAccount);

        }
    }


}
