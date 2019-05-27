package by.it.zalesky.jd03_03.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionCreator {

    private ConnectionCreator() {
    }

    private static Connection connection;

//    static {
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//        } catch (Exception ex) {
    // handle the error
//        }
//    }

    private static final String URL = "jdbc:mysql://127.0.0.1:2016/zalesky?" +
            "useUnicode=true&" +
            "characterEncoding=UTF-8&" +
            "useJDBCCompliantTimezoneShift=true&" +
            "useLegacyDatetimeCode=false&" +
            "serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection get() throws SQLException {
        if (connection == null || connection.isClosed()) {
            synchronized (ConnectionCreator.class) {
                if (connection == null || connection.isClosed()) {
                    connection= DriverManager.getConnection(URL,USER,PASSWORD);
                }
            }
        }
        return connection;
    };
}