package com.labs.java.oops.bankingapp;

public class LoanAccount extends Account implements PreCloseable {
    private int tenure;
    private double emi;

    public LoanAccount() {

    }

    public LoanAccount(int id, String name, double balance, String status, double roi, int tenure, double emi) {
        super(id, name, balance, status, roi);
        this.tenure = tenure;
        this.emi = emi;
    }

    @Override
    public double checkBalance() {
        return this.getBalance();
    }

    public double calculateInterest() {
        System.out.println("Logic to compute interest");
        return this.getBalance() * tenure * (this.getRoi() / 100);
    }

    @Override
    public void preClose() {
        System.out.println("Pre closing the Loan Account...");
    }
}
