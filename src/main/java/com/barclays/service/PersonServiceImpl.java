package com.barclays.service;

import com.barclays.model.Person;
import com.barclays.repository.PersonRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        Optional<Person> person = personRepository.findById(id);
        return person.orElseGet(() -> new Person("No person with id " + id));
    }

    @Override
    public List<Person> findByNameContains(String filter) {
        return personRepository.findByNameContains(filter);
    }

    @Override
    public List<Person> findByNameNotContains(String filter) {
        return personRepository.findByNameNotContains(filter);
    }

    @Override
    public List<Person> searchByName(String name) {
        return personRepository.searchByName(name);
    }

    @Override
    public Person save(Person person) {
        return personRepository.save(person);
    }

    @Override
    public void deleteById(int id) {
        personRepository.deleteById(id);
    }
}
