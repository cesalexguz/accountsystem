package com.accountsystem.accountsystem.services;

import java.time.LocalDate;

import com.accountsystem.accountsystem.entities.AccountStatement;

/*
 * Service interface for generating account statements
 */
public interface AccountStatementService {
	
	// Generate an account statement for a client within a date range
	AccountStatement getAccountStatement(String clientId, LocalDate startDate, LocalDate endDate);
	
}