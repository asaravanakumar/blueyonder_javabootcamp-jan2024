package com.labs.java.oops.bankingapp;

public abstract class Account extends Object {

    public Account() {

    }

    public Account(int id, String name, double balance, AccountStatus status, double roi) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.status = status;
        this.roi = roi;
    }

    protected static final String STATUS_ACTIVE = "Active";
    protected static final String STATUS_CLOSED = "Closed";
    protected static final String STATUS_SUSPENDED = "Suspended";

    // properties
    private int id;
    private String name;
    private double balance;
    private AccountStatus status;
    private double roi;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public double getRoi() {
        return roi;
    }

    public void setRoi(double roi) {
        this.roi = roi;
    }

    public void openAccount() {
        System.out.println("Default Open com.labs.java.oops.Account...");
        this.status = AccountStatus.ACTIVE;
    }

    public abstract double checkBalance();

    public void closeAccount() {
        System.out.println("Default Close com.labs.java.oops.Account...");
        this.status = AccountStatus.CLOSED;
    }

    @Override
    public String toString() {
        return "com.labs.java.oops.Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", status='" + status + '\'' +
                ", roi=" + roi +
                '}';
    }
}
