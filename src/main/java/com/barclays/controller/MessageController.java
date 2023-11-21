package com.barclays.controller;

import com.barclays.model.Message;
import com.barclays.model.Person;
import com.barclays.service.MessageService;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@AllArgsConstructor
public class MessageController {
    private final MessageService messageService;

    @GetMapping("/messages")
    public List<Message> getAllMessages(@PathParam("filter") String filter) {
        List<Message> messages = Collections.emptyList();
        if(StringUtils.isNotBlank(filter)) {
            messages = messageService.findByContentContains(filter);
        }
        else {
            messages = messageService.findAll();
        }
        return messages;
    }

    @GetMapping("/messages/{id}")
    public Message getMessage(@PathVariable int id) {
        return messageService.findById(id);
    }

    @PostMapping("/messages")
    public Message createMessage(@RequestBody Message message) {
        return messageService.save(message);
    }

    @PutMapping("/messages")
    public Message updateMessage (@RequestBody Message message) {
        return messageService.save(message);
    }

    @DeleteMapping("/messages/{id}")
    public void deleteMessage (@PathVariable int id) {
        messageService.deleteById(id);
    }

}
