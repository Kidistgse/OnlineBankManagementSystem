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
       // List<Account> accountInformation =new ArrayList();

//        accountServices.createAccount("1", "kidist,", "savings", 2);
//        accountServices.createAccount("2", "jackie,", "savings", 8);
//        accountServices.createAccount("7", "asjley,", "savings", 80);
//        accountServices.searchAccount("2");
   //     display(accountInformation,0);
        do {
            System.out.println("Enter 1 to create an account");
            System.out.println("Enter 2 to view account by account number");
            System.out.println("Enter 3 to withdraw from an account");
            System.out.println("Enter 4 to deposit to an account");
             service = input.nextInt();

           while (service < 1 || service > 5) {
              System.out.println("invalid input, please select options 1 - 4");
              service = input.nextInt();
           }
            switch (service) {
                case 1:
                    System.out.println("Selected 1 to create an account");
                    createAccount();
                   // accountServices.createAccount (accountID, accountName, accountType, depositAmount);

                    break;
                case 2:
                   // boolean match = false;
                    System.out.println("enter account ID to view account by account number");
                    int accountId=input.nextInt();
                    accountServices.viewAccount(accountId);

//                    for(int i =0; i<accountServices.accountSize(); i++)
//                    {
//                        match = accountServices.search(accountId,i);
//                        if (match==true)
//                        {
//                           match=true;
//                           System.out.println("hi");
//                           //display(i);
//                            break;
//                        }
//                    }
                    //accountServices.viewAccount(accountID);
                    break;
                case 3:
                    System.out.println("Selected 3 to withdraw from an account");
                    System.out.println("Enter Account ID");
                    accountId=input.nextInt();

                    System.out.println("enter withdrawl ammount");
                    withdrawAmount=input.nextDouble();
                    accountServices.withdrawMoney(withdrawAmount,accountId);

                    break;
                case 4:
                    System.out.println("Selected: 4 to deposit to an account");
                    System.out.println("Enter Account ID");
                    accountId=input.nextInt();
                    System.out.println("enter Deposit ammount");
                    depositAmount=input.nextDouble();
                    accountServices.depositMoney(depositAmount,accountId);
                    break;
                case 5:
                    System.out.println("good bye");
                    break;
                default:
                    // code block
            }
        }while(service !=5);
    }
    public static void createAccount ()
    {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        String accountType;
        String accountName;
        double depositAmount;
        int accountID = rand.nextInt(1000);

        System.out.println("Thank you for using online Bank management system:"+'\n'+"Enter checking  to create a checking account and saving to create a savings account.");
        accountType=input.nextLine();


        System.out.println("enter account name");
        accountName =input.nextLine();

        System.out.println("enter deposit amount");
        depositAmount =input.nextDouble();

        accountServices.createAccount(accountID,accountName,accountType,depositAmount);
        System.out.println("you have finished signing up, your new account number is: " + accountID);

    }
    public static void display(List<Account> customer, int accountIndex)
    {

        System.out.println(customer.get(accountIndex).getAccountID());
        System.out.println(customer.get(accountIndex).getAccountname());
        System.out.println(customer.get(accountIndex).getAccountType());
        System.out.println(customer.get(accountIndex).getAccountBalance());

    }
    }






