package by.it.eslaikouskaya.jd03_02.crud;

import by.it.eslaikouskaya.jd03_02.beans.Grade;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

public class GradeCRUD {
	public boolean create(Grade grade) throws SQLException {
		String sql = String.format(Locale.ENGLISH,
				"INSERT INTO " +
						"`classes`(`Class`, `categories_ID`) " +
						"VALUES ('%s','%d')",
				grade.getGrade(), grade.getCategoriesId());
		try (
				Connection connection = ConnectionCreator.get();
				Statement statement = connection.createStatement()
		) {
			int count = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
			if (count == 1) {
				ResultSet generatedKeys = statement.getGeneratedKeys();
				if (generatedKeys.next()) {
					grade.setId(generatedKeys.getLong(1));
					return true;
				}
			}
		}
		return false;
	}

	public Grade read(long id) throws SQLException {
		String sql = String.format(Locale.ENGLISH,
				"SELECT * FROM `materials` WHERE `id`=%d", id
		);

		try (
				Connection connection = ConnectionCreator.get();
				Statement statement = connection.createStatement()
		) {
			ResultSet resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {

				return new Grade(
						resultSet.getLong("ID"),
						resultSet.getString("Class"),
						resultSet.getLong("categories_ID")
				);
			}
		}
		return null;
	}

	public boolean update(Grade grade) throws SQLException {
		String sql = String.format(Locale.ENGLISH,
				"UPDATE `grades` " +
						"SET `Class`='%s',`categories_ID`='%d' " +
						"WHERE `id`=%d",
				grade.getGrade(), grade.getCategoriesId(), grade.getId()
		);

		try (
				Connection connection = ConnectionCreator.get();
				Statement statement = connection.createStatement()
		) {
			return (1 == statement.executeUpdate(sql));
		}
	}

	public boolean delete(Grade grade) throws SQLException {
		String sql = String.format(Locale.ENGLISH, "DELETE FROM `grades` WHERE `id`=%d", grade.getId());
		try (
				Connection connection = ConnectionCreator.get();
				Statement statement = connection.createStatement()
		) {
			return (1 == statement.executeUpdate(sql));
		}
	}
}
