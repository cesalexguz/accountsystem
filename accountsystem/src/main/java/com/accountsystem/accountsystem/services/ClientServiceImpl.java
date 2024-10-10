package com.accountsystem.accountsystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accountsystem.accountsystem.entities.Client;
import com.accountsystem.accountsystem.repositories.ClientRepository;

import jakarta.transaction.Transactional;

/*
 * Implementation of ClientService
 */
@Service
public class ClientServiceImpl implements ClientService {
	
	// Injecting the ClientRepository dependency
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Optional<Client> getClientById(String clientId) {
        return clientRepository.findById(clientId);
    }

    @Transactional
    @Override
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    @Transactional
    @Override
    public Client updateClient(String identification, Client client) {
    	Client updatedClient = clientRepository.findById(identification).orElseThrow();
    	updatedClient.setName(client.getName());
    	updatedClient.setGender(client.getGender());
    	updatedClient.setAge(client.getAge());
    	updatedClient.setAddress(client.getAddress());
    	updatedClient.setPhone(client.getPhone());
    	updatedClient.setClientId(client.getClientId());
    	updatedClient.setPassword(client.getPassword());
    	updatedClient.setStatus(client.isStatus());
    	return clientRepository.save(updatedClient);
    }

    @Transactional
    @Override
    public void deleteClient(String clientId) {
        clientRepository.deleteById(clientId);
    }
}
