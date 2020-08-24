package com.codeintelx.bank.services;


import com.codeintelx.bank.LowBalance;
import com.codeintelx.bank.models.Account;

import java.util.*;


public class AccountServices {
    private   Map<String, Account> customerAccounts = new HashMap<>();
    Account user ;

    public Account createAccount(String accountName, String accountType, double accountBalance )
    {
    // collect user information: generate account number, collect account type, account name.
        UUID uuid = UUID.randomUUID();
        String accountID = Long.toString(uuid.getMostSignificantBits()).substring(0,11).replace("-","");

      user = (new Account(accountID,accountName,accountType,accountBalance));

     customerAccounts.put(accountID, user);

         return user;
    }

   public boolean checkIfAccountExist(String accountID)
   {
          // throws an exception if account does not exist
          // caught inside of main class

         return customerAccounts.containsKey(accountID);
   }

    public Account viewAccount(String accountID) throws AccountDoesnotexist  {
        // Do not return null - just check it later
        Account user;
            if (!customerAccounts.containsKey(accountID)) {
                  throw new AccountDoesnotexist();
                //when a user account does not exist it should throw a user account exception
            } else {
                return customerAccounts.get(accountID);
         }

    }

    public   Account withdrawMoney(double withdrawlAmount, String accountID) throws LowBalance
    {
        //call account, get account balance and subtract withdral amount, return new account balance to account information and as an output;
        //return account object
        
        double acountBalance = customerAccounts.get(accountID).getAccountBalance()-withdrawlAmount;
        //acountBalance = acountBalance - withdrawlAmount;

            if (acountBalance < 0) {
                // insufficient fund exception
               throw new LowBalance();
            }

            customerAccounts.get(accountID).getAccountBalance();
            return user;
    }
    public   Account depositMoney(double depositAmount, String accountID)
    {
        //call account, get account balance and add deposit amount, return new account balance to account information  as an output;
        // return account object


        double acountBalance = customerAccounts.get(accountID).getAccountBalance();
        acountBalance = acountBalance + depositAmount;
        customerAccounts.get(accountID).setAccountBalance(acountBalance);
        return user;
    }
    
    public Account closeAccount (String accountID) {
        //no prints
       return customerAccounts.remove(accountID);

    }
    //


    public static class AccountDoestExist {
    }
}
