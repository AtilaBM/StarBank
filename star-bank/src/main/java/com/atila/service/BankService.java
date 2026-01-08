package com.atila.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.atila.enums.Category;
import com.atila.enums.Status;
import com.atila.model.Account;
import com.atila.model.CheckingAccount;
import com.atila.model.Client;
import com.atila.model.SavingAccount;

public class BankService {
    private List<Account> accounts = new ArrayList<>();
    private Integer nextAccountNumber = 1000;

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

    public void transfer(Account a, Account b, double amount) {
        if (amount <= 0.0) {
            throw new IllegalArgumentException("Amount invalid");
        }
        a.withdraw(amount);
        b.deposit(amount);
    }

    public Integer nextAccountNumber() {
        return this.nextAccountNumber++;
    }

    public void createSavingAccount(Scanner sc) {

        System.out.print("Name: ");
        sc.nextLine();
        String name = sc.nextLine();
        System.out.print("age: ");
        Integer age = sc.nextInt();
        System.out.print("CPF: ");
        String cpf = sc.next();
        System.out.print("Phone: ");
        String phone = sc.next();
        sc.nextLine();
        System.out.println("═════════════════════");
        System.out.print("User: ");
        String user = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();

        Status status = Status.ACTIVE;
        Category category = Category.SAVING;

        Client client = new Client(name, age, cpf, phone);

        SavingAccount savingAccount = new SavingAccount(nextAccountNumber, 0, new  Date(), client, status, category, user, password);

        addAccount(savingAccount);

        System.out.println();
        System.out.println("Account Criated!!!");

    }

    public void createCheckingAccount(Scanner sc) {

        System.out.print("Name: ");
        sc.nextLine();
        String name = sc.nextLine();
        System.out.print("age: ");
        Integer age = sc.nextInt();
        System.out.print("CPF: ");
        String cpf = sc.next();
        System.out.print("Phone: ");
        String phone = sc.next();
        sc.nextLine();
        
        System.out.println("═════════════════════");
        System.out.print("User: ");
        String user = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();

        Status status = Status.ACTIVE;
        Category category = Category.CHECKING;

        Client client = new Client(name, age, cpf, phone);

        CheckingAccount checkingAccount = new CheckingAccount(nextAccountNumber, 0, new  Date(), client, status, category, user, password);

        addAccount(checkingAccount);
        
        System.out.println();
        System.out.println("Account Criated!!!");

    }

    public void seeAllAccounts() {
        for (Account account : accounts) {
            if (account.getStatus().equals(Status.CLOSED)) {
                continue;
            }
            System.out.println(account);
        }
    }

    public Account searchAccount(Scanner sc) {

        System.out.print("Search by account number or cpf(1/2): ");
        Integer op = sc.nextInt();

        if (op == 1) {
            System.out.print("Enter Account Number: ");
            Integer accountNumber = sc.nextInt();
            return searchAccountByNumber(accountNumber);
        } else if (op == 2) {
            System.out.print("Enter CPF: ");
            String cpf = sc.next();
            return searchAccountByCpf(cpf);
        } else {
            throw new IllegalArgumentException("Option invalid");
        }

    }

    public void testAccounts() {
        // Conta 1 - João
        Client client1 = new Client("Joao Silva", 28, "12345678901", "11987654321");
        SavingAccount acc1 = new SavingAccount(
                nextAccountNumber(), 500.0, new Date(),
                client1, Status.ACTIVE, Category.SAVING, "joao", "joao123");
        addAccount(acc1);

        // Conta 2 - Maria
        Client client2 = new Client("Maria Santos", 35, "98765432100", "21976543210");
        CheckingAccount acc2 = new CheckingAccount(
                nextAccountNumber(), 1000.0, new Date(),
                client2, Status.ACTIVE, Category.CHECKING, "maria", "maria123");
        addAccount(acc2);

        // Conta 3 - Pedro
        Client client3 = new Client("Pedro Costa", 42, "55566677788", "11955667788");
        SavingAccount acc3 = new SavingAccount(
                nextAccountNumber(), 250.0, new Date(),
                client3, Status.ACTIVE, Category.SAVING, "pedro", "pedro123");
        addAccount(acc3);

    }

    public Account login(String user, String password) {
        if (user == null || password == null) {
            throw new IllegalArgumentException("User or password cannot be null");

        }
        for (Account account : accounts) {
            if (account.getUser().equals(user) && account.getPassword().equals(password)) {
                return account;
            }
        }
        throw new IllegalArgumentException("Account not found");
    }
}
