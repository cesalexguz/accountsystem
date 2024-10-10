package com.accountsystem.accountsystem.services;

import java.util.List;
import java.util.Optional;

import com.accountsystem.accountsystem.entities.Person;

public interface PersonService {
	
    List<Person> getAllPersons();
    
    Optional<Person> getPersonById(String identification);
    
    Person createPerson(Person person);
    
    Person updatePerson(String identification, Person person);
    
    void deletePerson(String identification);
}
