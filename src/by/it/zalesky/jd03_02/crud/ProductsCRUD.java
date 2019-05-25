package by.it.zalesky.jd03_02.crud;

import by.it.zalesky.jd03_02.beans.Products;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class ProductsCRUD{
    public boolean create(Products products) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "INSERT INTO `Products`(" +
                        "`title`, `description`, " +
                        "`price`, `category_id`)" +
                        "VALUES ('%s','%s'," +
                        "'%d','%d')",
                products.getTitle(), products.getDescription(),
                products.getPrice(), products.getCategoryId()
        );
        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement()
        ) {
            int count = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (count == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    products.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;

    }

    public Products read(long id) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "SELECT * FROM `products` WHERE `id`=%d", id
        );

        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                Products products = new Products(
                        resultSet.getLong("id"),
                        resultSet.getString("title"),
                        resultSet.getString("description"),
                        resultSet.getInt("price"),
                        resultSet.getLong("category_id")
                        );

                return products;
            }
        }
        return null;
    }


    public boolean update(Products products) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "UPDATE `products` SET " +
                        "`title`='%s',`description`='%s'," +
                        "`price`=%d,`category_id`=%d WHERE id=%d",
                products.getTitle(), products.getDescription(),
                products.getPrice(), products.getCategoryId(), products.getId()
        );

        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement()
        ) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    public boolean delete(Products products) throws SQLException {
        String sql = String.format(Locale.ENGLISH, "DELETE FROM `products` WHERE `id`=%d", products.getId());
        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement()
        ) {
            return (1 == statement.executeUpdate(sql));
        }
    }
}