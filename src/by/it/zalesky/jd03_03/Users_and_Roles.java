package by.it.zalesky.jd03_03;


import by.it.zalesky.jd03_03.connection.ConnectionCreator;

import java.sql.*;

public class Users_and_Roles {

    public static void main(String[] args) throws SQLException {

 try (Connection connection = ConnectionCreator.get();
      Statement statement = connection.createStatement())
    {
        int countUsers = 0;
        int countRoles = 0;

        ResultSet resultSet = statement.executeQuery("SELECT login,roles.Role FROM users LEFT JOIN roles ON users.roles_ID=roles.ID");
        while(resultSet.next()){
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(
                        metaData.getColumnLabel(i) + "=" +
                                resultSet.getString(i) + "\t"
                );
                System.out.println();
            }
            countUsers++;
        }
        ResultSet result = statement.executeQuery("SELECT * FROM roles");
        while (result.next()) {
            countRoles++;
        }
        System.out.println("Кол-во пользователей: " + countUsers);
        System.out.println("Кол-во ролей: " + countRoles);
    }
}

}
