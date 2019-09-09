package by.kovalchuk.util;


import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

public class ConnectorDB {

    private static final Logger LOGGER = Logger.getLogger(ConnectorDB.class);
    public static Connection getConnection() {

        Connection dbConnection;


        ResourceBundle resourceBundle = ResourceBundle.getBundle("db", Locale.getDefault());
        String driver = resourceBundle.getString("db.driver");
        String url = resourceBundle.getString("db.url");
        String user = resourceBundle.getString("db.user");
        String pass = resourceBundle.getString("db.password");
        try {

            Class.forName(driver);

            dbConnection = DriverManager.getConnection(url, user, pass);
            if (dbConnection != null) {
                System.out.println("Successfully connected to MySQL database info_db");
                LOGGER.info("Successfully connected to MySQL database info_db");
                return dbConnection;
            }
        } catch (SQLException e) {
            LOGGER.info("An error occurred while connecting MySQL database");
            System.out.println("An error occurred while connecting MySQL database");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
