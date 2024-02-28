package com.blueyonder.bankingapp.service;

import com.blueyonder.bankingapp.exception.AccountException;
import com.blueyonder.bankingapp.exception.AccountValidationException;
import com.blueyonder.bankingapp.exception.NoAccountFoundException;
import com.blueyonder.bankingapp.model.Account;
import com.blueyonder.bankingapp.model.Transaction;

import java.util.Collection;
import java.util.Optional;

public interface AccountService {
    public int createAccount(Account account) throws AccountException;

    public Collection<Account> getAllAccounts() throws AccountException;

    public Optional<Account> getAccount(int id) throws AccountException;

    public boolean updateAccount(int id, Account account) throws AccountException;

    public boolean deleteAccount(int id) throws AccountException;

    public boolean deposit(int id, Transaction transaction) throws AccountException;

    public boolean withdraw(int id, Transaction transaction) throws AccountException;

}
