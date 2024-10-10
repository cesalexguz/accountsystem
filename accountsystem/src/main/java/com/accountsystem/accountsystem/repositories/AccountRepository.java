package com.accountsystem.accountsystem.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accountsystem.accountsystem.entities.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
	
	List<Account> findByClientId(String clientId);
}
