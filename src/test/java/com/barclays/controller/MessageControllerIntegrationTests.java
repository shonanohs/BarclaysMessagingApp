package com.barclays.controller;

import com.barclays.model.Message;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class MessageControllerIntegrationTests {

    @Autowired
    MessageController messageController;

    @Test
    public void testGetAllMessages() {
        List<Message> messages = messageController.getAllMessages("");
        assertEquals(4, messages.size());
    }

    @Test
    public void testGetMessage() {
        int id = 100;
        Message message = messageController.getMessage(id);
        assertEquals("first message", message.getContent());
    }

    @Test
    public void testGetInvalidMessage() {
        int id = 1;
        Message message = messageController.getMessage(id);
        assertEquals("Default message: nothing found", message.getContent());
    }
}
