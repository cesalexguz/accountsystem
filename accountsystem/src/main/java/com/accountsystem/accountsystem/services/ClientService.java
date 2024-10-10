package com.accountsystem.accountsystem.services;

import java.util.List;
import java.util.Optional;

import com.accountsystem.accountsystem.entities.Client;

/*
 * Service interface for managing clients
 */
public interface ClientService {
	
	// Retrieve all clients
	List<Client> getAllClients();
	 
	// Retrieve a client by their ID
	Optional<Client> getClientById(String clientId);
	 
	// Create a new client
	Client createClient(Client client);
	 
	// Update an existing client by their identification
	Client updateClient(String identification, Client client);
	 
	// Delete a client by their ID
	void deleteClient(String clientId);
	
}
