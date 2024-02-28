package com.blueyonder.bankingapp.controller;

import com.blueyonder.bankingapp.exception.AccountException;
import com.blueyonder.bankingapp.model.Account;
import com.blueyonder.bankingapp.model.ResponseMessage;
import com.blueyonder.bankingapp.model.Transaction;
import com.blueyonder.bankingapp.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;

@RestController
@RequestMapping("/accounts")
public class AccountController {

//    Account Service [account-service]
//    GET 	/accounts
//    GET	/accounts/{id}
//    POST	/accounts
//    PUT	/accounts/{id}
//    DELETE	/accounts/{id}

    @Autowired
    AccountService service;

    @PostMapping
    public ResponseEntity<ResponseMessage> createAccount(@RequestBody @Valid Account account) throws AccountException, URISyntaxException {
        int id = service.createAccount(account);
        ResponseMessage response = new ResponseMessage("Success", "Account Created Successfully - " + id);
        String uri = "http://loclhost:8091/accounts/" + id;
        return ResponseEntity.created(new URI(uri)).body(response);
    }

    @GetMapping
    public Collection<Account> getAllAccounts() throws AccountException {
        return service.getAllAccounts();
    }

    @GetMapping("/{id}")
    public Account getAccount(@PathVariable(name = "id") int id) throws AccountException {
        return service.getAccount(id).get();
    }

    @PostMapping("/{id}/deposits")
    public ResponseEntity<ResponseMessage> deposit(@PathVariable(name = "id") int id, @RequestBody @Valid Transaction transaction) throws AccountException, URISyntaxException {
        boolean status = service.deposit(id, transaction);
        ResponseMessage success = new ResponseMessage("Success", "Amount deposited successfully");
        ResponseMessage failure = new ResponseMessage("Failure", "Amount deposit failed");
        return status ? ResponseEntity.ok(success) : ResponseEntity.ok(failure);
    }

    @PostMapping("/{id}/withdrawal")
    public ResponseEntity<ResponseMessage> withdrawal(@PathVariable(name = "id") int id, @RequestBody @Valid Transaction transaction) throws AccountException, URISyntaxException {
        boolean status = service.withdraw(id, transaction);
        ResponseMessage success = new ResponseMessage("Success", "Amount withdrawn successfully");
        ResponseMessage failure = new ResponseMessage("Failure", "Amount withdrawal failed");
        return status ? ResponseEntity.ok(success) : ResponseEntity.ok(failure);
    }
}
