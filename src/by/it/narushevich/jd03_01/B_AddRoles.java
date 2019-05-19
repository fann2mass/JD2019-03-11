package by.it.narushevich.jd03_01;

import java.sql.*;

public class B_AddRoles {

    public static void createRoles(Statement statement) throws SQLException {

        statement.executeUpdate("INSERT INTO narushevich_ab.roles (`id`, `role`) VALUES (DEFAULT, 'administrator');");
        statement.executeUpdate("INSERT INTO narushevich_ab.roles (`id`, `role`) VALUES (DEFAULT, 'user');");
        statement.executeUpdate("INSERT INTO narushevich_ab.roles (`id`, `role`) VALUES (DEFAULT, 'guest');");
    }
}
