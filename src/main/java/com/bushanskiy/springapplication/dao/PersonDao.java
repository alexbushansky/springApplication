package com.bushanskiy.springapplication.dao;

import com.bushanskiy.springapplication.model.Person;

import java.util.List;

public interface PersonDao {

    List<Person> getAllPersons();
    void addNewPerson(Person person);
    void deletePerson(int id);
    void updatePerson(int id, String firstName, String lastName);
}
