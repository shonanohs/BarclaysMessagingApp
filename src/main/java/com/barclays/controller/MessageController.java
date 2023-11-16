package com.barclays.controller;

import com.barclays.model.Message;
import com.barclays.service.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class MessageController {
    private final MessageService messageService;

    @GetMapping("/messages")
    public List<Message> getAllMessages() {
        return messageService.findAll();
    }

    @GetMapping("/messages/{id}")
    public Message getMessage(@PathVariable int id) {
        return messageService.findById(id);
    }
}
