package com.accountsystem.accountsystem.services;

import java.util.List;
import java.util.Optional;

import com.accountsystem.accountsystem.entities.Person;

/*
 * Service interface for managing persons
 */
public interface PersonService {
	
	// Retrieve all persons
	List<Person> getAllPersons();
	 
	// Retrieve a person by their identification
	Optional<Person> getPersonById(String identification);
	 
	// Create a new person
	Person createPerson(Person person);
	 
	// Update an existing person by their identification
	Person updatePerson(String identification, Person person);
	 
	// Delete a person by their identification
	void deletePerson(String identification);
	
}
