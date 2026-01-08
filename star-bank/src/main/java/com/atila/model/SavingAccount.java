package com.atila.model;

import java.util.Date;

import com.atila.enums.Category;
import com.atila.enums.Status;

public final class SavingAccount extends Account {

    private double interestRate = 0.15;
    private Integer withdrawLimit = 0;//Max 5

    public SavingAccount(Integer accountNumber, double balance, Date date, Client client, Status status,
            Category category,String user,String password) {
        super(accountNumber, balance, date, client, status, category, user, password);
    }

    public double getInterestRate() {
        return interestRate;
    }

    public Integer getWithdrawLimit() {
        return withdrawLimit;
    }

    @Override
    public void deposit(double amount) {
        if (amount <= 0.0) {
            throw new IllegalArgumentException("Amount invalid");
        }
        if (status == Status.CLOSED) {
            throw new IllegalArgumentException("This account is closed");
        }
        balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        if (withdrawLimit >5) {
            throw new IllegalArgumentException("Withdrawal limit reached");
        }
        if (amount <= 0.0 || amount > balance) {
            throw new IllegalArgumentException("Amount invalid");
        }
        if (status == Status.CLOSED) {
            throw new IllegalArgumentException("This account is closed");
        }
        balance -= amount;
        withdrawLimit++;
    }

    public void calculateInterest() {
        balance += balance * interestRate;
    }
}
