package com.barclays.controller;

import com.barclays.model.Message;
import com.barclays.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonControllerTests {

    @Test
    public void testGetPeople() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Person[]> response =
                restTemplate.getForEntity("http://localhost:8080/people", Person[].class);
        Person[] people = response.getBody();
        assertEquals(people.length, 1);
    }

    @Test
    public void testGetPerson() {
        int id = 1;
        RestTemplate restTemplate = new RestTemplate();
        Person person =
                restTemplate.getForObject("http://localhost:8080/people/" + id, Person.class);
        assertEquals(person.getName(), "Shona " + id);
    }
}
