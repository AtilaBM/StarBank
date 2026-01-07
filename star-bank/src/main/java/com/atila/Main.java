package com.atila;

import java.text.SimpleDateFormat;
import java.util.Scanner;

import com.atila.service.BankService;
import com.atila.view.Menu;

public class Main {

    private   static  BankService bankService = new BankService();
    private   static  Menu menu = new Menu();

    public static void main(String[] args) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);

        boolean active = false;

        while (!active) {
           menu.inicialMenu();
           Integer op = sc.nextInt();

           switch (op) {
            case 1:
                
                break;
            case 2:
                
                break;
            case 3:
                
                break;
            case 0:
                System.out.println("Exiting...");
                return;
            default:
                System.out.println("INVALID");
                break;
           }
        }

        sc.close();
    }

}