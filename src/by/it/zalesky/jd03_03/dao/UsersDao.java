package by.it.zalesky.jd03_03.dao;


import by.it.zalesky.jd03_03.beans.Users;
import by.it.zalesky.jd03_03.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class UsersDao extends AbstractDao<Users> {

    @Override
    public boolean create(Users users) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "INSERT INTO " +
                        "`users`(`login`, `password`, `email`, `roles_id`) " +
                        "VALUES ('%s','%s','%s',%d)",
                users.getLogin(), users.getPassword(), users.getEmail(), users.getRolesId()
        );
        long id = executeCreate(sql);
        if (id > 0)
            users.setId(id);
        return id > 0;
    }

    @Override
    public boolean update(Users users) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "UPDATE `users` " +
                        "SET `login`='%s',`password`='%s'," +
                        "`email`='%s',`roles_id`=%d WHERE `id`=%d",
                users.getLogin(), users.getPassword(),
                users.getEmail(), users.getRolesId(), users.getId()
        );

        return executeUpdate(sql);
    }

    @Override
    public boolean delete(Users users) throws SQLException {
        String sql = String.format(Locale.ENGLISH, "DELETE FROM `users` WHERE `id`=%d", users.getId());
        return executeUpdate(sql);
    }

    @Override
    public Users read(long id) throws SQLException {
        String where = String.format("WHERE `id`='%d' LIMIT 0,1", id);
        List<Users> users = getAll(where);
        if (users.size() == 1)
            return users.get(0);
        else
            return null;
    }

    @Override
    public List<Users> getAll() throws SQLException {
        return getAll("");
    }

    @Override
    public List<Users> getAll(String where) throws SQLException {
        List<Users> users = new ArrayList<>();
        String sql = String.format(Locale.ENGLISH,
                "SELECT * FROM `users` %s", where
        );

        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Users users1 = new Users(
                        resultSet.getLong("id"),
                        resultSet.getString("login"),
                        resultSet.getString("password"),
                        resultSet.getString("email"),
                        resultSet.getLong("roles_id")
                );

                users.add(users1);
            }
        }
        return users;
    }


    }

