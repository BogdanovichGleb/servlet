package by.kovalchuk.builder;

import by.kovalchuk.exception.RepositoryException;

import java.sql.ResultSet;

public interface Builder <T>{

    T build(ResultSet resultSet) throws  RepositoryException;
}
