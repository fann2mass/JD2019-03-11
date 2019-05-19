package by.it.eslaikouskaya.jd03_02.crud;

import by.it.eslaikouskaya.jd03_02.beans.Material;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class MaterialCRUD {
	public boolean create(Material material) throws SQLException {
		String sql = String.format(Locale.ENGLISH,
				"INSERT INTO " +
						"`materials`(`Name`, `Price`, `classes_ID`) " +
						"VALUES ('%s','%d','%d')",
				material.getName(), material.getPrice(), material.getGradesId());

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
				"SELECT * FROM `materials` WHERE `id`=%d", id
		);

		try (
				Connection connection = ConnectionCreator.get();
				Statement statement = connection.createStatement()
		) {
			ResultSet resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {

				return new Material(
						resultSet.getLong("ID"),
						resultSet.getString("Name"),
						resultSet.getInt("Price"),
						resultSet.getLong("classes_ID")
				);
			}
		}
		return null;
	}

	public boolean update(Material material) throws SQLException {
		String sql = String.format(Locale.ENGLISH,
				"UPDATE `materials` " +
						"SET `Name`='%s',`Price`='%d'," +
						"`classes_ID`='%d' WHERE `id`=%d",
				material.getName(), material.getPrice(), material.getGradesId(), material.getId()
		);

		try (
				Connection connection = ConnectionCreator.get();
				Statement statement = connection.createStatement()
		) {
			return (1 == statement.executeUpdate(sql));
		}
	}

	public boolean delete(Material material) throws SQLException {
		String sql = String.format(Locale.ENGLISH, "DELETE FROM `materials` WHERE `id`=%d", material.getId());
		try (
				Connection connection = ConnectionCreator.get();
				Statement statement = connection.createStatement()
		) {
			return (1 == statement.executeUpdate(sql));
		}
	}
}
