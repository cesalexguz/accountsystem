package com.accountsystem.accountsystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accountsystem.accountsystem.entities.Account;
import com.accountsystem.accountsystem.entities.Transaction;
import com.accountsystem.accountsystem.exceptions.InsufficientBalanceException;
import com.accountsystem.accountsystem.repositories.AccountRepository;
import com.accountsystem.accountsystem.repositories.TransactionRepository;

import jakarta.transaction.Transactional;

/*
 * Implementation of TransactionService
 */
@Service
public class TransactionServiceImpl implements TransactionService {
	
	// Injecting the TransactionRepository dependency
    @Autowired
    private TransactionRepository transactionRepository;
    
    // Injecting the AccountRepository dependency
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    @Override
    public Optional<Transaction> getTransactionById(Long id) {
        return transactionRepository.findById(id);
    }

    @Transactional
    @Override
    public Transaction createTransaction(Transaction transaction) {
    	Account account = accountRepository.findById(transaction.getAccountNumber()).orElseThrow();
        double newBalance = account.getInitialBalance() + transaction.getAmount();
  
        if (newBalance < 0) {
            throw new InsufficientBalanceException("Saldo no disponible");
        }
        
        account.setInitialBalance(newBalance);
        accountRepository.save(account);
        transaction.setBalance(newBalance);
        return transactionRepository.save(transaction);
    }

    @Transactional
    @Override
    public Transaction updateTransaction(Long id, Transaction transaction) {
    	Account account = accountRepository.findById(transaction.getAccountNumber()).orElseThrow();
        double newBalance = account.getInitialBalance() + transaction.getAmount();
        if (newBalance < 0) {
            throw new InsufficientBalanceException("Saldo no disponible");
        }
        account.setInitialBalance(newBalance);
        accountRepository.save(account);
        
        Transaction updatedTransaction = transactionRepository.findById(id).orElseThrow();
    	updatedTransaction.setTransactionDate(transaction.getTransactionDate());
    	updatedTransaction.setTransactionType(transaction.getTransactionType());
    	updatedTransaction.setAmount(transaction.getAmount());
    	updatedTransaction.setBalance(newBalance);
    	updatedTransaction.setAccountNumber(transaction.getAccountNumber());
    	return transactionRepository.save(updatedTransaction);
    }

    @Transactional
    @Override
    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }
}
