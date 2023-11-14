package com.barclays.service;

import com.barclays.model.Message;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class MessageServiceImpl implements MessageService {

    @Override
    public List<Message> findAll() {
        List<Message> messages = new ArrayList<>();
        Message message = new Message();
        message.setContent("Spring is cool");
        messages.add(message);
        return messages;
    }

    public Message findById(int id) {
        Message message = new Message();
        message.setContent("Spring is cool " + id);
        return message;
    }
}
