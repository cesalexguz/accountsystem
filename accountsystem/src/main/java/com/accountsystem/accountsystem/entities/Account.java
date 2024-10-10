package com.accountsystem.accountsystem.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="account")
public class Account {
	
    @Id
    private String accountNumber;
    
    @NotBlank
    private String accountType;
    
    @NotNull
    private double initialBalance;
    
    private boolean status;
    
    @NotBlank
    private String clientId;

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