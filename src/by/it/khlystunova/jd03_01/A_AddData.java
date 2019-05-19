package by.it.khlystunova.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class A_AddData {


//    static {
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//        } catch (Exception ex) {
//            // handle the error
//        }
//    }


    public static void main(String[] args) throws SQLException {
        try (Connection connection= DriverManager.getConnection(CN.URL,CN.USER,CN.PASSWORD);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("INSERT INTO `khlystunova`.`requests` (`ID`, `users_ID`, `Contact`, `DeliveryAddress`, `coffemachines_ID`) VALUES (DEFAULT, 2, '+37529555555', 'Stiapianka 23/12', 1);\n");
            statement.executeUpdate("INSERT INTO `khlystunova`.`requests` (`ID`, `users_ID`, `Contact`, `DeliveryAddress`, `coffemachines_ID`) VALUES (DEFAULT, 2, '+37529555555', 'Stiapianka 23/12', 2);\n");
            statement.executeUpdate("INSERT INTO `khlystunova`.`requests` (`ID`, `users_ID`, `Contact`, `DeliveryAddress`, `coffemachines_ID`) VALUES (DEFAULT, 2, '+37529555555', 'Stiapianka 23/12', 2);\n");

        }
    }
}
