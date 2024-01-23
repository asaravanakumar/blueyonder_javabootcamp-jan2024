package com.blueyonder.bankingapp.service;

import com.blueyonder.bankingapp.exception.AccountException;
import com.blueyonder.bankingapp.model.Account;

public interface AccountService {
    public int createAccount(Account account) throws AccountException;
    public Account viewAccount(int id) throws AccountException;
    public Account[] listAccounts();
    public boolean updateAccount(int id, Account account) throws AccountException;
    public boolean deleteAccount(int id) throws AccountException;
}
