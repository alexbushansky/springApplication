package com.bushanskiy.springapplication.dao;

import com.bushanskiy.springapplication.model.Person;
import com.bushanskiy.springapplication.utils.OracleConnUtils;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDaoImp implements PersonDao {

    public List<Person> getAllPersons()
    {
        String getAllPersons = "Select person_id, first_name, last_name from person";

        List<Person> persons = new ArrayList<>();

        try(Connection connection = OracleConnUtils.getOracleConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(getAllPersons)) {

            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Person person = new Person(rs.getInt("person_id"), rs.getString("first_name")
                                                                                ,rs.getString("last_name"));
                persons.add(person);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return persons;
    }


    public void addNewPerson(Person person)
    {
        String addNewPerson = "INSERT INTO person(first_name,last_name)" +
                "VALUES(?,?)";

        try(Connection connection = OracleConnUtils.getOracleConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(addNewPerson)) {

            preparedStatement.setString(1, person.getFirstName());
            preparedStatement.setString(2, person.getLastName());
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }
    }

    @Override
    public void deletePerson(int id) {
        String deletePerson = "Delete from person where person_id = ?";
        try(Connection connection = OracleConnUtils.getOracleConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(deletePerson)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }
    }

    @Override
    public void updatePerson(int id, String firstName, String lastName) {
        String updatePerson = "UPDATE person SET first_name = ?, last_name = ? WHERE person_id = ?";

        try(Connection connection = OracleConnUtils.getOracleConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(updatePerson)) {
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setInt(3, id);
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException throwable) {
            throwable.printStackTrace();
        }
    }


}
