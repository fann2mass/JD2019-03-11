package by.it.narushevich.jd03_02;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionCreator {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception ex) {
            // handle the error
        }
    }

    private static Connection connection;

    static final String URL = "jdbc:mysql://127.0.0.1:2016/" +
            "useUnicode=true&" +
            "characterEncoding=UTF-8&" +
            "";
    static final String USER = "root";
    static final String PASSWORD = "";

    static Connection get() throws SQLException {

        return null;
    };
}
