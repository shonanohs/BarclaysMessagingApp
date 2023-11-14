package com.barclays.controller;

import com.barclays.model.Person;
import com.barclays.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping("/people")
    public List<Person> getPeople() {
      return personService.findAll();
    }

    @GetMapping("/people/{id}")
    public Person getPerson (@PathVariable int id) {
       return personService.findById(id);
    }
}
