package by.it.zalesky.jd03_02.crud;


import by.it.zalesky.jd03_02.beans.Category;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class CategoryCRUD {

    public boolean create(Category name) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "INSERT INTO " +
                        "`category`(`name`) " +
                        "VALUES ('%s')",
                name.getName()
        );
        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement()
        ) {
            int count = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (count == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    name.setId(generatedKeys.getInt(1));
                    return true;
                }
            }
        }
        return false;

    }

    public Category read(long id) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "SELECT * FROM `category` WHERE `id`=%d", id
        );

        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return new Category(
                        resultSet.getInt("id"),
                        resultSet.getString("name")
                );
            }
        }
        return null;
    }


    public boolean update(Category name) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "UPDATE `category` " +
                        "SET `name`='%s' WHERE `id`=%d",
                name.getName(), name.getId()
        );

        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement()
        ) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    public boolean delete(Category name) throws SQLException {
        String sql = String.format(Locale.ENGLISH, "DELETE FROM `category` WHERE `id`=%d", name.getId());
        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement()
        ) {
            return (1 == statement.executeUpdate(sql));
        }
    }

}

