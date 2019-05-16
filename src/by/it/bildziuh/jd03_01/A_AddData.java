package by.it.bildziuh.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class A_AddData {

    private static final String URL = "jdbc:mysql://127.0.0.1:2016/";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) throws SQLException {
        try (
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement statement = connection.createStatement()
        ) {
            statement.executeUpdate("INSERT `bildziuh`.`mods` (`ID`, `Game`, `Group`, `Name`, `Description`, `Size`, `Link`, `users_ID`) VALUES (DEFAULT, 'World of warcraft', 'UI', 'Deadly Boss Mods', 'New info panels for vanilla pack', 420, 'gdisk', 4);\n");
            statement.executeUpdate("INSERT `bildziuh`.`mods` (`ID`, `Game`, `Group`, `Name`, `Description`, `Size`, `Link`, `users_ID`) VALUES (DEFAULT, 'World of warcraft', 'UI', 'DBM Draenor', 'New info panels for draenor expansion', 42, 'gdisk', 4);\n");
            statement.executeUpdate("INSERT `bildziuh`.`mods` (`ID`, `Game`, `Group`, `Name`, `Description`, `Size`, `Link`, `users_ID`) VALUES (DEFAULT, 'World of warcraft', 'UI', 'DBM Legion', 'New info panels for legion expansion', 84, 'gdisk', 4);\n");
        }
    }
}