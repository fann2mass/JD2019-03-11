package by.it.zalesky.jd03_03.crud;

import by.it.zalesky.jd03_03.beans.Users;
import by.it.zalesky.jd03_03.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class UsersCRUD {

    public boolean create(Users users) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "INSERT INTO " +
                        "`users`(`login`, `password`, `email`, `roles_id`) " +
                        "VALUES ('%s','%s','%s',%d)",
                users.getLogin(), users.getPassword(), users.getEmail(), users.getRolesId()
        );

        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement();
        ) {
            int count = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (count == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    users.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    public Users read(long id) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "SELECT * FROM `users` WHERE `id`=%d", id
        );

        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement();
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                Users user = new Users(
                        resultSet.getLong("id"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getString("email"),
                        resultSet.getLong("roles_id")
                );

                return user;
            }
        }
        return null;
    }


    public boolean update(Users users) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "UPDATE `users` " +
                        "SET `login`='%s',`password`='%s'," +
                        "`email`='%s',`roles_id`=%d WHERE `id`=%d",
                users.getLogin(), users.getPassword(),
                users.getEmail(), users.getRolesId(), users.getId()
        );

        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement();
        ) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    public boolean delete(Users users) throws SQLException {
        String sql = String.format(Locale.ENGLISH, "DELETE FROM `users` WHERE `id`=%d", users.getId());
        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement();
        ) {
            return (1 == statement.executeUpdate(sql));
        }
    }

}
