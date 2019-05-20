package by.it.bolotko.jd03_02.crud;

import by.it.bolotko.jd03_02.beans.Role;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class RoleCRUD {

    public boolean create(Role role) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "INSERT INTO " +
                        "`roles`(`role`) " +
                        "VALUES ('%s')",
                role.getRole()
        );

        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement()
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

    public Role read(long id) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "SELECT * FROM `roles` WHERE `id`=%d", id
        );

        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {

                return new Role(
                        resultSet.getLong("id"),
                        resultSet.getString("role")
                );
            }
        }
        return null;
    }


    public void update(Role role) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "UPDATE `roles` " +
                        "SET `role`='%s' WHERE `id`=%d",
                role.getRole(), role.getId()
        );

        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement()
        ) {
            statement.executeUpdate(sql);
        }
    }

    public boolean delete(Role role) throws SQLException {
        String sql = String.format(Locale.ENGLISH, "DELETE FROM `roles` WHERE `id`=%d", role.getId());
        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement()
        ) {
            return (1 == statement.executeUpdate(sql));
        }
    }

}
