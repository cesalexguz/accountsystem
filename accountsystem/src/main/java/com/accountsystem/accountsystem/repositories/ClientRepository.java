package com.accountsystem.accountsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accountsystem.accountsystem.entities.Client;

/*
 * Repository interface for Client entity
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, String> {
}
