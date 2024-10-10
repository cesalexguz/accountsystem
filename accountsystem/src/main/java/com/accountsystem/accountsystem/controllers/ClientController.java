package com.accountsystem.accountsystem.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accountsystem.accountsystem.entities.Client;
import com.accountsystem.accountsystem.services.ClientServiceImpl;

/*
 * REST controller for managing clients
 */
@RestController
@RequestMapping("/clientes")
public class ClientController {
	
	// Injecting the ClientService implementation
    @Autowired
    private ClientServiceImpl clientService;

    // Endpoint to retrieve all client
    @GetMapping
    public ResponseEntity<List<Client>> getAllClients() {
    	 return new ResponseEntity<>(clientService.getAllClients(), HttpStatus.OK);
    }
    
    // Endpoint to retrieve a client by their ID
    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable("id") String id) {
        Optional<Client> client = clientService.getClientById(id);
        if(client.isPresent()) {
            return new ResponseEntity<>(client.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Endpoint to create a new client
    @PostMapping
    public ResponseEntity<?> createClient(@RequestBody Client client) {
    	try {
            Client savedClient = clientService.createClient(client);
            return new ResponseEntity<>(savedClient, HttpStatus.OK);

        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>("Data integrity violation: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (TransactionSystemException e) {
            return new ResponseEntity<>("Transaction system exception: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // Endpoint to update an existing client by their ID
    @PutMapping("/{id}")
    public ResponseEntity<?> updateClient(@PathVariable("id") String id, @RequestBody Client clientDetails) {
    	try {
            Client updatedClient = clientService.updateClient(id, clientDetails);
            return new ResponseEntity<>(updatedClient, HttpStatus.OK);

        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>("Data integrity violation: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (TransactionSystemException e) {
            return new ResponseEntity<>("Transaction system exception: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // Endpoint to delete a client by their ID
    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable("id") String id) {
        clientService.deleteClient(id);
    }
}
