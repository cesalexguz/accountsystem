package com.accountsystem.accountsystem.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accountsystem.accountsystem.entities.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	
	List<Transaction> findByAccountNumberAndTransactionDateBetween(String accountNumber, LocalDate startDate, LocalDate endDate);
}
