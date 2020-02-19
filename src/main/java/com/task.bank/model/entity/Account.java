package com.task.bank.model.entity;

public class Account {
    int accountId;
    int account;
    int userId;

    public Account(int accountId, int account, int userId) {
        this.accountId = accountId;
        this.account = account;
        this.userId = userId;
    }

    public Account() {
    }

    public int getAccountId() {
        return accountId;
    }

    public int getAccount() {
        return account;
    }

    public int getUserId() {
        return userId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
