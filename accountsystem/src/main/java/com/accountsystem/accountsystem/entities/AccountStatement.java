package com.accountsystem.accountsystem.entities;

import java.util.List;

/*
 * Class representing an account statement
 */
public class AccountStatement {
	
	// Client associated with the account statement
	private Client client;
	 
	// List of accounts associated with the client
	private List<Account> accounts;
	 
	// List of transactions associated with the accounts
	private List<Transaction> transactions;

    // Constructors 
    public AccountStatement() {
		super();
	}

	public AccountStatement(Client client, List<Account> accounts, List<Transaction> transactions) {
        this.client = client;
        this.accounts = accounts;
        this.transactions = transactions;
    }

	// Getters and Setters
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	@Override
	public String toString() {
		return "AccountStatement [client=" + client + ", accounts=" + accounts + ", transactions=" + transactions + "]";
	}
	
}