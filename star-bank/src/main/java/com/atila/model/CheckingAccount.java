package com.atila.model;

import java.util.Date;

import com.atila.enums.Category;
import com.atila.enums.Status;

public final class CheckingAccount extends Account {

    private double withdrawFee = 0.10;
    private double dailyWithdrawLimit = 2000.00;

    public CheckingAccount(Integer accountNumber, double balance, Date date, Client client, Status status,
            Category category, double withdrawFee, double dailyWithdrawLimit) {
        super(accountNumber, balance, date, client, status, category);
        this.withdrawFee = withdrawFee;
        this.dailyWithdrawLimit = dailyWithdrawLimit;
    }

    public double getWithdrawFee() {
        return withdrawFee;
    }

    public double getDailyWithdrawLimit() {
        return dailyWithdrawLimit;
    }

    @Override
    public void deposit(double amount) {
        if (amount <= 0.0) {
            throw new IllegalArgumentException("Amount invalid");
        }
        balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0.0) {
            throw new IllegalArgumentException("Amount invalid");
        }
        balance -= amount - (amount * withdrawFee);
    }

}
