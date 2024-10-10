package com.accountsystem.accountsystem.services;

import java.util.List;
import java.util.Optional;

import com.accountsystem.accountsystem.entities.Client;

public interface ClientService {
	
    List<Client> getAllClients();
    
    Optional<Client> getClientById(String clientId);
    
    Client createClient(Client client);
    
    Client updateClient(String identification, Client client);
    
    void deleteClient(String clientId);
}
