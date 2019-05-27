package by.it.zalesky.jd03_03.crud;

import by.it.zalesky.jd03_03.beans.Roles;
import by.it.zalesky.jd03_03.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class RolesCRUD  {

    public boolean create(Roles role) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "INSERT INTO " +
                        "`roles`(`role`) " +
                        "VALUES ('%s')",
                role.getRole()
        );

        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement();
        ) {
            int count = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (count == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    role.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    public Roles read(long id) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "SELECT * FROM `roles` WHERE `id`=%d", id
        );

        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement();
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                Roles role = new Roles(
                        resultSet.getLong("id"),
                        resultSet.getString("role")
                );

                return role;
            }
        }
        return null;
    }


    public boolean update(Roles role) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "UPDATE `roles` " +
                        "SET `role`='%s' WHERE `id`=%d",
                role.getRole(), role.getId()
        );

        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement();
        ) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    public boolean delete(Roles role) throws SQLException {
        String sql = String.format(Locale.ENGLISH, "DELETE FROM `roles` WHERE `id`=%d", role.getId());
        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement();
        ) {
            return (1 == statement.executeUpdate(sql));
        }
    }

}
