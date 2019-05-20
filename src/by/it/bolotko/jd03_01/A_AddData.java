package by.it.bolotko.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class A_AddData {
    private static final String URL="jdbc:mysql://127.0.0.1:2016/";
    private static final String USER="root";
    private static final String PASSWORD="";


    public static void main(String[] args) throws SQLException {
        try (
                Connection connection= DriverManager.getConnection(URL,USER,PASSWORD);
                Statement statement = connection.createStatement()
        ){
            statement.executeUpdate("INSERT INTO `TaskA`.`cars` (`id`, `car`, `users_id`) VALUES (DEFAULT, 'Audi', 1);\n");
            statement.executeUpdate("INSERT INTO `TaskA`.`cars` (`id`, `car`, `users_id`) VALUES (DEFAULT, 'BMW', 1);\n");
            statement.executeUpdate("INSERT INTO `TaskA`.`cars` (`id`, `car`, `users_id`) VALUES (DEFAULT, 'LADA', 1);\n");
            statement.executeUpdate("INSERT INTO `TaskA`.`information` (`id`, `model`, `colour`, `price`, `cars_id`) VALUES (DEFAULT, 'A5', 'red', '999', 1);\n");
            statement.executeUpdate("INSERT INTO `TaskA`.`information` (`id`, `model`, `colour`, `price`, `cars_id`) VALUES (DEFAULT, 'Q7', 'green', '9999', 2);\n");
            statement.executeUpdate("INSERT INTO `TaskA`.`information` (`id`, `model`, `colour`, `price`, `cars_id`) VALUES (DEFAULT, 'priora', 'black', '444', 3);\n");
        }
    }
}
