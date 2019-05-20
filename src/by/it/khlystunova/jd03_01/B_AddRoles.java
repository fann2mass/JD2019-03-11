package by.it.khlystunova.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class B_AddRoles {

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

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `khlystunova`.`roles` (\n" +
                    "  `ID` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `Role` VARCHAR(50) NULL,\n" +
                    "  PRIMARY KEY (`ID`))\n" +
                    "ENGINE = InnoDB;");

            statement.executeUpdate("INSERT INTO `khlystunova`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'Moderator');");
            statement.executeUpdate("INSERT INTO `khlystunova`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'Administrator2');");
            statement.executeUpdate("INSERT INTO `khlystunova`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'Guest3');");

        }
    }
}

