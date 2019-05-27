package by.it.zalesky.jd03_03.dao;

import by.it.zalesky.jd03_03.beans.Orders;
import by.it.zalesky.jd03_03.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class OrdersDao extends AbstractDao<Orders> {
    @Override
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
        long id = executeCreate(sql);
        if (id > 0)
            orders.setId(id);
        return id > 0;
    }

    @Override
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
        return executeUpdate(sql);

    }

    @Override
    public boolean delete(Orders orders) throws SQLException {
        String sql = String.format(Locale.ENGLISH, "DELETE FROM `orders` WHERE `id`=%d", orders.getId());
        return executeUpdate(sql);

    }

    @Override
    public Orders read(long id) throws SQLException {
        String where = String.format(" WHERE `id`='%d' LIMIT 0,1", id);
        List<Orders> orders = getAll(where);
        if (orders.size() == 1)
            return orders.get(0);
        else
            return null;
    }

    @Override
    public List<Orders> getAll() throws SQLException {
        return getAll("");
    }

    @Override
    public List<Orders> getAll(String where) throws SQLException {
        List<Orders> order = new ArrayList<>();
        String sql = String.format(Locale.ENGLISH,
                "SELECT * FROM `products` %s", where
        );

        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Orders orders = new Orders(
                        resultSet.getLong("id"),
                        resultSet.getInt("price"),
                        resultSet.getInt("quantity"),
                        resultSet.getString("address"),
                        resultSet.getInt("users_id"),
                        resultSet.getInt("products_id")
                );

                order.add(orders);
            }
        }
        return order;

    }

}
