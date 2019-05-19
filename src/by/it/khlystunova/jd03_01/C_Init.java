package by.it.khlystunova.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class C_Init {

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

            statement.executeUpdate("DROP SCHEMA IF EXISTS `khlystunova`");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `khlystunova` DEFAULT CHARACTER SET utf8 ;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `khlystunova`.`roles` (\n" +
                    "  `ID` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `Role` VARCHAR(50) NULL,\n" +
                    "  PRIMARY KEY (`ID`))\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `khlystunova`.`users` (\n" +
                    "  `ID` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `Login` VARCHAR(45) NULL,\n" +
                    "  `Password` VARCHAR(45) NULL,\n" +
                    "  `Email` VARCHAR(45) NULL,\n" +
                    "  `roles_ID` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`ID`),\n" +
                    "  CONSTRAINT `fk_users_roles`\n" +
                    "    FOREIGN KEY (`roles_ID`)\n" +
                    "    REFERENCES `khlystunova`.`roles` (`ID`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `khlystunova`.`firm` (\n" +
                    "  `ID` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `firm` VARCHAR(45) NULL,\n" +
                    "  PRIMARY KEY (`ID`))\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `khlystunova`.`steam` (\n" +
                    "  `ID` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `Steam` VARCHAR(45) NULL,\n" +
                    "  PRIMARY KEY (`ID`))\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `khlystunova`.`coffemachines` (\n" +
                    "  `ID` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `Name` VARCHAR(50) NULL,\n" +
                    "  `firm_ID` INT NOT NULL,\n" +
                    "  `Power` INT NULL,\n" +
                    "  `Size` VARCHAR(50) NULL,\n" +
                    "  `Weight` DOUBLE NULL,\n" +
                    "  `steam_ID` INT NOT NULL,\n" +
                    "  `WaterContainer` VARCHAR(45) NULL,\n" +
                    "  `BeansContainer` VARCHAR(45) NULL,\n" +
                    "  `Color` VARCHAR(45) NULL,\n" +
                    "  `Price` DOUBLE NULL,\n" +
                    "  PRIMARY KEY (`ID`),\n" +
                    "  CONSTRAINT `fk_coffemachines_firm1`\n" +
                    "    FOREIGN KEY (`firm_ID`)\n" +
                    "    REFERENCES `khlystunova`.`firm` (`ID`)\n" +
                    "    ON DELETE NO ACTION\n" +
                    "    ON UPDATE NO ACTION,\n" +
                    "  CONSTRAINT `fk_coffemachines_steam1`\n" +
                    "    FOREIGN KEY (`steam_ID`)\n" +
                    "    REFERENCES `khlystunova`.`steam` (`ID`)\n" +
                    "    ON DELETE NO ACTION\n" +
                    "    ON UPDATE NO ACTION)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `khlystunova`.`requests` (\n" +
                    "  `ID` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `users_ID` INT NOT NULL,\n" +
                    "  `Contact` VARCHAR(45) NULL,\n" +
                    "  `DeliveryAddress` VARCHAR(50) NULL,\n" +
                    "  `coffemachines_ID` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`ID`),\n" +
                    "  CONSTRAINT `fk_requests_users1`\n" +
                    "    FOREIGN KEY (`users_ID`)\n" +
                    "    REFERENCES `khlystunova`.`users` (`ID`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE,\n" +
                    "  CONSTRAINT `fk_requests_coffemachines1`\n" +
                    "    FOREIGN KEY (`coffemachines_ID`)\n" +
                    "    REFERENCES `khlystunova`.`coffemachines` (`ID`)\n" +
                    "    ON DELETE NO ACTION\n" +
                    "    ON UPDATE NO ACTION)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("INSERT INTO `khlystunova`.`roles` (`ID`, `Role`) VALUES (1, 'Administrator');\n");
            statement.executeUpdate("INSERT INTO `khlystunova`.`roles` (`ID`, `Role`) VALUES (2, 'User');\n");
            statement.executeUpdate("INSERT INTO `khlystunova`.`roles` (`ID`, `Role`) VALUES (3, 'Guest');\n");
            statement.executeUpdate("INSERT INTO `khlystunova`.`users` (`ID`, `Login`, `Password`, `Email`, `roles_ID`) VALUES (DEFAULT, 'admin', 'padmin', 'admin@gmail.com', 1);\n");
            statement.executeUpdate("INSERT INTO `khlystunova`.`users` (`ID`, `Login`, `Password`, `Email`, `roles_ID`) VALUES (DEFAULT, 'Petrov', 'puser', 'user@gmail.com', 2);\n");
            statement.executeUpdate("INSERT INTO `khlystunova`.`users` (`ID`, `Login`, `Password`, `Email`, `roles_ID`) VALUES (DEFAULT, 'Sidorov', 'psidorov', 'sidorov@mail.ru', 2);\n");
            statement.executeUpdate("INSERT INTO `khlystunova`.`firm` (`ID`, `firm`) VALUES (DEFAULT, 'Gagia');\n");
            statement.executeUpdate("INSERT INTO `khlystunova`.`firm` (`ID`, `firm`) VALUES (DEFAULT, 'Italic');\n");
            statement.executeUpdate("INSERT INTO `khlystunova`.`steam` (`ID`, `Steam`) VALUES (DEFAULT, 'automatic');\n");
            statement.executeUpdate("INSERT INTO `khlystunova`.`steam` (`ID`, `Steam`) VALUES (DEFAULT, 'autonomy');\n");
            statement.executeUpdate("INSERT INTO `khlystunova`.`steam` (`ID`, `Steam`) VALUES (DEFAULT, 'panarello');\n");
            statement.executeUpdate("INSERT INTO `khlystunova`.`coffemachines` (`ID`, `Name`, `firm_ID`, `Power`, `Size`, `Weight`, `steam_ID`, `WaterContainer`, `BeansContainer`, `Color`, `Price`) VALUES (DEFAULT, 'LC/D', 1, 1600, '625x472x510 ', 49.3, 1, '13 l', '7 l', 'Metalic', 5650);\n");
            statement.executeUpdate("INSERT INTO `khlystunova`.`coffemachines` (`ID`, `Name`, `firm_ID`, `Power`, `Size`, `Weight`, `steam_ID`, `WaterContainer`, `BeansContainer`, `Color`, `Price`) VALUES (DEFAULT, 'GE-GD ONE', 2, 1200, '530x550x420 ', 30.4, 2, '2,3 l', '2 l', 'Red', 4620);\n");
            statement.executeUpdate("INSERT INTO `khlystunova`.`requests` (`ID`, `users_ID`, `Contact`, `DeliveryAddress`, `coffemachines_ID`) VALUES (DEFAULT, 2, '+375293455837', 'Frolova27f3', 1);\n");
            statement.executeUpdate("INSERT INTO `khlystunova`.`requests` (`ID`, `users_ID`, `Contact`, `DeliveryAddress`, `coffemachines_ID`) VALUES (DEFAULT, 3, '+375296256313', 'Pr.Mira27b12', 2);\n");

        }
    }
}
