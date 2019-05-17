package by.it.narushevich.jd03_01;

import java.sql.*;

public class B_AddRoles {

    public static void createRoles(Statement statement) throws SQLException {
        statement.executeUpdate("insert into roles(id, role)" + "values (default,'administrator')");
        statement.executeUpdate("insert into roles(id, role)" + "values (default,'user')");
        statement.executeUpdate("insert into roles(id, role)" + "values (default,'guest')");
    }
}
