package by.it.narushevich.jd03_02.crud;

import by.it.narushevich.jd03_02.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class UserCRUD {

    public boolean create(User user) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "INSERT INTO `users`" +
                        "(`nickname`, `login`, `password`, `email`, `roles_id`) " +
                        "VALUES ('%s','%s','%s','%s',%d)",
                user.getNickname(),user.getLogin(),user.getPassword(),user.getEmail(),user.getRoles_id());
        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement()
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
                "SELECT * FROM `users` WHERE `id`=%d", id);
        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return new User(
                        resultSet.getLong("id"),
                        resultSet.getString("nickname"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getString("email"),
                        resultSet.getLong("roles_id"));
            }
        }
        return null;
    }

    public boolean update(User user) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "UPDATE `users` " +
                        "SET `nickname`='%s',`login`='%s',`password`='%s'," +
                        "`email`='%s',`roles_id`=%d WHERE `id`=%d",
                user.getNickname(), user.getLogin(), user.getPassword(),
                user.getEmail(), user.getRoles_id(), user.getId());
        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement()
        ) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    public boolean delete(User user) throws SQLException {
        String sql = String.format(Locale.ENGLISH, "DELETE FROM `users` WHERE `id`=%d", user.getId());
        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement()
        ) {
            return (1 == statement.executeUpdate(sql));
        }
    }
}
