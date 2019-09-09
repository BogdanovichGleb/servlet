package by.kovalchuk.builder;

import by.kovalchuk.exception.RepositoryException;
import by.kovalchuk.model.Person;
import by.kovalchuk.repository.dbconstants.PersonTableConstants;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonBuilder implements Builder<Person> {

    @Override
    public Person build(ResultSet resultSet) throws RepositoryException {

        try {
            int id = resultSet.getInt(PersonTableConstants.ID.getFieldName());
            String name = resultSet.getString(PersonTableConstants.NAME.getFieldName());
            String phone = resultSet.getString(PersonTableConstants.PHONE.getFieldName());
            String email = resultSet.getString(PersonTableConstants.EMAIL.getFieldName());

            return new Person(id, name, phone, email);

        } catch (SQLException e) {
            throw new RepositoryException(e.getMessage(), e);
        }

    }
}
