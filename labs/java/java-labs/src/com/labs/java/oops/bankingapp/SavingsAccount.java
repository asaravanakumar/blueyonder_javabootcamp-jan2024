package com.labs.java.oops.bankingapp;

public class SavingsAccount extends Account {

    public SavingsAccount() {
    }

    public SavingsAccount(int id, String name, double balance, AccountStatus status, double roi) {
        super(id, name, balance, status, roi);
    }

    @Override
    public void openAccount() {
        System.out.println("Open Savings com.labs.java.oops.Account...");
    }

    @Override
    public double checkBalance() {
        return this.getBalance();
    }

    public boolean deposit(double amount) {
        if(this.getStatus() == AccountStatus.ACTIVE) {
            this.setBalance(this.getBalance() + amount);
            return true;
        } else {
            System.out.println("You can't deposit for Suspended or Closed com.labs.java.oops.Account");
            return false;
        }
    }

    public boolean withdraw(double amount) {
        if(this.getStatus() == AccountStatus.ACTIVE) {
            this.setBalance(this.getBalance() - amount);
            return true;
        } else {
            System.out.println("You can't withdraw from Suspended or Closed com.labs.java.oops.Account");
            return false;
        }
    }

//    @Override
//    public String toString() {
//        return "SavingsAccount{" + this.getId() + " " + this.getName() + " " + this.getBalance() + " " + this.getStatus() + "}";
//    }
}
