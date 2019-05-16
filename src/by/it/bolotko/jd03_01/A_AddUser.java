package by.it.bolotko.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class A_AddUser {
    private static final String URL="jdbc:mysql://127.0.0.1:2016/";
    private static final String USER="root";
    private static final String PASSWORD="";


    public static void main(String[] args) throws SQLException {
        try (
                Connection connection= DriverManager.getConnection(URL,USER,PASSWORD);
                Statement statement = connection.createStatement()
        ){
            statement.executeUpdate("DROP SCHEMA IF EXISTS `TaskA` ;");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `TaskA` DEFAULT CHARACTER SET utf8 ;\n");
            statement.executeUpdate("DROP TABLE IF EXISTS `TaskA`.`users` ;\n");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `TaskA`.`users` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `user` VARCHAR(100) NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("DROP TABLE IF EXISTS `TaskA`.`cars` ;\n");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `TaskA`.`cars` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `car` VARCHAR(100) NULL,\n" +
                    "  `users_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  CONSTRAINT `fk_cars_users`\n" +
                    "    FOREIGN KEY (`users_id`)\n" +
                    "    REFERENCES `TaskA`.`users` (`id`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("DROP TABLE IF EXISTS `TaskA`.`information` ;\n");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `TaskA`.`information` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `model` VARCHAR(100) NULL,\n" +
                    "  `colour` VARCHAR(100) NULL,\n" +
                    "  `price` VARCHAR(100) NULL,\n" +
                    "  `cars_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  CONSTRAINT `fk_information_cars1`\n" +
                    "    FOREIGN KEY (`cars_id`)\n" +
                    "    REFERENCES `TaskA`.`cars` (`id`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("INSERT INTO `TaskA`.`users` (`id`, `user`) VALUES (DEFAULT, 'user_taskA');\n");
        }

    }
}
