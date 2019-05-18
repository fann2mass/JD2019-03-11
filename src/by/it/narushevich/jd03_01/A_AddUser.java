package by.it.narushevich.jd03_01;

import java.sql.*;

public class A_AddUser {

    public static void createUsers(Statement statement) throws SQLException {

        statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `narushevich_a` DEFAULT CHARACTER SET utf8 ;");
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS `narushevich_a`.`users` (\n" +
                "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                "  `trademark` VARCHAR(45) NULL,\n" +
                "  `subtitle` VARCHAR(45) NULL,\n" +
                "  `country` VARCHAR(25) NULL,\n" +
                "  `material` VARCHAR(10) NULL,\n" +
                "  `width_x_height` VARCHAR(10) NULL,\n" +
                "  `in_collection_since` YEAR(4) NULL,\n" +
                "  `fk_users` int(11) NULL,\n" +
                "  PRIMARY KEY (`id`))\n" +
                "ENGINE = InnoDB;");
        statement.executeUpdate("insert into users(id, login, password, email, roles_id)" +
                    "values (default,'masha_05','qwerty','masha_05@tut.by', 1, 1, 1)");
            statement.executeUpdate("insert into users(id, login, password, email, roles_id, country_id, city_id)" +
                    "values (default, 'fr_pole','asdfgh','pol_zhan@gmail.com', 2, 4, 4)");
            statement.executeUpdate("insert into users(id, login, password, email, roles_id, country_id, city_id)" +
                    "values (default, 'dimon_rus','wasder','dimas@mail.ru', 2, 2, 2)");

    }
}
