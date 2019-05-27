package by.it.zalesky.jd03_02.crud;

import by.it.zalesky.jd03_02.beans.Orders;
import by.it.zalesky.jd03_02.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class OrdersCRUD{

    public boolean create(Orders orders) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "INSERT INTO `orders`(" +
                        "`price`, `quantity`, " +
                        "`address`,`users_id`, " +
                        "`products_id`) " +
                        "VALUES (%d,%d,'%s', " +
                        "'%d','%d')",
                orders.getPrice(), orders.getQuantity(),
                orders.getAddress(), orders.getUsersId(),
                orders.getProductsId()
        );

        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement();
        ) {
            int count = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (count == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    orders.setId(generatedKeys.getInt(1));
                    return true;
                }
            }
        }
        return false;
    }
    public Orders read(long id) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "SELECT * FROM `orders` WHERE `id`=%d", id
        );

        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement();
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                Orders orders = new Orders(
                        resultSet.getInt("id"),
                        resultSet.getInt("price"),
                        resultSet.getInt("quantity"),
                        resultSet.getString("address"),
                        resultSet.getInt("users_id"),
                        resultSet.getInt("products_id")
                );

                return orders;
            }
        }
        return null;
    }

    public boolean update(Orders orders) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "UPDATE `orders` SET " +
                        "`price`=%d,`quantity`=%d," +
                        "`address`='%s', " +
                        "`products_id`=%d, `users_id`=%d WHERE `id`=%d",
                orders.getPrice(), orders.getQuantity(),
                orders.getAddress(), orders.getProductsId(),
                orders.getUsersId(), orders.getId()
        );

        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement();
        ) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    public boolean delete(Orders orders) throws SQLException {
        String sql = String.format(Locale.ENGLISH, "DELETE FROM `orders` WHERE `id`=%d", orders.getId());
        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement();
        ) {
            return (1 == statement.executeUpdate(sql));
        }
    }
    
}