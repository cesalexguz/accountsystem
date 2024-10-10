package com.accountsystem.accountsystem;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.accountsystem.accountsystem.entities.Client;
import com.accountsystem.accountsystem.repositories.ClientRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class ClientIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ClientRepository clientRepository;

    @Test
    public void testCreateClient() throws Exception {
        Client client = new Client();
        client.setClientId(1L);
        client.setName("Jose Lema");
        client.setGender("M");
        client.setAge(30);
        client.setIdentification("1234567890");
        client.setAddress("Otavalo sn y principal");
        client.setPhone("098254785");
        client.setPassword("1234");
        client.setStatus(true);

        ObjectMapper objectMapper = new ObjectMapper();
        String clientJson = objectMapper.writeValueAsString(client);

        mockMvc.perform(MockMvcRequestBuilders.post("/clients")
                .contentType(MediaType.APPLICATION_JSON)
                .content(clientJson))
                .andExpect(status().isOk());

        Client foundClient = clientRepository.findById("1234567890").orElse(null);
        assertThat(foundClient).isNotNull();
        assertThat(foundClient.getName()).isEqualTo("Jose Lema");
    }
}
