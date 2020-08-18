package com.codeintelx.bank;

import com.codeintelx.bank.models.Account;
import com.codeintelx.bank.services.AccountServices;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.lang.Math;

public class Main {
   public static AccountServices accountServices = new AccountServices();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int service;
        double withdrawAmount;
        double depositAmount;
        Account user;
        do {
            System.out.println("Enter 1 to create an account");
            System.out.println("Enter 2 to view account by account number");
            System.out.println("Enter 3 to withdraw from an account");
            System.out.println("Enter 4 to deposit to an account");
            System.out.println("Enter 5 to deposit to cancel account");
            System.out.println("Enter 6 to quit");

            service = input.nextInt();

           while (service < 1 || service > 6) {
              System.out.println("invalid input, please select options 1 - 4");
              service = input.nextInt();
           }
            switch (service) {
                case 1:
                    System.out.println("Selected 1 to create an account");
                    createAccount();
                    break;
                case 2:
                    System.out.println("enter account ID to view account by account number");
                    String accountId=input.next();
                    while (accountServices.searchAccount(accountId) == null) {
                        System.out.println("invalid Account ID: please enter correct account ID");
                        accountId = input.next();
                    }
                    user= accountServices.viewAccount(accountId);
                    display(user);
                    break;
                case 3:
                    System.out.println("Selected 3 to withdraw from an account");
                    System.out.println("Enter Account ID");
                    accountId=input.next();

                    System.out.println("enter withdrawl ammount");
                    withdrawAmount=input.nextDouble();
                   accountServices.withdrawMoney(withdrawAmount,accountId);

                    break;
                case 4:
                    System.out.println("Selected: 4 to deposit to an account");
                    System.out.println("Enter Account ID");
                    accountId=input.next();
                    System.out.println("enter Deposit ammount");
                    depositAmount=input.nextDouble();
                    accountServices.depositMoney(depositAmount,accountId);
                    break;
                case 5:
                    System.out.println("Enter Account ID");
                    accountId=input.next();
                    accountServices.cancelation(accountId);
                    break;
                case 6:
                    System.out.println("good bye");
                    break;
                default:
                    // code block
            }
        }while(service !=6);
    }
    public static void createAccount ()
    {
        Scanner input = new Scanner(System.in);
        String accountType;
        String accountName;
        double depositAmount;

        System.out.println("Thank you for using online Bank management system:"+'\n'+"Enter checking  to create a checking account and saving to create a savings account.");
        accountType=input.nextLine();
        while (!accountType.equals("checking")&& !accountType.equals("saving"))
        {
            System.out.println("INVALID ACCOUNT TYPE: Enter checking  to create a checking account and saving to create a savings account.");
            accountType=input.nextLine();
        }

        System.out.println("enter account name");
        accountName =input.nextLine();

        System.out.println("enter deposit amount");
        depositAmount =input.nextDouble();

        Account user=accountServices.createAccount(accountName,accountType,depositAmount);
        display(user);

    }
    public static void display(Account user)
    {

        System.out.println("Account name: "+user.getAccountname());
        System.out.println("Account type: "+user.getAccountType());
        System.out.println("Account balance: "+user.getAccountBalance());

    }
    }






