package com.blueyonder.bankingapp.model;

public class LoanAccount extends Account implements PreCloseable {
    private int tenure;
    private double emi;

    public LoanAccount() {

    }

    public LoanAccount(int id, String name, double balance, AccountStatus status, double roi, int tenure, double emi) {
        super(id, name, balance, status, roi);
        this.tenure = tenure;
        this.emi = emi;
    }

    public int getTenure() {
        return tenure;
    }

    public void setTenure(int tenure) {
        this.tenure = tenure;
    }

    public double getEmi() {
        return emi;
    }

    public void setEmi(double emi) {
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
