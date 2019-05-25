package by.it.zalesky.jd03_02;

import by.it.zalesky.jd03_01.CN;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class C_Reset {

    public static void main(String[] args) throws SQLException {
        try (
        Connection connection= DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
        Statement statement = connection.createStatement()
        ){
            statement.executeUpdate("DROP SCHEMA IF EXISTS `zalesky`");
        }

    }
}
