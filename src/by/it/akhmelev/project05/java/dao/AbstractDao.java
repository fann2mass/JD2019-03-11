package by.it.akhmelev.project05.java.dao;


import by.it.akhmelev.project05.java.connect.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

abstract class AbstractDao<T> implements InterfaceDao<T>{

    long executeCreate(String sql) throws SQLException {
        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement()
        ) {
            int count = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (count == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    return generatedKeys.getLong(1);
                }
            }
        }
        return -1;
    }

    boolean executeUpdate(String sql) throws SQLException{
        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement()
        ) {
            return (1 == statement.executeUpdate(sql));
        }
    }


}
