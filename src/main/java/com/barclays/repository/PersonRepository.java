package com.barclays.repository;

import com.barclays.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository <Person, Integer> {
    List<Person> findByNameNotContains(String filter);
}
