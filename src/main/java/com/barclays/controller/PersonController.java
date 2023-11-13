package com.barclays.controller;

import com.barclays.model.Person;
import org.springframework.web.bind.annotation.GetMapping;
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
}
