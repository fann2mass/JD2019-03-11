package by.it.bildziuh.jd03_01;

import java.sql.*;

public class B_ShowUsers {

    private static final String URL = "jdbc:mysql://127.0.0.1:2016/";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        try (
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery("select * from `bildziuh`.`users`;");
            while (resultSet.next()) {
                String out = resultSet.getString("Email") + ", " + resultSet.getString("Login");
                System.out.println(out);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}