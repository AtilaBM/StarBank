package com.atila.service;

import java.util.ArrayList;
import java.util.List;

import com.atila.model.Account;

public class BankService {
    private List<Account> accounts = new ArrayList<>();

    public void addAccount(Account account) {
        for (Account existingAccounts : accounts) {
            if (account.getClient().getCpf().equals(existingAccounts.getClient().getCpf())) {
                throw new IllegalArgumentException("This CPF already exists");
            }
        }
        accounts.add(account);
    }

    public void removeAccount(Account account) {
        accounts.remove(account);
    }

    public Account searchAccountByNumber(Integer number) {

        if (number == null) {
            throw new IllegalArgumentException("Account number cannot be null");
        }
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(number)) {
                return account;
            }
        }
        throw new IllegalArgumentException("Account not found");
    }

    public Account searchAccountByCpf(String cpf) {

        if (cpf == null) {
            throw new IllegalArgumentException("Account cpf cannot be null");
        }
        for (Account account : accounts) {
            if (account.getClient().getCpf().equals(cpf)) {
                return account;
            }
        }
        throw new IllegalArgumentException("Account not found");
    }

    public void tranfer(Account a,Account b,double amount){
        if (amount <= 0.0) {
            throw new IllegalArgumentException("Amount invalid");
        }
        a.withdraw(amount);
        b.deposit(amount);
    }
}
