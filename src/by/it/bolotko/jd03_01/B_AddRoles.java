package by.it.bolotko.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class B_AddRoles {
    private static final String URL = "jdbc:mysql://127.0.0.1:2016/";
    private static final String USER = "root";
    private static final String PASSWORD = "";


    public static void main(String[] args) throws SQLException {
        try (
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement statement = connection.createStatement()
        ) {
            statement.executeUpdate("DROP SCHEMA IF EXISTS `TaskA` ;");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `TaskA` DEFAULT CHARACTER SET utf8 ;");
            statement.executeUpdate("DROP TABLE IF EXISTS `TaskA`.`roles` ;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `TaskA`.`roles` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `role` VARCHAR(100) NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("DROP TABLE IF EXISTS `TaskA`.`users` ;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `TaskA`.`users` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `user` VARCHAR(100) NULL,\n" +
                    "  `roles_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  CONSTRAINT `fk_users_roles1`\n" +
                    "    FOREIGN KEY (`roles_id`)\n" +
                    "    REFERENCES `TaskA`.`roles` (`id`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("DROP TABLE IF EXISTS `TaskA`.`cars` ;");
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
            statement.executeUpdate("DROP TABLE IF EXISTS `TaskA`.`information` ;");
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
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("INSERT INTO `TaskA`.`roles` (`id`, `role`) VALUES (DEFAULT, 'administrator');\n");
            statement.executeUpdate("INSERT INTO `TaskA`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user');\n");
            statement.executeUpdate("INSERT INTO `TaskA`.`roles` (`id`, `role`) VALUES (DEFAULT, 'worker');\n");
            statement.executeUpdate("INSERT INTO `TaskA`.`roles` (`id`, `role`) VALUES (DEFAULT, 'director');\n");
            statement.executeUpdate("INSERT INTO `TaskA`.`roles` (`id`, `role`) VALUES (DEFAULT, 'brigadir');\n");
            statement.executeUpdate("INSERT INTO `TaskA`.`users` (`id`, `user`, `roles_id`) VALUES (DEFAULT, 'user1', 1);\n");
            statement.executeUpdate("INSERT INTO `TaskA`.`users` (`id`, `user`, `roles_id`) VALUES (DEFAULT, 'user2', 2);\n");
            statement.executeUpdate("INSERT INTO `TaskA`.`users` (`id`, `user`, `roles_id`) VALUES (DEFAULT, 'user3', 3);\n");
            statement.executeUpdate("INSERT INTO `TaskA`.`users` (`id`, `user`, `roles_id`) VALUES (DEFAULT, 'user4', 4);\n");
            statement.executeUpdate("INSERT INTO `TaskA`.`users` (`id`, `user`, `roles_id`) VALUES (DEFAULT, 'user5', 5);\n");
            statement.executeUpdate("INSERT INTO `TaskA`.`cars` (`id`, `car`, `users_id`) VALUES (DEFAULT, 'Audi', 1);\n");
            statement.executeUpdate("INSERT INTO `TaskA`.`cars` (`id`, `car`, `users_id`) VALUES (DEFAULT, 'BMW', 2);\n");
            statement.executeUpdate("INSERT INTO `TaskA`.`cars` (`id`, `car`, `users_id`) VALUES (DEFAULT, 'LADA', 3);\n");
            statement.executeUpdate("INSERT INTO `TaskA`.`information` (`id`, `model`, `colour`, `price`, `cars_id`) VALUES (DEFAULT, 'A5', 'red', '999', 1);\n");
            statement.executeUpdate("INSERT INTO `TaskA`.`information` (`id`, `model`, `colour`, `price`, `cars_id`) VALUES (DEFAULT, 'Q7', 'green', '9999', 2);\n");
            statement.executeUpdate("INSERT INTO `TaskA`.`information` (`id`, `model`, `colour`, `price`, `cars_id`) VALUES (DEFAULT, 'priora', 'black', '444', 3);\n");
            //statement.executeUpdate("");
        }
    }
}
