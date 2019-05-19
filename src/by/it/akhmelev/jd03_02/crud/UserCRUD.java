package by.it.akhmelev.jd03_02.crud;

import by.it.akhmelev.jd03_02.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class UserCRUD {

    public boolean create(User user) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "INSERT INTO " +
                        "`users`(`login`, `password`, `email`, `roles_id`) " +
                        "VALUES ('%s','%s','%s',%d)",
                user.getLogin(), user.getPassword(), user.getEmail(), user.getRolesId()
        );

        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement();
        ) {
            int count = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (count == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    user.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    public User read(long id) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "SELECT * FROM `users` WHERE `id`=%d", id
        );

        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement();
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                User user = new User(
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


    public boolean update(User user) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "UPDATE `users` " +
                        "SET `login`='%s',`password`='%s'," +
                        "`email`='%s',`roles_id`=%d WHERE `id`=%d",
                user.getLogin(), user.getPassword(),
                user.getEmail(), user.getRolesId(), user.getId()
        );

        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement();
        ) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    public boolean delete(User user) throws SQLException {
        String sql = String.format(Locale.ENGLISH, "DELETE FROM `users` WHERE `id`=%d", user.getId());
        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement();
        ) {
            return (1 == statement.executeUpdate(sql));
        }
    }

}
