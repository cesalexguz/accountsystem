package com.accountsystem.accountsystem.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accountsystem.accountsystem.entities.Account;
import com.accountsystem.accountsystem.services.AccountServiceImpl;

@RestController
@RequestMapping("/cuentas")
public class AccountController {

	@Autowired
    private AccountServiceImpl accountService;

    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts() {
    	return new ResponseEntity<>(accountService.getAllAccounts(), HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable("id") String id) {
    	Optional<Account> account = accountService.getAccountById(id);
        if(account.isPresent()) {
            return new ResponseEntity<>(account.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<?> createAccount(@RequestBody Account account) {
    	try {
            Account savedAccount = accountService.createAccount(account);
            return new ResponseEntity<>(savedAccount, HttpStatus.OK);

        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>("Data integrity violation: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (TransactionSystemException e) {
            return new ResponseEntity<>("Transaction system exception: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAccount(@PathVariable("id") String id, @RequestBody Account accountDetails) {
    	try {
            Account updatedAccount = accountService.updateAccount(id, accountDetails);
            return new ResponseEntity<>(updatedAccount, HttpStatus.OK);

        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>("Data integrity violation: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (TransactionSystemException e) {
            return new ResponseEntity<>("Transaction system exception: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable("id") String id) {
        accountService.deleteAccount(id);
    }
}
