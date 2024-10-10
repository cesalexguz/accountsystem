package com.accountsystem.accountsystem.entities;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/*
 * Entity representing a transaction
 */
@Entity
@Table(name="transaction")
public class Transaction {
	
	// Unique transaction ID
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	 
	// Date of the transaction
	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate transactionDate;
	 
	// Type of the transaction (e.g., deposit, withdrawal)
	@NotBlank
	private String transactionType;
	 
	// Amount involved in the transaction
	@NotNull
	private double amount;
	 
	// Balance after the transaction
	private double balance;
	 
	// Account number associated with the transaction
	@NotBlank
	private String accountNumber;

    // Constructors 
	public Transaction() {
		super();
	}

	public Transaction(Long id, @NotNull LocalDate transactionDate, @NotBlank String transactionType,
			@NotNull double amount, @NotNull double balance, @NotBlank String accountNumber) {
		super();
		this.id = id;
		this.transactionDate = transactionDate;
		this.transactionType = transactionType;
		this.amount = amount;
		this.balance = balance;
		this.accountNumber = accountNumber;
	}

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", transactionDate=" + transactionDate + ", transactionType=" + transactionType
				+ ", amount=" + amount + ", balance=" + balance + ", accountNumber=" + accountNumber + "]";
	}

}
