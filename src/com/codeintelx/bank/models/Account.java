package com.codeintelx.bank.models;

public class Account {
    int accountID=0;
    String accountname="0";
    String accountType="0";
    double accountBalance=0;
   public Account(int accountID, String name, String accountType, double accountBalance )
    {
        this.accountID = accountID;
        this.accountname = name;
        this.accountType = accountType;
        this.accountBalance=accountBalance;
    }
    public Account( )
    {
        this.accountID = accountID;
        this.accountname = accountname;
        this.accountType = accountType;
        this.accountBalance=accountBalance;
    }

    public int getAccountID()
    {
        return accountID;
    }

    public String getAccountname()
    {
        return accountname;
    }

    public String getAccountType()
    {
        return accountType;
    }

    public double getAccountBalance()
    {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public void setAccountname(String accountname) {
        this.accountname = accountname;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}
