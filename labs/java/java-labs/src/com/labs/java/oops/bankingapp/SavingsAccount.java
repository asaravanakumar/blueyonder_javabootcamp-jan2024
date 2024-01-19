package com.labs.java.oops.bankingapp;

public class SavingsAccount extends Account {

    public SavingsAccount() {
    }

    public SavingsAccount(int id, String name, double balance, String status, double roi) {
        super(id, name, balance, status, roi);
    }

    @Override
    public double checkBalance() {
        return this.getBalance();
    }

    public boolean deposit(double amount) {
        if(this.getStatus().equalsIgnoreCase(STATUS_ACTIVE)) {
            this.setBalance(this.getBalance() + amount);
            return true;
        } else {
            System.out.println("You can't deposit for Suspended or Closed Account");
            return false;
        }
    }

    public boolean withdraw(double amount) {
        if(this.getStatus().equalsIgnoreCase(STATUS_ACTIVE)) {
            this.setBalance(this.getBalance() - amount);
            return true;
        } else {
            System.out.println("You can't withdraw from Suspended or Closed Account");
            return false;
        }
    }
}
