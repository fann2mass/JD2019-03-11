package by.it.khlystunova.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class A_AddUser {

//    static {
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//        } catch (Exception ex) {
//            // handle the error
//        }
//    }

    public static void main(String[] args) throws SQLException {
        try (Connection connection= DriverManager.getConnection(CN.URL,CN.USER,CN.PASSWORD);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("INSERT INTO `khlystunova`.`users` (`ID`, `Login`, `Password`, `Email`, `roles_ID`) VALUES (DEFAULT, 'Tolmachova', 'ejfhbvfdv', 'tolmach@gmail.com', 2);\n");

        }
    }
}
