package by.it.narushevich.jd03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class C_reset {

    public static void resetDataBase(Statement statement) throws SQLException {

        statement.executeUpdate("DROP SCHEMA IF EXISTS `narushevich` ;");
    }
}