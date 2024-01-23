package com.blueyonder.bankingapp.service;

import com.blueyonder.bankingapp.exception.AccountException;
import com.blueyonder.bankingapp.exception.AccountNotFoundException;
import com.blueyonder.bankingapp.model.Account;
import com.blueyonder.bankingapp.model.AccountStatus;

public class AccountServiceArrImpl implements AccountService{

    public static final int ACCOUNTS_SIZE = 10;

    private Account[] accounts = new Account[ACCOUNTS_SIZE];
    private static int counter;

    @Override
    public int createAccount(Account account) throws AccountException {
        account.setId(counter + 1);
        account.setStatus(AccountStatus.ACTIVE);
        accounts[counter++] = account;
        return account.getId();
    }

    @Override
    public Account viewAccount(int id) throws AccountException {
        Account account = null;
        for(Account acc: accounts) {
            if(acc != null && acc.getId() == id) {
                account = acc;
            }
        }

        if(account == null) {
            throw new AccountNotFoundException("No Account Found for given Account ID - " + id);
        }
        return account;
    }

    @Override
    public Account[] listAccounts() {
        return accounts;
    }

    @Override
    public boolean updateAccount(int id, Account account) throws AccountException {
        boolean flag = false;
        for(int i = 0; i < accounts.length; i++) {
            if(accounts[i] != null && accounts[i].getId() == id) {
                accounts[i] = account;
                flag = true;
            }
        }

        if(!flag) {
            throw new AccountNotFoundException("No Account Found for given Account ID - " + id);
        }
        return flag;
    }

    @Override
    public boolean deleteAccount(int id) throws AccountException {
        boolean flag = false;
        for(int i = 0; i < accounts.length; i++) {
            if(accounts[i] != null && accounts[i].getId() == id) {
                accounts[i].setStatus(AccountStatus.CLOSED);
                flag = true;
            }
        }

        if(!flag) {
            throw new AccountNotFoundException("No Account Found for given Account ID - " + id);
        }

        return flag;
    }
}
