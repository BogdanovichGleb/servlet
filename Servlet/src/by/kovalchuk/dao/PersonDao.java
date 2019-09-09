package by.kovalchuk.dao;

import by.kovalchuk.model.Person;
import by.kovalchuk.model.User;
import by.kovalchuk.util.ConnectorDB;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersonDao {

    private final static String SQL_GET_PERSONS = "SELECT * FROM persons";
    private final static String SQL_INSERT_PERSON = "INSERT INTO persons(name, phone, email) VALUES (? ,?, ?)";
    private final static String SQL_DELETE_PERSON = "DELETE FROM persons WHERE id = ?";
    private static Connection connection;

    public PersonDao() {
        try {
            if (connection == null) {
                connection = ConnectorDB.getConnection();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertPerson(Person person) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_PERSON);
            preparedStatement.setString(1, person.getName());
            preparedStatement.setString(2, person.getPhone());
            preparedStatement.setString(3, person.getEmail());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Person> getPersons() {
        List<Person> persons = new LinkedList<Person>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_GET_PERSONS);
            Person person = null;
            while (resultSet.next()) {
                person = new Person();
                person.setName(resultSet.getString("name"));
                person.setPhone(resultSet.getString("phone"));
                person.setEmail(resultSet.getString("email"));
                persons.add(person);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return persons;
    }

    public  boolean deletePerson (int id) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_DELETE_PERSON);
            statement.setInt(1, id);
            statement.execute();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

}
