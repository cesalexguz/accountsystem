package com.accountsystem.accountsystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accountsystem.accountsystem.entities.Account;
import com.accountsystem.accountsystem.repositories.AccountRepository;

import jakarta.transaction.Transactional;

@Service
public class AccountServiceImpl implements AccountService {
	
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Optional<Account> getAccountById(String accountNumber) {
        return accountRepository.findById(accountNumber);
    }

    @Transactional
    @Override
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    @Transactional
    @Override
    public Account updateAccount(String accountNumber, Account account) {
    	Account updatedAccount = accountRepository.findById(accountNumber).orElseThrow();
    	updatedAccount.setAccountNumber(account.getAccountNumber());
    	updatedAccount.setAccountType(account.getAccountType());
    	updatedAccount.setInitialBalance(account.getInitialBalance());
    	updatedAccount.setStatus(account.isStatus());
    	updatedAccount.setClientId(account.getClientId());
    	return accountRepository.save(updatedAccount);
    }

    @Transactional
    @Override
    public void deleteAccount(String accountNumber) {
        accountRepository.deleteById(accountNumber);
    }
}
