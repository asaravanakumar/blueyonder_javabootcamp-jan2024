package com.blueyonder.bankingapp.service;

import com.blueyonder.bankingapp.exception.AccountException;
import com.blueyonder.bankingapp.exception.NoAccountFoundException;
import com.blueyonder.bankingapp.model.Account;
import com.blueyonder.bankingapp.model.Transaction;
import com.blueyonder.bankingapp.repo.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    AccountRepository accountRepo;

    @Override
    public int createAccount(Account account) throws AccountException {
        account.setCreateTimestamp(LocalDateTime.now());
        return accountRepo.save(account).getId();
    }

    @Override
    public Collection<Account> getAllAccounts() throws AccountException {
        return accountRepo.findAll();
    }

    @Override
    public Optional<Account> getAccount(int id) throws AccountException {
        return accountRepo.findById(id);
    }

    @Override
    public boolean updateAccount(int id, Account account) throws AccountException {
        account.setUpdateTimestamp(LocalDateTime.now());
        account.setId(id);
        Account accountForUpdate = accountRepo.findById(id).orElseThrow(NoAccountFoundException::new);
            accountRepo.save(account);
            return true;
    }

    @Override
    public boolean deleteAccount(int id) throws AccountException {
        Account accountForDelete = accountRepo.findById(id).orElseThrow(NoAccountFoundException::new);
        accountRepo.delete(accountForDelete);
        return true;
    }

    @Override
    public boolean deposit(int id, Transaction transaction) throws AccountException {
        // TODO: Validation
        // TODO: Set account id into transaction object
        // TODO: Create LoadBalanced RestTemplate
        // TODO: Discover the service location by service-id
        // TODO: Call Transaction Service with Transaction object
        // TODO: Get the Response

        return false;
    }

    @Override
    public boolean withdraw(int id, Transaction transaction) throws AccountException {
        // TODO: Validation
        // TODO: Set account id into transaction object
        // TODO: Create LoadBalanced RestTemplate
        // TODO: Discover the service location by service-id
        // TODO: Call Transaction Service with Transaction object
        // TODO: Get the Response
        return false;
    }


}
