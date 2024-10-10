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
    private static ClientRepository clientRepository;

    @InjectMocks
    private static ClientServiceImpl clientService;

    private static Client client;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        client = new Client();
        client.setClientId(1L);
        client.setName("Alejandro Chimborazo");
        client.setGender("M");
        client.setAge(30);
        client.setIdentification("1234567895");
        client.setAddress("Amazonas y Gaspar de Villarroel");
        client.setPhone("5551234");
        client.setPassword("6789");
        client.setStatus(true);
    }

    @Test
    public static void testGetClientById() {
        when(clientRepository.findById("1234567895")).thenReturn(Optional.of(client));

        Optional<Client> foundClient = clientService.getClientById("1234567895");

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
