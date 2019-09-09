package by.kovalchuk.dao;

import by.kovalchuk.model.Person;
import by.kovalchuk.util.ConnectorDB;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class PersonDao {

    private static final Logger LOGGER = Logger.getLogger(PersonDao.class);

    private final static String SQL_GET_PERSONS = "SELECT * FROM persons";
    private final static String SQL_INSERT_PERSON = "INSERT INTO persons(id, name, phone, email) VALUES (?, ? ,?, ?)";
    private final static String SQL_DELETE_PERSON = "DELETE FROM persons WHERE id = ?";
    private static Connection connection;

    public PersonDao() {
        try {
            if (connection == null) {
                LOGGER.info("get connection");
                connection = ConnectorDB.getConnection();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            if (connection != null) {
                LOGGER.info("close connection");
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertPerson(Person person) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_PERSON);
            preparedStatement.setInt(1, person.getId());
            preparedStatement.setString(2, person.getName());
            preparedStatement.setString(3, person.getPhone());
            preparedStatement.setString(4, person.getEmail());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            LOGGER.info("New Person " + person.getName() +" inserted");
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
                person.setId(resultSet.getInt("id"));
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

    public void deletePerson(Integer id) {
        try {
            PreparedStatement statement = connection.prepareStatement(SQL_DELETE_PERSON);
            statement.setInt(1, id);
//            statement.setString(1, id);
            statement.execute();
            statement.close();
            LOGGER.info("Person id: " + id +" delete");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }



}
