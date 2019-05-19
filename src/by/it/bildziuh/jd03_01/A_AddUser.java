package by.it.bildziuh.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class A_AddUser {

    private static final String URL = "jdbc:mysql://127.0.0.1:2016/";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) throws SQLException {
        try (
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement statement = connection.createStatement()
        ) {
            statement.executeUpdate("INSERT `bildziuh`.`users` (`ID`, `Login`, `Password`, `Email`, `roles_ID`) VALUES (DEFAULT, 'user3', 'user3', 'user3@mail.ru', 3);\n");
        }
    }
}
