package com.accountsystem.accountsystem.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/*
 * Entity representing a bank account
 */
@Entity
@Table(name="account")
public class Account {
	
	// Unique account number
	@Id
	private String accountNumber;
	 
	// Type of the account (e.g., savings, checking)
	@NotBlank
	private String accountType;
	 
	// Initial balance of the account
	@NotNull
	private double initialBalance;
	 
	// Status of the account (active/inactive)
	private boolean status;
	 
	// ID of the client who owns the account
	@NotBlank
	private String clientId;

    // Constructors 
	public Account() {
		super();
	}

	public Account(String accountNumber, @NotBlank String accountType, @NotNull double initialBalance, boolean status,
			@NotBlank String clientId) {
		super();
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.initialBalance = initialBalance;
		this.status = status;
		this.clientId = clientId;
	}

	// Getters and Setters
	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getInitialBalance() {
		return initialBalance;
	}

	public void setInitialBalance(double initialBalance) {
		this.initialBalance = initialBalance;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", accountType=" + accountType + ", initialBalance="
				+ initialBalance + ", status=" + status + ", clientId=" + clientId + "]";
	}

}