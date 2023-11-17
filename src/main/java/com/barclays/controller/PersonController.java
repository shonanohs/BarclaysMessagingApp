package com.barclays.controller;

import com.barclays.model.Person;
import com.barclays.service.PersonService;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@AllArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping("/people")
    public List<Person> getPeople(@PathParam("filter") String filter, @PathParam("notContainsFilter") String notContainsFilter) {
        List<Person> people = Collections.emptyList();
        if(StringUtils.isNotBlank(filter)) {
            people = personService.findByNameNotContains(filter);
        }
        else if(StringUtils.isNotBlank(notContainsFilter)) {
            people = personService.findByNameNotContains(notContainsFilter);
        }
        else {
            people = personService.findAll();
        }
        return people;
    }

    @GetMapping("/people/{id}")
    public Person getPerson (@PathVariable int id) {
       return personService.findById(id);
    }

    @GetMapping("/person/search")
    public List<Person> searchByName(@PathParam("name") String name) {
        return personService.searchByName(name);
    }
}
