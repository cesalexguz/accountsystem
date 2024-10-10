package com.accountsystem.accountsystem.services;

import java.util.List;
import java.util.Optional;

import com.accountsystem.accountsystem.entities.Account;

public interface AccountService {
	
    List<Account> getAllAccounts();
    
    Optional<Account> getAccountById(String accountNumber);
    
    Account createAccount(Account account);
    
    Account updateAccount(String accountNumber, Account account);
    
    void deleteAccount(String accountNumber);
}
