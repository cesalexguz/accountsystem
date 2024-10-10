package com.accountsystem.accountsystem.services;

import java.util.List;
import java.util.Optional;

import com.accountsystem.accountsystem.entities.Account;

/*
 * Service interface for managing accounts
 */
public interface AccountService {
	
	// Retrieve all accounts
	List<Account> getAllAccounts();
	 
	// Retrieve an account by its number
	Optional<Account> getAccountById(String accountNumber);
	 
	// Create a new account
	Account createAccount(Account account);
	 
	// Update an existing account by its number
	Account updateAccount(String accountNumber, Account account);
	 
	// Delete an account by its number
	void deleteAccount(String accountNumber);
	
}
