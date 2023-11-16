package com.barclays.controller;

import com.barclays.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PersonControllerIntegrationTests {
    @Autowired
    PersonController personController;

    @Test
    public void testGetPeople() {
        List<Person> people = personController.getPeople();
        assertEquals(8, people.size());
    }

    @Test
    public void testGetMessage() {
        int id = 1;
        Person person = personController.getPerson(id);
        assertEquals("Shona " + id, person.getName());
    }
}
