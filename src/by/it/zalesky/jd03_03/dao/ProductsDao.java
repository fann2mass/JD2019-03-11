package by.it.zalesky.jd03_03.dao;

import by.it.zalesky.jd03_03.beans.Products;
import by.it.zalesky.jd03_03.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ProductsDao extends AbstractDao<Products> {
    @Override
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
        long id = executeCreate(sql);
        if (id > 0)
            products.setId(id);
        return id > 0;
    }

    @Override
    public boolean update(Products products) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "UPDATE `products` SET " +
                        "`title`='%s',`description`='%s'," +
                        "`price`=%d,`category_id`=%d WHERE id=%d",
                products.getTitle(), products.getDescription(),
                products.getPrice(), products.getCategoryId(), products.getId()
        );
        return executeUpdate(sql);

    }

    @Override
    public boolean delete(Products products) throws SQLException {
        String sql = String.format(Locale.ENGLISH, "DELETE FROM `products` WHERE `id`=%d", products.getId());
        return executeUpdate(sql);

    }

    @Override
    public Products read(long id) throws SQLException {
        String where=String.format(" WHERE `id`='%d' LIMIT 0,1", id);
        List<Products> products = getAll(where);
        if (products.size() == 1)
            return products.get(0);
        else
            return null;
    }

    @Override
    public List<Products> getAll() throws SQLException {
        return getAll("");

    }

    @Override
    public List<Products> getAll(String where) throws SQLException {
        List<Products> product = new ArrayList<>();
        String sql = String.format(Locale.ENGLISH,
                "SELECT * FROM `products` %s", where
        );

        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Products products = new Products(
                        resultSet.getLong("id"),
                        resultSet.getString("title"),
                        resultSet.getString("description"),
                        resultSet.getInt("price"),
                        resultSet.getLong("category_id")
                );

                product.add(products);
            }
        }
        return product;
    }
}

