package com.labs.java.oops.bankingapp;

public abstract class Account {

    public Account() {

    }

    public Account(int id, String name, double balance, String status, double roi) {
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
    private String status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getRoi() {
        return roi;
    }

    public void setRoi(double roi) {
        this.roi = roi;
    }

    public void openAccount() {
        System.out.println("Default Open Account...");
        this.status = STATUS_ACTIVE;
    }

    public abstract double checkBalance();

    public void closeAccount() {
        System.out.println("Default Close Account...");
        this.status = STATUS_CLOSED;
    }

}
