package com.accountsystem.accountsystem.services;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accountsystem.accountsystem.entities.Account;
import com.accountsystem.accountsystem.entities.AccountStatement;
import com.accountsystem.accountsystem.entities.Client;
import com.accountsystem.accountsystem.entities.Transaction;
import com.accountsystem.accountsystem.repositories.AccountRepository;
import com.accountsystem.accountsystem.repositories.ClientRepository;
import com.accountsystem.accountsystem.repositories.TransactionRepository;

/*
 * Implementation of AccountStatementService
 */
@Service
public class AccountStatementServiceImpl implements AccountStatementService {
	
	// Injecting the ClientRepository dependency
    @Autowired
    private ClientRepository clientRepository;

    // Injecting the AccountRepository dependency
    @Autowired
    private AccountRepository accountRepository;

    // Injecting the TransactionRepository dependency
    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public AccountStatement getAccountStatement(String clientId, LocalDate startDate, LocalDate endDate) {
        Client client = clientRepository.findById(clientId).orElseThrow();
        List<Account> accounts = accountRepository.findByClientId(clientId);

        List<Transaction> transactions = transactionRepository.findAll().stream()
                .filter(transaction -> transaction.getTransactionDate().isAfter(startDate.minusDays(1)) &&
                        transaction.getTransactionDate().isBefore(endDate.plusDays(1)) &&
                        accounts.stream().anyMatch(account -> account.getAccountNumber().equals(transaction.getAccountNumber())))
                .collect(Collectors.toList());

        return new AccountStatement(client, accounts, transactions);
    }
}
