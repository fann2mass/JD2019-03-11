package by.it.bildziuh.jd03_02;


import javax.xml.transform.Result;
import java.sql.*;

public class TaskB {

    private static final String URL = "jdbc:mysql://127.0.0.1:2016/bildziuh?";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        try (
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement statement = connection.createStatement()) {

            //получаем пользователей. Если неизвестно число полей, то нужно получить метаданные
            int countUsers = 0;
            int countRoles = 0;
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users INNER JOIN roles ON users.roles_ID=roles.ID");
            while (resultSet.next()) {
                ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                int columnCount = resultSetMetaData.getColumnCount();
                for (int i = 1; i < columnCount + 1; i++)
                    System.out.print(
                            resultSetMetaData.getColumnLabel(i) + "=" +
                                    resultSet.getString(i) + "\t\t"
                    );
                System.out.println();
                countUsers++;
            }
            ResultSet result = statement.executeQuery("SELECT * FROM roles");
            while (result.next()) {
                countRoles++;
            }
            System.out.println("Всего пользователей: " + countUsers);
            System.out.println("Всего возможных ролей: " + countRoles);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
