package com.accountsystem.accountsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accountsystem.accountsystem.entities.Person;

/*
 * Repository interface for Person entity
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, String> {
}
