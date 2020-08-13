package com.codeintelx.bank.services;


import com.codeintelx.bank.models.Account;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class AccountServices {
    Scanner input = new Scanner(System.in);
    List<Account> customer = new ArrayList<>();

    public void createAccount(int accountID, String accountName, String accountType, double accountBalance )
    {
    // collect user information: generate account number, collect account type, account name.

        customer.add(new Account(accountID,accountName,accountType,accountBalance));
        //customer.get(0).getAccountBalance();

    }
    public int accountSize()
    {
        return customer.size();
    }
    public int searchAccount(int accountID)
    {
        //int accountIndex=0;
        System.out.println(customer.size());
        for(int i=0; i<customer.size(); i++)
        {
            if(customer.get(i).getAccountID() == accountID)
            {
                int accountIndex =i;
                return accountIndex;
            }

               
        }
        return 0;
    }
    public void viewAccount(int AccountID)
    {
    //System.out.println("View account list size: "+customer.size());
        int accountIndex=0;
     //   System.out.println("you made it to view acount account index before searchaccount is executd"+accountIndex);

        accountIndex  = searchAccount(AccountID);
        display(accountIndex);
    }
//    public  boolean search (String accountID, int accountindex)
//    {
//
//        if(customer.get(accountindex).getAccountID().contains(accountID))
//            {
//                System.out.println("1");
//               return true;
//            }
//            return false;
//    }
    public   void withdrawMoney(double withdrawlAmount, int accountID)
    {
        //call account, get account balance and subtract withdral amount, return new account balance to account information and as an output;
        int accountIndex =0;
        accountIndex=searchAccount(accountID);
        double acountBalance = customer.get(accountIndex).getAccountBalance();
        acountBalance = acountBalance - withdrawlAmount;
        while (acountBalance<0) {
            System.out.println("insufficient funds: can not excute transaction"+'\n'+ "current balance: "+customer.get(accountIndex).getAccountBalance());
        }


            customer.get(accountIndex).setAccountBalance(acountBalance);
            System.out.println("withdraw ammount: $" + withdrawlAmount + " new balance: $" +
                    customer.get(accountIndex).getAccountBalance());


    }
    public   void depositMoney(double depositAmount, int accountID)
    {
        //call account, get account balance and add deposit amount, return new account balance to account information  as an output;
        int accountIndex =0;
        accountIndex=searchAccount(accountID);
        double acountBalance = customer.get(accountIndex).getAccountBalance();
        acountBalance = acountBalance + depositAmount;
        customer.get(accountIndex).setAccountBalance(acountBalance);
        System.out.println("deposit ammount "+depositAmount+" new balance: "+customer.get(accountIndex).getAccountBalance());
    }
    public  void display( int accountIndex)
    {
        //List<Account> customer = new ArrayList<>();

        System.out.println("Account ID:"+customer.get(accountIndex).getAccountID());
        System.out.println("Account Name:"+customer.get(accountIndex).getAccountname());
        System.out.println("Account Type:"+customer.get(accountIndex).getAccountType());
        System.out.println("Account Balance:"+customer.get(accountIndex).getAccountBalance());


    }


}
