package by.it.narushevich.jd03_02.crud;

import by.it.narushevich.jd03_02.beans.Trademark;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class TrademarkCRUD {

    public boolean create(Trademark trademark) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "INSERT INTO `trademark`(`trademark`) VALUES ('%s')",
                trademark.getTrademark());
        try (Connection connection = ConnectionCreator.get();
             Statement statement = connection.createStatement()){
            int count = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (count == 1){
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()){
                    trademark.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    public Trademark read(long id) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "SELECT `id`, `trademark` FROM `trademark` WHERE `id`=%d",id);
        try (Connection connection = ConnectionCreator.get();
             Statement statement = connection.createStatement()){
             ResultSet resultSet = statement.executeQuery(sql);
             if (resultSet.next()){
                 return new Trademark(
                         resultSet.getLong("id"),
                         resultSet.getString("trademark"));
             }
        }
        return null;
    }

    public boolean update(Trademark trademark) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "UPDATE `trademark` SET `trademark`='%s' WHERE `id`=%d",
                trademark.getTrademark(), trademark.getId());
        try (Connection connection = ConnectionCreator.get();
             Statement statement = connection.createStatement()) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    public boolean delete(Trademark trademark) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "DELETE FROM `trademark` WHERE `id`=%d", trademark.getId());
        try (Connection connection = ConnectionCreator.get();
             Statement statement = connection.createStatement()){
            return (1 == statement.executeUpdate(sql));
        }
    }
}
