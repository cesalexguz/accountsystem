package com.accountsystem.accountsystem.services;

import java.util.List;
import java.util.Optional;

import com.accountsystem.accountsystem.entities.Transaction;

public interface TransactionService {
	
    List<Transaction> getAllTransactions();
    
    Optional<Transaction> getTransactionById(Long id);
    
    Transaction createTransaction(Transaction transaction);
    
    Transaction updateTransaction(Long id, Transaction transaction);
    
    void deleteTransaction(Long id);
}
