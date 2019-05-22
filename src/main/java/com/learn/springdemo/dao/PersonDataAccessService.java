package com.learn.springdemo.dao;

import com.learn.springdemo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("person")
public class PersonDataAccessService implements PersonDao {

    private static List<Person> db = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        db.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public List<Person> getPerson() {
        return db;
    }

    @Override
    public int deletePerson(UUID id) {
        Optional<Person> person = db.stream().filter(p -> p.getId().equals(id)).findFirst();
        db.remove(person.orElse(null));
        return 1;
    }

    @Override
    public int updatePerson(UUID id, Person person) {
        Optional<Person> old = db.stream().filter(p -> p.getId().equals(id)).findFirst();
        db.remove(old.orElse(null));
        insertPerson(id, person);
        return 1;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return db.stream().filter(p -> p.getId().equals(id)).findFirst();
    }
}
