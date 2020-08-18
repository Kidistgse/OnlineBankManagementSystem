package com.codeintelx.bank.services;


import com.codeintelx.bank.models.Account;

import java.util.*;


public class AccountServices {
    public  Map<String, Account> customerinfo = new HashMap<>();

    public Account createAccount(String accountName, String accountType, double accountBalance )
    {
    // collect user information: generate account number, collect account type, account name.
        Random rand = new Random();
       // int accountID = rand.nextInt(1000);
        UUID uuid = UUID.randomUUID();
        String accountID = Long.toString(uuid.getMostSignificantBits()).substring(0,11).replace("-","");

     Account user = (new Account(accountName,accountType,accountBalance));
     customerinfo.put(accountID, user);
         System.out.println("account successfully created: here is your account Id "+accountID);
         //display(user);
        return user;
    }
    public int accountSize()
    {

        return customerinfo.size();
     }
    public Account searchAccount(String accountID)
    {
        for(int i=0; i<customerinfo.size(); i++)
        {
            if(customerinfo.containsKey(accountID))
            {
            return customerinfo.get(accountID);
           }
        }
        return null;
    }
    private Account viewAccount(String AccountID) {
        //  int accountIndex;

        Account user;
        user = searchAccount(AccountID);
        if (user == null) {
            System.out.println("account does not exist");
            return null;
        }
        else {
            return user;
        }

    }

    public   void withdrawMoney(double withdrawlAmount, String accountID)
    {
        //call account, get account balance and subtract withdral amount, return new account balance to account information and as an output;
        Account user ;
        System.out.println("hey");
        user=searchAccount(accountID);
        double acountBalance = user.getAccountBalance();
        acountBalance = acountBalance - withdrawlAmount;
        if(acountBalance<0) {
            System.out.println("insufficient funds: can not execute transaction"+'\n'+ "withdraw Limit: "+user.getAccountBalance());
        }
        else {
            user.setAccountBalance(acountBalance);
            System.out.println("withdraw ammount: $" + withdrawlAmount + " new balance: $" +
                    user.getAccountBalance());
        }

    }
    public   void depositMoney(double depositAmount, String accountID)
    {
        //call account, get account balance and add deposit amount, return new account balance to account information  as an output;
        Account user;
        user=searchAccount(accountID);
        System.out.println(user.getAccountBalance());
        double acountBalance = user.getAccountBalance();
        acountBalance = acountBalance + depositAmount;
        user.setAccountBalance(acountBalance);
        System.out.println("deposit ammount "+depositAmount+" new balance: "+user.getAccountBalance());
    }
    
    public void cancelation (String accountID) {
       System.out.println("your account has been successfully canceled "+customerinfo.remove(accountID).getAccountname());

    }


}
