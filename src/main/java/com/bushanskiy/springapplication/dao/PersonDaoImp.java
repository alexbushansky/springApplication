package com.bushanskiy.springapplication.dao;

import com.bushanskiy.springapplication.model.Person;
import com.bushanskiy.springapplication.model.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class PersonDaoImp implements PersonDao {


    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDaoImp(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public List<Person> getAllPersons()
    {
        String getAllPersons = "Select person_id, first_name, last_name from person";
        return jdbcTemplate.query(getAllPersons, new PersonMapper());
    }


    public void addNewPerson(Person person)
    {
        String addNewPerson = "INSERT INTO person(first_name,last_name)" +
                "VALUES(?,?)";
        jdbcTemplate.update(addNewPerson, person.getFirstName(), person.getLastName());
    }

    @Override
    public void deletePerson(int id) {
        String deletePerson = "Delete from person where person_id = ?";
        jdbcTemplate.update(deletePerson, id);
    }

    @Override
    public void updatePerson(int id, String firstName, String lastName) {
        String updatePerson = "UPDATE person SET first_name = ?, last_name = ? WHERE person_id = ?";
        jdbcTemplate.update(updatePerson, firstName, lastName,id);
    }


}
