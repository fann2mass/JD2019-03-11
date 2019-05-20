package by.it.narushevich.jd03_01;

import java.sql.SQLException;
import java.sql.Statement;

public class A_Init {

    public static void createSchema(Statement statement) throws SQLException {

        statement.executeUpdate("DROP SCHEMA IF EXISTS `narushevich_ab` ;");
        statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `narushevich_ab` DEFAULT CHARACTER SET utf8 ;");
        statement.executeUpdate(
                "CREATE TABLE IF NOT EXISTS `narushevich_ab`.`roles` (\n" +
                        "  `id` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                        "  `role` VARCHAR(45) NULL DEFAULT NULL,\n" +
                        "  PRIMARY KEY (`ID`))\n" +
                        "ENGINE = InnoDB\n"
        );
        statement.executeUpdate(
                "CREATE TABLE IF NOT EXISTS `narushevich_ab`.`users` (\n" +
                        "  `id` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                        "  `nickname` VARCHAR(45) NULL DEFAULT NULL,\n" +
                        "  `login` VARCHAR(45) NULL DEFAULT NULL,\n" +
                        "  `password` VARCHAR(45) NULL DEFAULT NULL,\n" +
                        "  `email` VARCHAR(45) NULL DEFAULT NULL,\n" +
                        "  `fk_roles` INT(11) NOT NULL,\n" +
                        "  PRIMARY KEY (`id`),\n" +
                        "  CONSTRAINT `fk_users_roles`\n" +
                        "    FOREIGN KEY (`fk_roles`)\n" +
                        "    REFERENCES `narushevich_ab`.`roles` (`id`))\n" +
                        "ENGINE = InnoDB\n"
        );
        statement.executeUpdate(
                "CREATE TABLE IF NOT EXISTS `narushevich_ab`.`teatags` (\n" +
                        "  `id` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                        "  `trademark` VARCHAR(45) NULL DEFAULT NULL,\n" +
                        "  `subtitle` VARCHAR(45) NULL DEFAULT NULL,\n" +
                        "  `material` VARCHAR(10) NULL DEFAULT NULL,\n" +
                        "  `width_x_height` VARCHAR(10) NULL DEFAULT NULL,\n" +
                        "  `in_collection_since` VARCHAR(10) NULL DEFAULT NULL,\n" +
                        "  `num_in_catalog` VARCHAR(10) NULL DEFAULT NULL,\n" +
                        "  `fk_users` INT(11) NOT NULL,\n" +
                        "  PRIMARY KEY (`id`),\n" +
                        "  CONSTRAINT `fk_teatags_users1`\n" +
                        "    FOREIGN KEY (`fk_users`)\n" +
                        "    REFERENCES `narushevich_ab`.`users` (`id`)\n" +
                        "    ON DELETE CASCADE\n" +
                        "    ON UPDATE CASCADE)\n" +
                        "ENGINE = InnoDB\n" +
                        "AUTO_INCREMENT = 1\n" +
                        "DEFAULT CHARACTER SET = utf8;\n"
        );
    }
}
