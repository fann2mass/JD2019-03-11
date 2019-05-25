package by.it.zalesky.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class B_ShowUsers {

    public static void main(String[] args) {

        try (Connection connection= DriverManager.getConnection
                (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement= connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery("SELECT * FROM USERS;");

            while (resultSet.next()) {
                String out = resultSet.getString("login") + ", " + resultSet.getString("roles_id");
                System.out.println(out);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
