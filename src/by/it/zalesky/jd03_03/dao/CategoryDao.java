package by.it.zalesky.jd03_03.dao;

import by.it.zalesky.jd03_03.beans.Category;
import by.it.zalesky.jd03_03.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CategoryDao extends AbstractDao<Category>{
    @Override
    public boolean create(Category category) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "INSERT INTO " +
                        "`category`(`name`) " +
                        "VALUES ('%s')",
                category.getName()
        );

        long id = executeCreate(sql);
        if (id > 0)
            category.setId(id);
        return id > 0;
    }

    @Override
    public boolean update(Category category) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "UPDATE `category` " +
                        "SET `name`='%s' WHERE `id`=%d",
                category.getName(), category.getId()
        );
        return executeUpdate(sql);
    }

    @Override
    public boolean delete(Category category) throws SQLException {
        String sql = String.format(Locale.ENGLISH, "DELETE FROM `category` WHERE `id`=%d", category.getId());
        return executeUpdate(sql);
    }

    @Override
    public Category read(long id) throws SQLException {
        String where=String.format(" WHERE `id`='%d' LIMIT 0,1", id);
        List<Category> categories = getAll(where);
        if (categories.size() == 1)
            return categories.get(0);
        else
            return null;
    }

    @Override
    public List<Category> getAll() throws SQLException {
        return getAll("");
    }

    @Override
    public List<Category> getAll(String where) throws SQLException {
        List<Category> categories = new ArrayList<>();
        String sql = String.format(Locale.ENGLISH,
                "SELECT * FROM `category` %s", where
        );

        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Category category = new Category(
                        resultSet.getLong("id"),
                        resultSet.getString("name")
                );

                categories.add(category);
            }
        }
        return categories;
    }
}
