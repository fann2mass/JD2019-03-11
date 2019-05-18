package by.it.bolotko.jd03_01;

import java.sql.*;

public class B_ShowUsers {
    private static final String URL = "jdbc:mysql://127.0.0.1:2016/TaskA?";
    private static final String USER = "root";
    private static final String PASSWORD = "";


    public static void main(String[] args) throws SQLException {
        try (
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery("select * from users;");
            while (resultSet.next()){
                String out = resultSet.getString("user")+", "+resultSet.getString("roles_id");
                System.out.println(out);
            }
        }
    }
}
