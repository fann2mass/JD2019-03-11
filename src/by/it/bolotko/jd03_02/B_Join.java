package by.it.bolotko.jd03_02;

import by.it.bolotko.jd03_02.crud.ConnectionCreator;

import java.sql.*;

public class B_Join {
    public static void main(String[] args) throws SQLException {
        try (Connection connection = ConnectionCreator.get();
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery("SELECT * FROM users INNER JOIN roles ON users.roles_id=roles.id");
            while (resultSet.next()) {
                ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                int columnCount = resultSetMetaData.getColumnCount();
                for (int i = 1; i < columnCount + 1; i++) {
                    System.out.println(
                            resultSetMetaData.getColumnLabel(i) + "=" +
                                    resultSet.getString(i) + "\t"
                    );
                }
                System.out.println();
            }
            resultSet=statement.executeQuery("SELECT COUNT(*) FROM users INNER JOIN roles ON users.roles_id=roles.id");
            if (resultSet.next()){
                System.out.println("Всего записей: "+resultSet.getInt(1));
            }
        }
    }
}
