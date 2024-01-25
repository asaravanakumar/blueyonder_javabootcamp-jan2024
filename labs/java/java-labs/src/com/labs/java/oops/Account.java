package com.labs.java.oops;

public class Account {
    int id;
    String name;
    double balance;
    String type;
    String status;

    private static final String STATUS_ACTIVE = "Active";
    private static final String STATUS_CLOSED = "Closed";
    private static final String STATUS_SUSPENDED = "Suspended";

    public void openAccount() {
        this.status = STATUS_ACTIVE;
    }

    public boolean deposit(double amount) {
        if(this.status.equalsIgnoreCase(STATUS_ACTIVE)) {
            this.balance += amount;
            return true;
        } else {
            System.out.println("You can't deposit for Suspended or Closed com.labs.java.oops.Account");
            return false;
        }
    }

    public boolean withdraw(double amount) {
        if(this.status.equalsIgnoreCase(STATUS_ACTIVE)) {
            this.balance -= amount;
            return true;
        } else {
            System.out.println("You can't withdraw from Suspended or Closed com.labs.java.oops.Account");
            return false;
        }
    }

    public double checkBalance() {
        if(this.status.equalsIgnoreCase(STATUS_ACTIVE) || this.status.equalsIgnoreCase(STATUS_SUSPENDED)) {
            return this.balance;
        } else {
            System.out.println("You can't check balance for closed account");
        }
        return -1;
    }

    public void suspendAccount() {
        this.status = STATUS_SUSPENDED;
    }

    public void closeAccount() {
        this.status = STATUS_CLOSED;
    }

}
