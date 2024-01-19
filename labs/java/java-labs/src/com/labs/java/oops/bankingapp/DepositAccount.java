package com.labs.java.oops.bankingapp;

public class DepositAccount extends Account implements PreCloseable {
    private int tenure;
    private boolean autoRenew;

    public DepositAccount() {

    }

    public DepositAccount(int id, String name, double balance, String status, double roi, int tenure, boolean autoRenew) {
        super(id, name, balance, status, roi);
        this.tenure = tenure;
        this.autoRenew = autoRenew;
    }

    @Override
    public double checkBalance() {
        return this.getBalance();
    }

    public double checkMaturityAmount() {
        return this.getBalance() + (this.getBalance() * this.tenure * (this.getRoi() / 100));
    }

    @Override
    public void preClose() {
        System.out.println("Pre closing Deposit Account...");
    }
}
