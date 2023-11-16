package com.barclays.util;

import com.barclays.model.Message;
import com.barclays.repository.MessageRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MessagePopulator {
    private MessageRepository messageRepository;

   @EventListener(ContextRefreshedEvent.class)
    public void populate() {
        Message m1 = new Message("Message 1");
        messageRepository.save(m1);

        Message m2 = new Message("Message 2");
        messageRepository.save(m2);

        Message m3 = new Message("Message 3");
        messageRepository.save(m3);

        Message m4 = new Message("Message 4");
        messageRepository.save(m4);
    }
}
