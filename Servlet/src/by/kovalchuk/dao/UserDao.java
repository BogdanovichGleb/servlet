package by.kovalchuk.dao;

import java.sql.*;

import by.kovalchuk.model.User;
import by.kovalchuk.util.ConnectorDB;

public class UserDao {

    private static Connection connection;
    private final String SQL_CHECK_USER = "SELECT login, password FROM users WHERE login=? AND password=?";
    private final static String SQL_CHECK_LOGIN = "SELECT login FROM users WHERE login = ?";
    private final static String SQL_INSERT_USER = "INSERT INTO users(login ,password, id_role) VALUES (? , ?, ?)";


    public UserDao() {
        if (connection == null) {
            try {
                connection = ConnectorDB.getConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isValidUser(final String login, final byte[] password) {
        PreparedStatement ps = null;
        try {
            System.out.println("connection    " + connection);
            ps = connection.prepareStatement(SQL_CHECK_USER);
            ps.setString(1, login);
            ps.setBytes(2, password);

            ResultSet rs = ps.executeQuery();
            System.out.println(rs);

            while (rs.next()) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch
                (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    public boolean insertUser(User user) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_CHECK_LOGIN);
            preparedStatement.setString(1, user.getLogin());
            ResultSet result = preparedStatement.executeQuery();
            if (result.next()) {
                preparedStatement.close();
                return false;
            } else {
                preparedStatement = connection.prepareStatement(SQL_INSERT_USER);
                preparedStatement.setString(1, user.getLogin());
                preparedStatement.setBytes(2, user.getPassw());
                preparedStatement.setInt(3, user.getRole());
                preparedStatement.executeUpdate();
                preparedStatement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }


}
