package by.it.narushevich.jd03_02.crud;

import by.it.narushevich.jd03_02.beans.Width_x_Height;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class Width_x_HeightCRUD {
    public boolean create(Width_x_Height width_x_height) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "INSERT INTO `width_x_height`(`width_x_height`) VALUES ('%s')",
                width_x_height.getWidth_x_height());
        try (Connection connection = ConnectionCreator.get();
             Statement statement = connection.createStatement()){
            int count = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (count == 1){
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()){
                    width_x_height.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    public Width_x_Height read(long id) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "SELECT `id`, `width_x_height` FROM `width_x_height` WHERE `id`=%d",id);
        try (Connection connection = ConnectionCreator.get();
             Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()){
                return new Width_x_Height(
                        resultSet.getLong("id"),
                        resultSet.getString("width_x_height"));
            }
        }
        return null;
    }

    public boolean update(Width_x_Height width_x_height) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "UPDATE `width_x_height` SET `width_x_height`='%s' WHERE `id`=%d",
                width_x_height.getWidth_x_height(), width_x_height.getId());
        try (Connection connection = ConnectionCreator.get();
             Statement statement = connection.createStatement()) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    public boolean delete(Width_x_Height width_x_height) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "DELETE FROM `width_x_height` WHERE `id`=%d", width_x_height.getId());
        try (Connection connection = ConnectionCreator.get();
             Statement statement = connection.createStatement()){
            return (1 == statement.executeUpdate(sql));
        }
    }
}
