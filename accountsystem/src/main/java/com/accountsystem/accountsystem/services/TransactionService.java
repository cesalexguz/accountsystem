package com.accountsystem.accountsystem.services;

import java.util.List;
import java.util.Optional;

import com.accountsystem.accountsystem.entities.Transaction;

/*
 * Service interface for managing transactions
 */
public interface TransactionService {
	
	// Retrieve all transactions
	List<Transaction> getAllTransactions();
	 
	// Retrieve a transaction by its ID
	Optional<Transaction> getTransactionById(Long id);
	 
	// Create a new transaction
	Transaction createTransaction(Transaction transaction);
	 
	// Update an existing transaction by its ID
	Transaction updateTransaction(Long id, Transaction transaction);
	 
	// Delete a transaction by its ID
	void deleteTransaction(Long id);

}
