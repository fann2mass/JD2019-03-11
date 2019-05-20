package by.it.bolotko.jd03_02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class C_Init {

    private static final String URL="jdbc:mysql://127.0.0.1:2016/";
    private static final String USER="root";
    private static final String PASSWORD="";


    public static void main(String[] args) throws SQLException {
        try (
        Connection connection= DriverManager.getConnection(URL,USER,PASSWORD);
        Statement statement = connection.createStatement()
        ){
            statement.executeUpdate("DROP SCHEMA IF EXISTS `bolotko` ;\n");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `bolotko` DEFAULT CHARACTER SET utf8 ;\n");
            statement.executeUpdate("DROP TABLE IF EXISTS `bolotko`.`roles` ;\n");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `bolotko`.`roles` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `role` VARCHAR(100) NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("DROP TABLE IF EXISTS `bolotko`.`users` ;\n");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `bolotko`.`users` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `login` VARCHAR(100) NULL,\n" +
                    "  `password` VARCHAR(100) NULL,\n" +
                    "  `email` VARCHAR(100) NULL,\n" +
                    "  `phone` VARCHAR(20) NULL,\n" +
                    "  `roles_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  CONSTRAINT `fk_users_roles`\n" +
                    "    FOREIGN KEY (`roles_id`)\n" +
                    "    REFERENCES `bolotko`.`roles` (`id`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("DROP TABLE IF EXISTS `bolotko`.`cars` ;\n");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `bolotko`.`cars` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `car_type` VARCHAR(100) NULL,\n" +
                    "  `mark` VARCHAR(100) NULL,\n" +
                    "  `model` VARCHAR(100) NULL,\n" +
                    "  `year_of_issue` VARCHAR(100) NULL,\n" +
                    "  `fuel_type` VARCHAR(100) NULL,\n" +
                    "  `price` DOUBLE NULL,\n" +
                    "  `users_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  CONSTRAINT `fk_cars_users1`\n" +
                    "    FOREIGN KEY (`users_id`)\n" +
                    "    REFERENCES `bolotko`.`users` (`id`)\n" +
                    "    ON DELETE CASCADE\n" +
                    "    ON UPDATE CASCADE)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("INSERT INTO `bolotko`.`roles` (`id`, `role`) VALUES (DEFAULT, 'admin');\n");
            statement.executeUpdate("INSERT INTO `bolotko`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user');\n");
            statement.executeUpdate("INSERT INTO `bolotko`.`roles` (`id`, `role`) VALUES (DEFAULT, 'moderator');\n");
            statement.executeUpdate("INSERT INTO `bolotko`.`roles` (`id`, `role`) VALUES (DEFAULT, 'guest');\n");
            statement.executeUpdate("INSERT INTO `bolotko`.`users` (`id`, `login`, `password`, `email`, `phone`, `roles_id`) VALUES (DEFAULT, 'administrator', 'qwerty', 'kostja100pro@gmail.com', '+375(29)7326543', 1);\n");
            statement.executeUpdate("INSERT INTO `bolotko`.`users` (`id`, `login`, `password`, `email`, `phone`, `roles_id`) VALUES (DEFAULT, 'nikolaj', 'jalokin', 'nikolajab@mail.ru', '+375(33)5897326', 2);\n");
            statement.executeUpdate("INSERT INTO `bolotko`.`users` (`id`, `login`, `password`, `email`, `phone`, `roles_id`) VALUES (DEFAULT, 'dinis', 'sinid', 'dinis228@gmail.com', '+375(44)2417438', 2);\n");
            statement.executeUpdate("INSERT INTO `bolotko`.`users` (`id`, `login`, `password`, `email`, `phone`, `roles_id`) VALUES (DEFAULT, 'moderator1', 'rotaredom1', 'moderator1@gmail.com', '+375(29)7634920', 3);\n");
            statement.executeUpdate("INSERT INTO `bolotko`.`users` (`id`, `login`, `password`, `email`, `phone`, `roles_id`) VALUES (DEFAULT, 'moderator2', 'rotaredom2', 'moderator2@gmail.com', '+375(29)7634921', 3);\n");
            statement.executeUpdate("INSERT INTO `bolotko`.`users` (`id`, `login`, `password`, `email`, `phone`, `roles_id`) VALUES (DEFAULT, 'user1', '0000', 'test1@yandex.ru', '+375(29)7634900', 4);\n");
            statement.executeUpdate("INSERT INTO `bolotko`.`users` (`id`, `login`, `password`, `email`, `phone`, `roles_id`) VALUES (DEFAULT, 'user2', '0000', 'test2@yandex.ru', '+375(29)7634900', 4);\n");
            statement.executeUpdate("INSERT INTO `bolotko`.`users` (`id`, `login`, `password`, `email`, `phone`, `roles_id`) VALUES (DEFAULT, 'maksim', 'miskam', 'maksim1997@mail.ru', '+375(33)5356226', 2);\n");
            statement.executeUpdate("INSERT INTO `bolotko`.`cars` (`id`, `car_type`, `mark`, `model`, `year_of_issue`, `fuel_type`, `price`, `users_id`) VALUES (DEFAULT, 'passenger', 'Audi', 'A4', '1998', 'gasoline', 4395, 2);\n");
            statement.executeUpdate("INSERT INTO `bolotko`.`cars` (`id`, `car_type`, `mark`, `model`, `year_of_issue`, `fuel_type`, `price`, `users_id`) VALUES (DEFAULT, 'passenger', 'BMW', 'M5', '2008', 'gasoline', 26470, 2);\n");
            statement.executeUpdate("INSERT INTO `bolotko`.`cars` (`id`, `car_type`, `mark`, `model`, `year_of_issue`, `fuel_type`, `price`, `users_id`) VALUES (DEFAULT, 'truck', 'Avia', 'A21', '1987', 'diesel', 799, 3);\n");
            statement.executeUpdate("INSERT INTO `bolotko`.`cars` (`id`, `car_type`, `mark`, `model`, `year_of_issue`, `fuel_type`, `price`, `users_id`) VALUES (DEFAULT, 'passenger', 'Dacia', 'Logan', '2008', 'gasoline', 3602, 8);\n");
            statement.executeUpdate("INSERT INTO `bolotko`.`cars` (`id`, `car_type`, `mark`, `model`, `year_of_issue`, `fuel_type`, `price`, `users_id`) VALUES (DEFAULT, 'truck', 'KIA', 'K2500', '2015', 'diesel', 13636, 8);\n");
        }

    }
}
