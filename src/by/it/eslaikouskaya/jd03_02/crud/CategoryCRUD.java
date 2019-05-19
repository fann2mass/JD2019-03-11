package by.it.eslaikouskaya.jd03_02.crud;

import by.it.eslaikouskaya.jd03_02.beans.Category;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class CategoryCRUD {
	public boolean create(Category category) throws SQLException {
		String sql = String.format(Locale.ENGLISH,
				"INSERT INTO " +
						"`categories`(`Category`) " +
						"VALUES ('%s')",
				category.getCategory()
		);

		try (
				Connection connection = ConnectionCreator.get();
				Statement statement = connection.createStatement()
		) {
			int count = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
			if (count == 1) {
				ResultSet generatedKeys = statement.getGeneratedKeys();
				if (generatedKeys.next()) {
					category.setId(generatedKeys.getLong(1));
					return true;
				}
			}
		}
		return false;
	}

	public Category read(long id) throws SQLException {
		String sql = String.format(Locale.ENGLISH,
				"SELECT * FROM `categories` WHERE `id`=%d", id
		);

		try (
				Connection connection = ConnectionCreator.get();
				Statement statement = connection.createStatement()
		) {
			ResultSet resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
				return new Category(
						resultSet.getLong("ID"),
						resultSet.getString("Category")
				);
			}
		}
		return null;
	}

	public boolean update(Category category) throws SQLException {
		String sql = String.format(Locale.ENGLISH,
				"UPDATE `categories` " +
						"SET `Category`='%s' WHERE `id`=%d",
				category.getCategory(), category.getId()
		);

		try (
				Connection connection = ConnectionCreator.get();
				Statement statement = connection.createStatement()
		) {
			return (1 == statement.executeUpdate(sql));
		}
	}

	public boolean delete(Category category) throws SQLException {
		String sql = String.format(Locale.ENGLISH, "DELETE FROM `categories` WHERE `id`=%d", category.getId());
		try (
				Connection connection = ConnectionCreator.get();
				Statement statement = connection.createStatement()
		) {
			return (1 == statement.executeUpdate(sql));
		}
	}
}
