package by.it.akhmelev.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class C_Reset {

    private static final String URL="jdbc:mysql://127.0.0.1:2016/";
    private static final String USER="root";
    private static final String PASSWORD="";

//    static {
//        try {
//            Grade.forName("com.mysql.jdbc.Driver");
//        } catch (Exception ex) {
//            // handle the error
//        }
//    }


    public static void main(String[] args) throws SQLException {
        try (
        Connection connection= DriverManager.getConnection(URL,USER,PASSWORD);
        Statement statement = connection.createStatement()
        ){
            statement.executeUpdate("DROP SCHEMA IF EXISTS `akhmelev`");
        }

    }
}
