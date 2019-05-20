package by.it.akhmelev.jd03_03.crud;

import by.it.akhmelev.jd03_03.beans.Ad;
import by.it.akhmelev.jd03_03.connect.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class AdCRUD {

    public boolean create(Ad ad) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "INSERT INTO `ads`(" +
                        "`description`, `address`, " +
                        "`rooms`, `floor`, `floors`, " +
                        "`price`, `area`, `users_id`) " +
                        "VALUES ('%s','%s'," +
                        "%d,%d,%d," +
                        "%f,%f,%d)",
                ad.getDescription(), ad.getAddress(),
                ad.getRooms(), ad.getFloor(), ad.getFloors(),
                ad.getArea(), ad.getPrice(), ad.getUsers_id()
        );

        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement();
        ) {
            int count = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (count == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    ad.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    public Ad read(long id) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "SELECT * FROM `ads` WHERE `id`=%d", id
        );

        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement();
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                Ad ad = new Ad(
                        resultSet.getLong("id"),
                        resultSet.getString("description"),
                        resultSet.getString("address"),
                        resultSet.getInt("rooms"),
                        resultSet.getInt("floor"),
                        resultSet.getInt("floors"),
                        resultSet.getDouble("area"),
                        resultSet.getInt("price"),
                        resultSet.getLong("users_id")
                );

                return ad;
            }
        }
        return null;
    }


    public boolean update(Ad ad) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "UPDATE `ads` SET " +
                        "`description`='%s',`address`='%s'," +
                        "`rooms`=%d,`floor`=%d,`floors`=%d," +
                        "`price`=%f,`area`=%f," +
                        "`users_id`=%d WHERE id=%d",
                ad.getDescription(), ad.getAddress(),
                ad.getRooms(), ad.getFloor(), ad.getFloors(),
                ad.getArea(), ad.getPrice(),
                ad.getUsers_id(), ad.getId()
                );

        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement();
        ) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    public boolean delete(Ad ad) throws SQLException {
        String sql = String.format(Locale.ENGLISH, "DELETE FROM `ads` WHERE `id`=%d", ad.getId());
        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement();
        ) {
            return (1 == statement.executeUpdate(sql));
        }
    }

}
