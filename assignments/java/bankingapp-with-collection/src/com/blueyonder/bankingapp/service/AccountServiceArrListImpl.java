package com.blueyonder.bankingapp.service;

import com.blueyonder.bankingapp.exception.AccountException;
import com.blueyonder.bankingapp.model.Account;

import java.util.Collection;

public class AccountServiceArrListImpl implements AccountService {
    @Override
    public int createAccount(Account account) throws AccountException {
        return 0;
    }

    @Override
    public Account viewAccount(int id) throws AccountException {
        return null;
    }

    @Override
    public Collection<Account> listAccounts() {
        return null;
    }

    @Override
    public boolean updateAccount(int id, Account account) throws AccountException {
        return false;
    }

    @Override
    public boolean deleteAccount(int id) throws AccountException {
        return false;
    }
}
