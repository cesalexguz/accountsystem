package com.accountsystem.accountsystem.services;

import java.time.LocalDate;

import com.accountsystem.accountsystem.entities.AccountStatement;

public interface AccountStatementService {
	
    AccountStatement getAccountStatement(String clientId, LocalDate startDate, LocalDate endDate);
}
