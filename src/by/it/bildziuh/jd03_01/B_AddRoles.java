package by.it.bildziuh.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class B_AddRoles {

    private static final String URL = "jdbc:mysql://127.0.0.1:2016/";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) throws SQLException {
        try (
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement statement = connection.createStatement()
        ) {
            statement.executeUpdate("INSERT INTO `bildziuh`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'Administrator');\n");
            statement.executeUpdate("INSERT INTO `bildziuh`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'Moderator');\n");
            statement.executeUpdate("INSERT INTO `bildziuh`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'User');\n");
            statement.executeUpdate("INSERT INTO `bildziuh`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'Guest');\n");
            statement.executeUpdate("INSERT INTO `bildziuh`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'TestRole');\n");
        }
    }
}