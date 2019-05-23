package com.learn.springdemo.service;

import com.learn.springdemo.dao.PersistPersonDao;
import com.learn.springdemo.dao.PersonDao;
import com.learn.springdemo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PersonService {

    private final PersonDao personDao;
    private final PersistPersonDao persistPersonDao;

    @Autowired
    public PersonService(@Qualifier("person") PersonDao personDao, PersistPersonDao persistPersonDao) {
        this.persistPersonDao = persistPersonDao;
        this.personDao = personDao;
    }

    public int addPerson(Person person) {
        return personDao.insertPerson(person);
    }

    public List<Person> getPerson() {
        return personDao.getPerson();
    }

    public int deletePerson(UUID id) {
        return personDao.deletePerson(id);
    }

    public int updatePerson(UUID id, Person person) {
        return personDao.updatePerson(id, person);
    }

    public Person selectPersonById(UUID id) {
        return personDao.selectPersonById(id).orElse(null);
    }

    public void savePerson(Person person) {
        persistPersonDao.savePerson(person);
    }
}
