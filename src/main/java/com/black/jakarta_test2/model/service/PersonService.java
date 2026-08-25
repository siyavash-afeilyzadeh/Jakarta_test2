package com.black.jakarta_test2.model.service;

import com.black.jakarta_test2.model.da.PersonDa;
import com.black.jakarta_test2.model.entity.Person;

import java.util.List;

public class PersonService {
    public void save(Person person) throws Exception {
        try (PersonDa personDa = new PersonDa()) {
            personDa.save(person);
        }
    }

    public List<Person> findAll() throws Exception {
        try (PersonDa personDa = new PersonDa()) {
            personDa.findAll();
        }
    }
}
