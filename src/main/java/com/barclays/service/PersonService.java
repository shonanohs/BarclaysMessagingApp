package com.barclays.service;

import com.barclays.model.Person;

import java.util.List;

public interface PersonService {
    List<Person> findAll();
    Person findById(int id);
}
