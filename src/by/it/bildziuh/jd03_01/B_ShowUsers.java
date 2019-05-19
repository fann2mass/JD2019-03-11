package by.it.bildziuh.jd03_01;

import java.sql.*;

public class B_ShowUsers {

    private static final String URL = "jdbc:mysql://127.0.0.1:2016/bildziuh?";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        try (
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery("select * from users;");
            while (resultSet.next()) {
                String role = "";
                switch (Integer.parseInt(resultSet.getString("roles_id"))) {
                    case 1:
                        role = "administrator";
                        break;
                    case 2:
                        role = "moderator";
                        break;
                    case 3:
                        role = "user";
                        break;
                    case 4:
                        role = "guest";
                        break;
                }
                String out = resultSet.getString("Login") + ", " + role;
                System.out.println(out);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}