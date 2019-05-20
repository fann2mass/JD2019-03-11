package by.it.khlystunova.jd03_01;

import java.sql.*;

public class B_ShowUsers {

//    static {
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//        } catch (Exception ex) {
//            // handle the error
//        }
//    }

    public static void main(String[] args) throws SQLException {
        try (Connection connection = DriverManager.getConnection
                                                (CN.URL,CN.USER,CN.PASSWORD);
             Statement statement = connection.createStatement()) {
           //получаем пользователей
            ResultSet resultSet = statement.executeQuery("select * from `khlystunova`.`users`;");
            while(resultSet.next()){
             String out = resultSet.getString("Login")+", "+resultSet.getString("roles_ID");
                System.out.println(out);
            }
        }
    }
}
