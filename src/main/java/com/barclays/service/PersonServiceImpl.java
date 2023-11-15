package com.barclays.service;

import com.barclays.model.Person;
import com.barclays.repository.PersonRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {
    private PersonRepository personRepository;
    @Override
    public List<Person> findAll() {
        List<Person> people = new ArrayList<>();
        Iterable<Person> personIts = personRepository.findAll();
        personIts.forEach(people::add);
        return people;
    }

    @Override
    public Person findById(int id) {
        Person person = new Person();
        person.setName("Shona " + id);
        return person;
    }
}
