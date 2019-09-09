package by.kovalchuk.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

public class ConnectorDB {


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
                return dbConnection;
            }
        } catch (SQLException e) {
            System.out.println("An error occurred while connecting MySQL database");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
//
//    public static int insert(User users) {
//
//        Connection dbConnection;
//
//        ResourceBundle resourceBundle = ResourceBundle.getBundle("db", Locale.getDefault());
//        String driver = resourceBundle.getString("db.driver");
//        String url = resourceBundle.getString("db.url");
//        String user = resourceBundle.getString("db.user");
//        String pass = resourceBundle.getString("db.password");
//        try {
//            Class.forName(driver);
//
//
//                dbConnection = DriverManager.getConnection(url, user, pass);
//                String sql = "INSERT INTO users (nickname,password,email) Values (?, ?,?)";
////                try (PreparedStatement preparedStatement = dbConnection.prepareStatement(sql)) {
////                    preparedStatement.setString(1, users.getLogin());
////                    preparedStatement.setString(2, users.getPassw());
////                    return preparedStatement.executeUpdate();
//
//
//            } catch (Exception | ClassNotFoundException ex) {
//                System.out.println(ex);
//            }
//            return 0;
//        }
//
//        public static int update (User users){
//
//            try {
//                Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
//                try (Connection conn = DriverManager.getConnection(url, username, password)) {
//
//                    String sql = "UPDATE products SET nickname = ?, password = ?,email = ? WHERE id = ?";
//                    try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
//                        preparedStatement.setString(1, users.getNickName());
//                        preparedStatement.setString(2, users.getPassword());
//                        preparedStatement.setString(3, users.getEmail());
//                        preparedStatement.setInt(4, users.getId());
//
//                        return preparedStatement.executeUpdate();
//                    }
//                }
//            } catch (Exception ex) {
//                System.out.println(ex);
//            }
//            return 0;
//        }
//        public static int delete ( int id){
//
//            try {
//                Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
//                try (Connection conn = DriverManager.getConnection(url, username, password)) {
//
//                    String sql = "DELETE FROM products WHERE id = ?";
//                    try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
//                        preparedStatement.setInt(1, id);
//
//                        return preparedStatement.executeUpdate();
//                    }
//                }
//            } catch (Exception ex) {
//                System.out.println(ex);
//            }
//            return 0;
//        }


}
