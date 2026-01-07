package com.atila.model;

import java.util.Date;

import com.atila.enums.Category;
import com.atila.enums.Status;

public final class SavingsAccount extends Account {

    private double interestRate = 0.15;
    private Integer withdrawLimit = 5;

    public SavingsAccount(Integer accountNumber, double balance, Date date, Client client, Status status,
            Category category, double interestRate, Integer withdrawLimit) {
        super(accountNumber, balance, date, client, status, category);
        this.interestRate = interestRate;
        this.withdrawLimit = withdrawLimit;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public Integer getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(Integer withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
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

    }
}
