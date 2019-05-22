package com.learn.springdemo.dao;

import com.learn.springdemo.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {

    int insertPerson(UUID id, Person person);

    default int insertPerson(Person person) {
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }

    List<Person> getPerson();

    int deletePerson(UUID id);

    int updatePerson(UUID id, Person person);

    Optional<Person> selectPersonById(UUID id);
}
