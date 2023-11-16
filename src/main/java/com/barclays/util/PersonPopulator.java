package com.barclays.util;

import com.barclays.model.Person;
import com.barclays.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PersonPopulator {
    private PersonRepository personRepository;

   // @EventListener(ContextRefreshedEvent.class) - don't have to call populate in main if using this
    public void populate() {
        Person p1 = new Person("Person 1");
        personRepository.save(p1);

        Person p2 = new Person("Person 2");
        personRepository.save(p2);

        Person p3 = new Person("Person 3");
        personRepository.save(p3);

        Person p4 = new Person("Person 4");
        personRepository.save(p4);
    }
}
