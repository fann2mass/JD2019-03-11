package by.it.narushevich.jd03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.SQLException;

public class CheckConnection {

    public static void check(Connection connection) throws SQLException {

        if (!connection.isClosed())
            System.out.println("Соединение установлено");
        if (connection.isClosed())
            System.out.println("Соединение прервано");

    }
}
