package com.barclays.controller;

import com.barclays.model.Message;
import com.barclays.model.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {

    @GetMapping("/people")
    public List<Person> getPeople() {
        List<Person> people = new ArrayList<>();
        Person person = new Person();
        person.setName("Shona");
        people.add(person);
        return people;
    }

    @GetMapping("/people/{id}")
    public Person getPerson (@PathVariable int id) {
        Person person = new Person();
        person.setName("Shona " + id);
        return person;
    }
}
