package com.atila.model;

import java.util.Date;

import com.atila.enums.Category;
import com.atila.enums.Status;

public final class CheckingAccount extends Account {

    private double withdrawFee = 0.10;
    private double dailyWithdrawLimit = 0.0;// MAX 2000.00

    public CheckingAccount(Integer accountNumber, double balance, Date date, Client client, Status status,
            Category category,String user,String password) {
        super(accountNumber, balance, date, client, status, category, user, password);

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
        if (status == Status.CLOSED) {
            throw new IllegalArgumentException("This account is closed");
        }
        balance += amount;
    }

    @Override
    public void withdraw(double amount) {
        if (dailyWithdrawLimit > 2000.00) {
            throw new IllegalArgumentException("Daily withdraw limit reached");

        }
        if (amount <= 0.0 || amount > balance) {
            throw new IllegalArgumentException("Amount invalid");
        }
        if (status == Status.CLOSED) {
            throw new IllegalArgumentException("This account is closed");
        }
        balance -= amount + (amount * withdrawFee);
        dailyWithdrawLimit += amount;
    }

}
