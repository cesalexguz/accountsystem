package com.accountsystem.accountsystem.controllers;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.accountsystem.accountsystem.entities.AccountStatement;
import com.accountsystem.accountsystem.services.AccountStatementService;

/*
 * REST controller for generating account statements
 */
@RestController
@RequestMapping("/reportes")
public class AccountStatementController {
	
	// Injecting the AccountStatementService implementation
    @Autowired
    private AccountStatementService accountStatementService;

    // Endpoint to generate an account statement for a client within a date range
    @GetMapping
    public AccountStatement getAccountStatement(
            @RequestParam("clientId") String clientId,
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return accountStatementService.getAccountStatement(clientId, startDate, endDate);
    }
}
