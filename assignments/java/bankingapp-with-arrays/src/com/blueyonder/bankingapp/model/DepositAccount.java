package com.blueyonder.bankingapp.model;

public class DepositAccount extends Account implements PreCloseable {
    private int tenure;
    private boolean autoRenew;

    public DepositAccount() {

    }

    public DepositAccount(int id, String name, double balance, AccountStatus status, double roi, int tenure, boolean autoRenew) {
        super(id, name, balance, status, roi);
        this.tenure = tenure;
        this.autoRenew = autoRenew;
    }

    public int getTenure() {
        return tenure;
    }

    public void setTenure(int tenure) {
        this.tenure = tenure;
    }

    public boolean isAutoRenew() {
        return autoRenew;
    }

    public void setAutoRenew(boolean autoRenew) {
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
