package com.atila;

import java.util.Scanner;

import com.atila.enums.*;

import com.atila.model.*;
import com.atila.service.BankService;
import com.atila.view.Menu;

public class Main {

    private static BankService bankService = new BankService();
    private static Menu menu = new Menu();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean active = true;

        bankService.testAccounts();

        while (active) {
            menu.inicialMenu();
            Integer op = sc.nextInt();

            switch (op) {
                case 1:
                    bankService.createSavingAccount(sc);
                    break;
                case 2:
                    bankService.createCheckingAccount(sc);
                    break;
                case 3:
                    active = false;
                    break;
                case 0:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Option invalid");
                    break;
            }
        }

        active = true;

        System.out.println("\n════════════════════════════════════");
        System.out.println("          LOGIN");
        System.out.println("════════════════════════════════════");
        System.out.print("User: ");
        String user = sc.next();
        System.out.print("Password: ");
        String password = sc.next();

        Account account = bankService.login(user, password);

        if (account != null) {
            while (active) {
                menu.principalMenu();
                Integer op = sc.nextInt();

                switch (op) {
                    case 1:
                        // Account account = bankService.searchAccount(sc);

                        System.out.println("DEPOSIT:");
                        System.out.print("Value to deposit: ");
                        double amount = sc.nextDouble();
                        account.deposit(amount);

                        break;
                    case 2:
                        // account = bankService.searchAccount(sc);
                        System.out.println("WITHDRAW:");
                        System.out.print("Value to withdraw: ");
                        amount = sc.nextDouble();
                        account.withdraw(amount);

                        break;
                    case 3:
                        // account = bankService.searchAccount(sc);

                        if (account.getCategory().equals(Category.SAVING)) {
                            SavingAccount savingAccount = (SavingAccount) account;
                            savingAccount.calculateInterest();
                            System.out.println(account.toString());
                        } else {

                            System.out.println(account.toString());
                        }

                        break;
                    case 4:
                        System.out.println("Receive:");
                        Account accountB = bankService.searchAccount(sc);

                        System.out.printf("%s what value you want to tranfer to %s: $", account.getClient().getName(),
                                accountB.getClient().getName());
                        amount = sc.nextDouble();

                        bankService.transfer(account, accountB, amount);

                        break;
                    case 5:
                        bankService.seeAllAccounts();
                        break;
                    case 6:
                        menu.changeInfoMenu();
                        op = sc.nextInt();
                        // account = bankService.searchAccount(sc);
                        switch (op) {
                            case 1:
                                System.out.print("Enter the new Name:");
                                String newName = sc.next();
                                account.getClient().setName(newName);

                                System.out.println();
                                System.out.println("Name changed!!!");
                                break;
                            case 2:
                                System.out.print("Enter the new Age:");
                                Integer newAge = sc.nextInt();
                                account.getClient().setAge(newAge);

                                System.out.println();
                                System.out.println("Age changed!!!");
                                break;
                            case 3:
                                System.out.print("Enter the new Phone:");
                                String newPhone = sc.next();
                                account.getClient().setPhone(newPhone);

                                System.out.println();
                                System.out.println("Phone changed!!!");
                                break;
                            case 4:
                                System.out.print("Enter the new User:");
                                String newUser = sc.next();
                                account.setUser(newUser);

                                System.out.println();
                                System.out.println("User changed!!!");
                                break;
                            case 0:
                                System.out.println("Exiting...");
                                break;

                            default:
                                System.out.println("Option invalid");
                                break;
                        }

                        break;
                    case 7:
                        // account = bankService.searchAccount(sc);

                        account.setStatus(Status.CLOSED);
                        break;
                    case 0:
                        System.out.println("Exiting...");
                        active = false;
                        break;
                    default:
                        System.out.println("Option invalid");
                        break;
                }
            }
        } else {
            System.out.println("LOGIN INVALID!");
        }

        sc.close();
    }

}