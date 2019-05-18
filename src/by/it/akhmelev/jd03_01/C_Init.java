package by.it.akhmelev.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class C_Init {

    private static final String URL="jdbc:mysql://127.0.0.1:2016/";
    private static final String USER="root";
    private static final String PASSWORD="";

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception ex) {
            // handle the error
        }
    }


    public static void main(String[] args) throws SQLException {
        try (
        Connection connection= DriverManager.getConnection(URL,USER,PASSWORD);
        Statement statement = connection.createStatement()
        ){
            statement.executeUpdate("DROP SCHEMA IF EXISTS `akhmelev`");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `akhmelev` DEFAULT CHARACTER SET utf8 ;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `akhmelev`.`roles` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `role` VARCHAR(100) NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB;\n");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `akhmelev`.`users` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `login` VARCHAR(100) NULL,\n" +
                    "  `password` VARCHAR(100) NULL,\n" +
                    "  `email` VARCHAR(100) NULL,\n" +
                    "  `roles_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  CONSTRAINT `fk_users_roles`\n" +
                    "    FOREIGN KEY (`roles_id`)\n" +
                    "    REFERENCES `akhmelev`.`roles` (`id`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB;\n");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `akhmelev`.`ads` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `description` VARCHAR(5000) NULL,\n" +
                    "  `address` VARCHAR(400) NULL,\n" +
                    "  `rooms` INT NULL,\n" +
                    "  `floor` INT NULL,\n" +
                    "  `floors` INT NULL,\n" +
                    "  `price` DOUBLE NULL,\n" +
                    "  `area` DOUBLE NULL,\n" +
                    "  `users_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  CONSTRAINT `fk_ads_users1`\n" +
                    "    FOREIGN KEY (`users_id`)\n" +
                    "    REFERENCES `akhmelev`.`users` (`id`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("INSERT INTO `akhmelev`.`roles` (`id`, `role`) VALUES (DEFAULT, 'admin');");
            statement.executeUpdate("INSERT INTO `akhmelev`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user');");
            statement.executeUpdate("INSERT INTO `akhmelev`.`roles` (`id`, `role`) VALUES (DEFAULT, 'moderator');");
            statement.executeUpdate("INSERT INTO `akhmelev`.`roles` (`id`, `role`) VALUES (DEFAULT, 'guest');");
            statement.executeUpdate("INSERT INTO `akhmelev`.`users` (`id`, `login`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'admin', 'qwerty', 'a@gmail.com', 1);\n");
            statement.executeUpdate("INSERT INTO `akhmelev`.`users` (`id`, `login`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'user', 'asdfgh', 'user@mail.ru', 2);\n");
            statement.executeUpdate("INSERT INTO `akhmelev`.`users` (`id`, `login`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'user2', 'zxcvbn', 'user2@ya.ru', 2);\n");
            statement.executeUpdate("INSERT INTO `akhmelev`.`ads` (`id`, `description`, `address`, `rooms`, `floor`, `floors`, `price`, `area`, `users_id`) VALUES (DEFAULT, 'good flat', 'Minsk Lenina 2 4', 2, 3, 6, 99999, 50, 2);\n");
            statement.executeUpdate("INSERT INTO `akhmelev`.`ads` (`id`, `description`, `address`, `rooms`, `floor`, `floors`, `price`, `area`, `users_id`) VALUES (DEFAULT, 'bad flat', 'Minsk Tractorny Zavod 55 99', 1, 1, 1, 44444, 33, 2);\n");
            statement.executeUpdate("INSERT INTO `akhmelev`.`ads` (`id`, `description`, `address`, `rooms`, `floor`, `floors`, `price`, `area`, `users_id`) VALUES (DEFAULT, 'just flat', 'Minsk Scryganova 14a', 1, 5, 6, 55555, 30, 3);\n");
        }

    }
}
