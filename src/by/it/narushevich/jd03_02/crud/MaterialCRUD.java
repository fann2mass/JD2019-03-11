package by.it.narushevich.jd03_02.crud;

import by.it.narushevich.jd03_02.beans.Material;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class MaterialCRUD {
    public boolean create(Material material) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "INSERT INTO `material`(`material`) VALUES ('%s')",
                material.getMaterial());
        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement()
        ) {
            int count = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            if (count == 1) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    material.setId(generatedKeys.getLong(1));
                    return true;
                }
            }
        }
        return false;
    }

    public Material read(long id) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "SELECT * FROM `material` WHERE `id`=%d", id);
        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                return new Material(
                        resultSet.getLong("id"),
                        resultSet.getString("material"));
            }
        }
        return null;
    }

    public boolean update(Material material) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "UPDATE `material` SET `material`='%s' WHERE `id`=%d",
                material.getMaterial(), material.getId());
        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement()
        ) {
            return (1 == statement.executeUpdate(sql));
        }
    }

    public boolean delete(Material material) throws SQLException {
        String sql = String.format(Locale.ENGLISH,
                "DELETE FROM `material` WHERE `id`=%d",
                material.getId());
        try (
                Connection connection = ConnectionCreator.get();
                Statement statement = connection.createStatement()
        ) {
            return (1 == statement.executeUpdate(sql));
        }
    }
}
