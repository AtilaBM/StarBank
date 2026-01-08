package com.atila.model;

import com.atila.enums.Status;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.atila.enums.Category;

public abstract class Account {

    protected Integer accountNumber;
    protected double balance;
    private Date date;
    protected String user;
    protected String password;

    protected Client client;
    protected Status status;
    protected Category category;

    public Account(Integer accountNumber, double balance, Date date, Client client, Status status, Category category,
            String user, String password) {

        if (accountNumber == null || accountNumber <= 0) {
            throw new IllegalArgumentException("Invalid account number");
        }
        if (date == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }
        if (client == null) {
            throw new IllegalArgumentException("Client cannot be null");
        }
        if (status == null) {
            throw new IllegalArgumentException("Status cannot be null");
        }
        if (category == null) {
            throw new IllegalArgumentException("Category cannot be null");
        }
        if (user == null) {
            throw new IllegalArgumentException("Category cannot be null");
        }
        if (password == null) {
            throw new IllegalArgumentException("Category cannot be null");
        }

        this.accountNumber = accountNumber;
        this.balance = balance;
        this.date = date;
        this.client = client;
        this.status = status;
        this.category = category;
        this.user = user;
        this.password = password;

    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Date getDate() {
        return date;
    }

    public Client getClient() {
        return client;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Category getCategory() {
        return category;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public abstract void deposit(double amount);

    public abstract void withdraw(double amount);

    @Override
    public String toString() {
        String line = "─".repeat(60);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        return String.format("""
                %s
                ACCOUNT DETAILS
                %s
                User : %s
                Account Number : %d
                Balance        : R$ %.2f
                Opening Date   : %s
                Status         : %s
                Category       : %s
                Client         : %s
                %s""",
                line,
                line,
                user,
                accountNumber,
                balance,
                dateFormat.format(date),
                status,
                category,
                client.toString(),
                line);
    }

}
