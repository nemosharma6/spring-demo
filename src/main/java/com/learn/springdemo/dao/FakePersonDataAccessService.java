package com.learn.springdemo.dao;

import com.learn.springdemo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fake person")
public class FakePersonDataAccessService implements PersonDao {

    @Override
    public int insertPerson(UUID id, Person person) {
        return 0;
    }

    @Override
    public int insertPerson(Person person) {
        return 0;
    }

    @Override
    public List<Person> getPerson() {
        return new ArrayList<Person>() {{
            add(new Person(UUID.randomUUID(), "fake data"));
        }};
    }

    @Override
    public int deletePerson(UUID id) {
        return 0;
    }

    @Override
    public int updatePerson(UUID id, Person person) {
        return 0;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return Optional.empty();
    }
}
