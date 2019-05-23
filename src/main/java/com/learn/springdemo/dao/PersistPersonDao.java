package com.learn.springdemo.dao;

import com.learn.springdemo.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.UUID;

@Repository
@Transactional
public class PersistPersonDao {

    @Autowired
    private SessionFactory factory;

    public void savePerson(Person person) {
        getSession().save(new Person(UUID.randomUUID(), person.getName()));
    }

    private Session getSession() {
        Session session = factory.getCurrentSession();
        if (session == null) {
            session = factory.openSession();
        }
        return session;
    }
}
