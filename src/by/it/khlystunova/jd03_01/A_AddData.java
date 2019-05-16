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
            statement.executeUpdate("INSERT INTO `khlystunova`.`requests` (`ID`, `Contact`, `DeliveryAdress`, `DeliveryMethod`, `MethodPayment`, `users_ID`, `coffemachines_ID`) VALUES (DEFAULT, '+3752945980123', 'Stiapianka 34/12', 'pickup', 'cash', 4, 1);\n");
            statement.executeUpdate("INSERT INTO `khlystunova`.`requests` (`ID`, `Contact`, `DeliveryAdress`, `DeliveryMethod`, `MethodPayment`, `users_ID`, `coffemachines_ID`) VALUES (DEFAULT, '+3752945980123', 'Stiapianka 34/12', 'courier', 'card',4, 2);\n");
            statement.executeUpdate("INSERT INTO `khlystunova`.`requests` (`ID`, `Contact`, `DeliveryAdress`, `DeliveryMethod`, `MethodPayment`, `users_ID`, `coffemachines_ID`) VALUES (DEFAULT, '+3752945980123', 'Stiapianka 34/12', 'courier', 'card', 4, 1);\n");
        }
    }
}
