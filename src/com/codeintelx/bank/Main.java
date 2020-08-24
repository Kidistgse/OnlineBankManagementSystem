package com.codeintelx.bank;

import com.codeintelx.bank.models.Account;
import com.codeintelx.bank.services.AccountDoesnotexist;
import com.codeintelx.bank.services.AccountServices;

import java.util.Scanner;

public class Main {
    public static com.codeintelx.bank.services.AccountServices AccountServices = new AccountServices();

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
                    String accountId = input.next();

                        //TODO move lines 11-46 to account services
                    try {
                        user = AccountServices.viewAccount(accountId);
                        display(user);
                    }catch (AccountDoesnotexist e)
                    {
                        System.out.println("account does not exist");
                        break;
                    }

                        break;
                case 3:
                    System.out.println("Selected 3 to withdraw from an account");
                    System.out.println("Enter Account ID");
                    accountId = input.next();

                    System.out.println("enter withdrawal amount");
                    withdrawAmount = input.nextDouble();
                   try {
                       user = AccountServices.withdrawMoney(withdrawAmount, accountId);
                   }
                   catch (LowBalance e)
                   {
                        System.out.println("low balance"+e);
                   }


                    break;
                case 4:
                     System.out.println("Selected: 4 to deposit to an account");
                     System.out.println("Enter Account ID");
                     accountId = input.next();
                     System.out.println("enter Deposit amount");
                     depositAmount = input.nextDouble();
                     user=AccountServices.depositMoney(depositAmount, accountId);
                    System.out.println("deposit amount "+depositAmount+" new balance: "+user.getAccountBalance());
                     break;
                 case 5:
                     System.out.println("Enter Account ID");
                     accountId = input.next();
                    user= AccountServices.closeAccount(accountId);
                     System.out.println("your account has been successfully canceled "+user.getAccountname());

                     break;
                 case 6:
                     System.out.println("good bye");
                     break;
                  default:
                            // code block
                    }
        } while (service != 6);
    }
        public static void createAccount ()
        {
            Scanner input = new Scanner(System.in);
            String accountType;
            String accountName;
            double depositAmount;

            System.out.println("Thank you for using online Bank management system:" + '\n' + "Enter checking  to create a checking account and saving to create a savings account.");
            accountType = input.nextLine();
            while (!accountType.equals("checking") && !accountType.equals("saving")) {
                System.out.println("INVALID ACCOUNT TYPE: Enter checking  to create a checking account and saving to create a savings account.");
                accountType = input.nextLine();
            }

            System.out.println("enter account name");
            accountName = input.nextLine();

            System.out.println("enter deposit amount");
            depositAmount = input.nextDouble();

            Account user = AccountServices.createAccount(accountName, accountType, depositAmount);

            System.out.println("account successfully created: here is your account Id " + user.getAccountID());

            System.out.println("Account name: " + user.getAccountname());
            System.out.println("Account type: " + user.getAccountType());
            System.out.println("Account balance: " + user.getAccountBalance());

        }
        public static void display (Account user)
        {

            System.out.println("Account name: " + user.getAccountname());
            System.out.println("Account type: " + user.getAccountType());
            System.out.println("Account balance: " + user.getAccountBalance());

        }
    }







