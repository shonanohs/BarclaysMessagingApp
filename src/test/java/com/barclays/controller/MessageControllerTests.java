package com.barclays.controller;

import com.barclays.model.Message;
import com.barclays.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class MessageControllerTests {

    @Test
    public void testGetAllMessages() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Message[]> response =
                restTemplate.getForEntity("http://localhost:8080/messages", Message[].class);
        Message[] messages = response.getBody();
        assertEquals(messages.length, 8);
    }

    @Test
    public void testGetMessage() {
        int id = 1;
        RestTemplate restTemplate = new RestTemplate();
        Message message =
                restTemplate.getForObject("http://localhost:8080/messages/" + id, Message.class);
        assertEquals(message.getContent(), "Spring is cool " + id);
    }
}
