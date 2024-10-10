package com.accountsystem.accountsystem.entities;

import java.util.List;

public class AccountStatement {
	
    private Client client;
    
    private List<Account> accounts;
    
    private List<Transaction> transactions;

    public AccountStatement() {
		super();
	}

	public AccountStatement(Client client, List<Account> accounts, List<Transaction> transactions) {
        this.client = client;
        this.accounts = accounts;
        this.transactions = transactions;
    }

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