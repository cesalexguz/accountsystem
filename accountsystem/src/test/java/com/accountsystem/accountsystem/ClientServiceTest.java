package com.accountsystem.accountsystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.accountsystem.accountsystem.entities.Client;
import com.accountsystem.accountsystem.repositories.ClientRepository;
import com.accountsystem.accountsystem.services.ClientServiceImpl;

import java.util.Optional;

public class ClientServiceTest {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientServiceImpl clientService;

    private Client client;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        client = new Client();
        client.setClientId(1L);
        client.setName("John Doe");
        client.setGender("Male");
        client.setAge(30);
        client.setIdentification("123456789");
        client.setAddress("123 Main St");
        client.setPhone("555-1234");
        client.setPassword("password");
        client.setStatus(true);
    }

    @Test
    public void testGetClientById() {
        when(clientRepository.findById("1234567890")).thenReturn(Optional.of(client));

        Optional<Client> foundClient = clientService.getClientById("1234567890");

        assertNotNull(foundClient);
        assertEquals(client.getClientId(), foundClient.get().getClientId());
        assertEquals(client.getName(), foundClient.get().getName());
        assertEquals(client.getGender(), foundClient.get().getGender());
        assertEquals(client.getAge(), foundClient.get().getAge());
        assertEquals(client.getIdentification(), foundClient.get().getIdentification());
        assertEquals(client.getAddress(), foundClient.get().getAddress());
        assertEquals(client.getPhone(), foundClient.get().getPhone());
        assertEquals(client.getPassword(), foundClient.get().getPassword());
        assertEquals(client.isStatus(), foundClient.get().isStatus());
    }
}
