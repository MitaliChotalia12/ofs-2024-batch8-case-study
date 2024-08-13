package com.ofss.main.inb.domain;

// import java.util.List;

public class Account {

    private int accountId;
    private String accountType;
    private double accountRate;
    private double accountBalance;
    private double accountMinBalance;
    private String accountStatus;
    private int withdrawalLimit;
    // private String name;
    // private double balance;
    // private String status;
    // private Customer customer;
    // private List<Transaction> txns;
    // private List<Cheque> cheques;

    public Account(){}


    // public List<Cheque> getCheques() {
    //     return cheques;
    // }


    // public List<Transaction> getTxns() {
    //     return txns;
    // }

    // public void setTxns(List<Transaction> txns) {
    //     this.txns = txns;
    // }

    
    public Account(int accountId, String accountType, double accountRate, double accountBalance,
            double accountMinBalance, String accountStatus, int withdrawalLimit) {
        this.accountId = accountId;
        this.accountType = accountType;
        this.accountRate = accountRate;
        this.accountBalance = accountBalance;
        this.accountMinBalance = accountMinBalance;
        this.accountStatus = accountStatus;
        this.withdrawalLimit = withdrawalLimit;
    }

    public String toString(){
        return "Account Number : " + accountId; 
    }

    public Account(int no , String n , double bal){
        this.accountId = no;
        //this.name=n;
        this.accountBalance = bal;
    }


    public boolean withdraw(double amount){
        if(amount > accountBalance || amount<=0){
            return false;
        }
        this.accountBalance-=amount;
        return true;
    }

    public boolean deposit(double amount){
        if(amount<0){
            return false;
        }
        this.accountBalance+=amount;
        return true;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getAccountRate() {
        return accountRate;
    }

    public void setAccountRate(double accountRate) {
        this.accountRate = accountRate;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public double getAccountMinBalance() {
        return accountMinBalance;
    }

    public void setAccountMinBalance(double accountMinBalance) {
        this.accountMinBalance = accountMinBalance;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public int getWithdrawalLimit() {
        return withdrawalLimit;
    }

    public void setWithdrawalLimit(int withdrawalLimit) {
        this.withdrawalLimit = withdrawalLimit;
    }

}
