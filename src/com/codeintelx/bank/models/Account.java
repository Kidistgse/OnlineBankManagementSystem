package com.codeintelx.bank.models;

public class Account {
    String accountId="0";
    String accountname="0";
    String accountType="0";
    double accountBalance=0;
   public Account(String accountId, String name, String accountType, double accountBalance )
    {
        this.accountId = accountId;
        this.accountname = name;
        this.accountType = accountType;
        this.accountBalance=accountBalance;
    }
    public Account( )
    {
        this.accountId = accountId;
        this.accountname = accountname;
        this.accountType = accountType;
        this.accountBalance=accountBalance;
    }

    public String getAccountID()
    {
        return accountId;
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

    public void setAccountID(String accountID) {
        this.accountId = accountID;
    }

    public void setAccountname(String accountname) {
        this.accountname = accountname;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}
