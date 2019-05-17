package by.it.narushevich.jd03_01;

import java.sql.*;

public class C_init {

    public static void createFullDataBase(Statement statement) throws SQLException {

        statement.executeUpdate("DROP SCHEMA IF EXISTS `narushevich` ;");
        statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `narushevich` DEFAULT CHARACTER SET utf8 ;");
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS `narushevich`.`roles` (\n" +
                "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                "  `role` VARCHAR(45) NULL,\n" +
                "  PRIMARY KEY (`id`))\n" +
                "ENGINE = InnoDB;");
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS `narushevich`.`country` (\n" +
                "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                "  `country` VARCHAR(45) NULL,\n" +
                "  PRIMARY KEY (`id`))\n" +
                "ENGINE = InnoDB;");
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS `narushevich`.`city` (\n" +
                "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                "  `city` VARCHAR(45) NULL,\n" +
                "  PRIMARY KEY (`id`))\n" +
                "ENGINE = InnoDB;");
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS `narushevich`.`users` (\n" +
                "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                "  `login` VARCHAR(45) NULL,\n" +
                "  `password` VARCHAR(45) NULL,\n" +
                "  `email` VARCHAR(45) NULL,\n" +
                "  `roles_id` INT NOT NULL,\n" +
                "  `country_id` INT NOT NULL,\n" +
                "  `city_id` INT NOT NULL,\n" +
                "  PRIMARY KEY (`id`),\n" +
                "  CONSTRAINT `fk_users_roles`\n" +
                "    FOREIGN KEY (`roles_id`)\n" +
                "    REFERENCES `narushevich`.`roles` (`id`)\n" +
                "    ON DELETE RESTRICT\n" +
                "    ON UPDATE RESTRICT,\n" +
                "  CONSTRAINT `fk_users_country1`\n" +
                "    FOREIGN KEY (`country_id`)\n" +
                "    REFERENCES `narushevich`.`country` (`id`)\n" +
                "    ON DELETE RESTRICT\n" +
                "    ON UPDATE CASCADE,\n" +
                "  CONSTRAINT `fk_users_city1`\n" +
                "    FOREIGN KEY (`city_id`)\n" +
                "    REFERENCES `narushevich`.`city` (`id`)\n" +
                "    ON DELETE RESTRICT\n" +
                "    ON UPDATE CASCADE)\n" +
                "ENGINE = InnoDB;");
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS `narushevich`.`material` (\n" +
                "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                "  `material` VARCHAR(45) NULL,\n" +
                "  PRIMARY KEY (`id`))\n" +
                "ENGINE = InnoDB;");
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS `narushevich`.`exchange` (\n" +
                "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                "  `exchange` VARCHAR(3) NULL,\n" +
                "  PRIMARY KEY (`id`))\n" +
                "ENGINE = InnoDB;");
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS `narushevich`.`trademark` (\n" +
                "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                "  `trademark` VARCHAR(45) NULL,\n" +
                "  PRIMARY KEY (`id`))\n" +
                "ENGINE = InnoDB;");
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS `narushevich`.`size` (\n" +
                "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                "  `size` VARCHAR(10) NULL,\n" +
                "  PRIMARY KEY (`id`))\n" +
                "ENGINE = InnoDB;");
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS `narushevich`.`in collection since` (\n" +
                "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                "  `in collection since` VARCHAR(45) NULL,\n" +
                "  PRIMARY KEY (`id`))\n" +
                "ENGINE = InnoDB;");
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS `narushevich`.`teatags` (\n" +
                "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                "  `trademark_id` INT NOT NULL,\n" +
                "  `name` VARCHAR(45) NULL,\n" +
                "  `country_id` INT NOT NULL,\n" +
                "  `material_id` INT NOT NULL,\n" +
                "  `size_id` INT NOT NULL,\n" +
                "  `in collection since_id` INT NOT NULL,\n" +
                "  `exchange_id` INT NOT NULL,\n" +
                "  `users_id` INT NOT NULL,\n" +
                "  PRIMARY KEY (`id`),\n" +
                "  CONSTRAINT `fk_teatags_users1`\n" +
                "    FOREIGN KEY (`users_id`)\n" +
                "    REFERENCES `narushevich`.`users` (`id`)\n" +
                "    ON DELETE CASCADE\n" +
                "    ON UPDATE CASCADE,\n" +
                "  CONSTRAINT `fk_teatags_country1`\n" +
                "    FOREIGN KEY (`country_id`)\n" +
                "    REFERENCES `narushevich`.`country` (`id`)\n" +
                "    ON DELETE NO ACTION\n" +
                "    ON UPDATE CASCADE,\n" +
                "  CONSTRAINT `fk_teatags_material1`\n" +
                "    FOREIGN KEY (`material_id`)\n" +
                "    REFERENCES `narushevich`.`material` (`id`)\n" +
                "    ON DELETE NO ACTION\n" +
                "    ON UPDATE NO ACTION,\n" +
                "  CONSTRAINT `fk_teatags_exchange1`\n" +
                "    FOREIGN KEY (`exchange_id`)\n" +
                "    REFERENCES `narushevich`.`exchange` (`id`)\n" +
                "    ON DELETE NO ACTION\n" +
                "    ON UPDATE NO ACTION,\n" +
                "  CONSTRAINT `fk_teatags_trademark1`\n" +
                "    FOREIGN KEY (`trademark_id`)\n" +
                "    REFERENCES `narushevich`.`trademark` (`id`)\n" +
                "    ON DELETE NO ACTION\n" +
                "    ON UPDATE NO ACTION,\n" +
                "  CONSTRAINT `fk_teatags_size1`\n" +
                "    FOREIGN KEY (`size_id`)\n" +
                "    REFERENCES `narushevich`.`size` (`id`)\n" +
                "    ON DELETE NO ACTION\n" +
                "    ON UPDATE CASCADE,\n" +
                "  CONSTRAINT `fk_teatags_in collection since1`\n" +
                "    FOREIGN KEY (`in collection since_id`)\n" +
                "    REFERENCES `narushevich`.`in collection since` (`id`)\n" +
                "    ON DELETE NO ACTION\n" +
                "    ON UPDATE NO ACTION)\n" +
                "ENGINE = InnoDB;");
        statement.executeUpdate("INSERT INTO `narushevich`.`roles` (`id`, `role`) VALUES (DEFAULT, 'admin');");
        statement.executeUpdate("INSERT INTO `narushevich`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user');");
        statement.executeUpdate("INSERT INTO `narushevich`.`roles` (`id`, `role`) VALUES (DEFAULT, 'moderator');");
        statement.executeUpdate("INSERT INTO `narushevich`.`roles` (`id`, `role`) VALUES (DEFAULT, 'guest');");
        statement.executeUpdate("INSERT INTO `narushevich`.`country` (`id`, `country`) VALUES (DEFAULT, 'Belarus');");
        statement.executeUpdate("INSERT INTO `narushevich`.`country` (`id`, `country`) VALUES (DEFAULT, 'Russia');");
        statement.executeUpdate("INSERT INTO `narushevich`.`country` (`id`, `country`) VALUES (DEFAULT, 'Poland');");
        statement.executeUpdate("INSERT INTO `narushevich`.`country` (`id`, `country`) VALUES (DEFAULT, 'France');");
        statement.executeUpdate("INSERT INTO `narushevich`.`country` (`id`, `country`) VALUES (DEFAULT, 'Chech Republic');");
        statement.executeUpdate("INSERT INTO `narushevich`.`country` (`id`, `country`) VALUES (DEFAULT, 'Germany');");
        statement.executeUpdate("INSERT INTO `narushevich`.`country` (`id`, `country`) VALUES (DEFAULT, 'Japan');");
        statement.executeUpdate("INSERT INTO `narushevich`.`country` (`id`, `country`) VALUES (DEFAULT, 'South Korea');");
        statement.executeUpdate("INSERT INTO `narushevich`.`country` (`id`, `country`) VALUES (DEFAULT, 'Siria');");
        statement.executeUpdate("INSERT INTO `narushevich`.`city` (`id`, `city`) VALUES (DEFAULT, 'Minsk');");
        statement.executeUpdate("INSERT INTO `narushevich`.`city` (`id`, `city`) VALUES (DEFAULT, 'Moscow');");
        statement.executeUpdate("INSERT INTO `narushevich`.`city` (`id`, `city`) VALUES (DEFAULT, 'Warsaw');");
        statement.executeUpdate("INSERT INTO `narushevich`.`city` (`id`, `city`) VALUES (DEFAULT, 'Paris');");
        statement.executeUpdate("INSERT INTO `narushevich`.`city` (`id`, `city`) VALUES (DEFAULT, 'Smolensk');");
        statement.executeUpdate("INSERT INTO `narushevich`.`users` (`id`, `login`, `password`, `email`, `roles_id`, `country_id`, `city_id`) VALUES (DEFAULT, 'masha_05', 'qwerty', 'masha_05@tut.by', 1, 1, 1);");
        statement.executeUpdate("INSERT INTO `narushevich`.`users` (`id`, `login`, `password`, `email`, `roles_id`, `country_id`, `city_id`) VALUES (DEFAULT, 'fr_pole', 'asdfgh', 'pol_zhan@gmail.com', 2, 4, 4);");
        statement.executeUpdate("INSERT INTO `narushevich`.`users` (`id`, `login`, `password`, `email`, `roles_id`, `country_id`, `city_id`) VALUES (DEFAULT, 'dimon_rus', 'wasder', 'dimas@mail.ru', 2, 2, 2);");
        statement.executeUpdate("INSERT INTO `narushevich`.`material` (`id`, `material`) VALUES (DEFAULT, 'cardboard');");
        statement.executeUpdate("INSERT INTO `narushevich`.`material` (`id`, `material`) VALUES (DEFAULT, 'paper');");
        statement.executeUpdate("INSERT INTO `narushevich`.`material` (`id`, `material`) VALUES (DEFAULT, 'plastic');");
        statement.executeUpdate("INSERT INTO `narushevich`.`exchange` (`id`, `exchange`) VALUES (DEFAULT, 'no');");
        statement.executeUpdate("INSERT INTO `narushevich`.`exchange` (`id`, `exchange`) VALUES (DEFAULT, 'yes');");
        statement.executeUpdate("INSERT INTO `narushevich`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'Ahmad tea');");
        statement.executeUpdate("INSERT INTO `narushevich`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'Akbar');");
        statement.executeUpdate("INSERT INTO `narushevich`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'Alattar');");
        statement.executeUpdate("INSERT INTO `narushevich`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'Auchan');");
        statement.executeUpdate("INSERT INTO `narushevich`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'Brooke Bond');");
        statement.executeUpdate("INSERT INTO `narushevich`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'Chelton');");
        statement.executeUpdate("INSERT INTO `narushevich`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'Dilmah');");
        statement.executeUpdate("INSERT INTO `narushevich`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'Forest of Arden');");
        statement.executeUpdate("INSERT INTO `narushevich`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'Golden Bowl');");
        statement.executeUpdate("INSERT INTO `narushevich`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'Greenfield');");
        statement.executeUpdate("INSERT INTO `narushevich`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'Jaf tea');");
        statement.executeUpdate("INSERT INTO `narushevich`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'Kakoo');");
        statement.executeUpdate("INSERT INTO `narushevich`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'Lipton');");
        statement.executeUpdate("INSERT INTO `narushevich`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'Lord Nelson');");
        statement.executeUpdate("INSERT INTO `narushevich`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'Mabroc');");
        statement.executeUpdate("INSERT INTO `narushevich`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'Maitre de The');");
        statement.executeUpdate("INSERT INTO `narushevich`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'Malwa');");
        statement.executeUpdate("INSERT INTO `narushevich`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'Messmer');");
        statement.executeUpdate("INSERT INTO `narushevich`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'Mistral');");
        statement.executeUpdate("INSERT INTO `narushevich`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'Natursan');");
        statement.executeUpdate("INSERT INTO `narushevich`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'Pickwick');");
        statement.executeUpdate("INSERT INTO `narushevich`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'Princess Java');");
        statement.executeUpdate("INSERT INTO `narushevich`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'Tea');");
        statement.executeUpdate("INSERT INTO `narushevich`.`size` (`id`, `size`) VALUES (DEFAULT, '20 x 20');");
        statement.executeUpdate("INSERT INTO `narushevich`.`size` (`id`, `size`) VALUES (DEFAULT, '20 x 24');\n");
        statement.executeUpdate("INSERT INTO `narushevich`.`size` (`id`, `size`) VALUES (DEFAULT, '20 x 28');\n");
        statement.executeUpdate("INSERT INTO `narushevich`.`size` (`id`, `size`) VALUES (DEFAULT, '21 x 22');\n");
        statement.executeUpdate("INSERT INTO `narushevich`.`size` (`id`, `size`) VALUES (DEFAULT, '22 x 22');\n");
        statement.executeUpdate("INSERT INTO `narushevich`.`size` (`id`, `size`) VALUES (DEFAULT, '23 x 28');\n");
        statement.executeUpdate("INSERT INTO `narushevich`.`size` (`id`, `size`) VALUES (DEFAULT, '25 x 28');");
        statement.executeUpdate("INSERT INTO `narushevich`.`size` (`id`, `size`) VALUES (DEFAULT, '25 x 30');");
        statement.executeUpdate("INSERT INTO `narushevich`.`size` (`id`, `size`) VALUES (DEFAULT, '26 x 28');\n");
        statement.executeUpdate("INSERT INTO `narushevich`.`size` (`id`, `size`) VALUES (DEFAULT, '27 x 27');\n");
        statement.executeUpdate("INSERT INTO `narushevich`.`size` (`id`, `size`) VALUES (DEFAULT, '28 x 32');\n");
        statement.executeUpdate("INSERT INTO `narushevich`.`in collection since` (`id`, `in collection since`) VALUES (DEFAULT, '1998');");
        statement.executeUpdate("INSERT INTO `narushevich`.`in collection since` (`id`, `in collection since`) VALUES (DEFAULT, '1999');");
        statement.executeUpdate("INSERT INTO `narushevich`.`in collection since` (`id`, `in collection since`) VALUES (DEFAULT, '2000');");
        statement.executeUpdate("INSERT INTO `narushevich`.`in collection since` (`id`, `in collection since`) VALUES (DEFAULT, '2001');");
        statement.executeUpdate("INSERT INTO `narushevich`.`in collection since` (`id`, `in collection since`) VALUES (DEFAULT, '2002');");
        statement.executeUpdate("INSERT INTO `narushevich`.`in collection since` (`id`, `in collection since`) VALUES (DEFAULT, '2003');");
        statement.executeUpdate("INSERT INTO `narushevich`.`in collection since` (`id`, `in collection since`) VALUES (DEFAULT, '2004');");
        statement.executeUpdate("INSERT INTO `narushevich`.`in collection since` (`id`, `in collection since`) VALUES (DEFAULT, '2005');");
        statement.executeUpdate("INSERT INTO `narushevich`.`in collection since` (`id`, `in collection since`) VALUES (DEFAULT, '2006');");
        statement.executeUpdate("INSERT INTO `narushevich`.`in collection since` (`id`, `in collection since`) VALUES (DEFAULT, '2007');");
        statement.executeUpdate("INSERT INTO `narushevich`.`in collection since` (`id`, `in collection since`) VALUES (DEFAULT, '2008');");
        statement.executeUpdate("INSERT INTO `narushevich`.`in collection since` (`id`, `in collection since`) VALUES (DEFAULT, '2009');");
        statement.executeUpdate("INSERT INTO `narushevich`.`in collection since` (`id`, `in collection since`) VALUES (DEFAULT, '2010');");
        statement.executeUpdate("INSERT INTO `narushevich`.`in collection since` (`id`, `in collection since`) VALUES (DEFAULT, '2011');");
        statement.executeUpdate("INSERT INTO `narushevich`.`in collection since` (`id`, `in collection since`) VALUES (DEFAULT, '2012');");
        statement.executeUpdate("INSERT INTO `narushevich`.`in collection since` (`id`, `in collection since`) VALUES (DEFAULT, '2013');");
        statement.executeUpdate("INSERT INTO `narushevich`.`in collection since` (`id`, `in collection since`) VALUES (DEFAULT, '2014');");
        statement.executeUpdate("INSERT INTO `narushevich`.`in collection since` (`id`, `in collection since`) VALUES (DEFAULT, '2015');");
        statement.executeUpdate("INSERT INTO `narushevich`.`in collection since` (`id`, `in collection since`) VALUES (DEFAULT, '2016');");
        statement.executeUpdate("INSERT INTO `narushevich`.`in collection since` (`id`, `in collection since`) VALUES (DEFAULT, '2017');");
        statement.executeUpdate("INSERT INTO `narushevich`.`in collection since` (`id`, `in collection since`) VALUES (DEFAULT, '2018');");
        statement.executeUpdate("INSERT INTO `narushevich`.`in collection since` (`id`, `in collection since`) VALUES (DEFAULT, '2019');");
        statement.executeUpdate("INSERT INTO `narushevich`.`in collection since` (`id`, `in collection since`) VALUES (DEFAULT, '2020');");
        statement.executeUpdate("INSERT INTO `narushevich`.`in collection since` (`id`, `in collection since`) VALUES (DEFAULT, '2021');");
        statement.executeUpdate("INSERT INTO `narushevich`.`in collection since` (`id`, `in collection since`) VALUES (DEFAULT, '2022');");
        statement.executeUpdate("INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 1, 'English Tea #1', 1, 1, 11, 20, 1, 1);");
        statement.executeUpdate("INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 1, 'Cinnamon Haze', 3, 1, 11, 21, 1, 1);");
        statement.executeUpdate("INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 1, 'Earl Grey', 1, 1, 11, 5, 1, 1);");
        statement.executeUpdate("INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 1, 'Earl Grey', 1, 1, 11, 8, 1, 1);");
        statement.executeUpdate("INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 1, 'Green Tea', 1, 1, 11, 11, 1, 1);");
        statement.executeUpdate("INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 1, 'English Breakfast', 1, 1, 11, 4, 1, 1);");
        statement.executeUpdate("INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 1, 'English Breakfast', 1, 1, 11, 1, 1, 1);");
        statement.executeUpdate("INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 1, 'Lemon & Lime Twist', 3, 1, 11, 21, 1, 1);");
        statement.executeUpdate("INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 1, 'Classic black tea', 1, 1, 11, 16, 2, 1);");
        statement.executeUpdate("INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 13, 'Yellow Label tea', 1, 1, 11, 15, 1, 1);");
        statement.executeUpdate("INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 13, 'Yellow Label tea', 1, 1, 11, 8, 1, 1);");
        statement.executeUpdate("INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 13, 'Royal Ceylon', 1, 1, 11, 6, 1, 1);");
        statement.executeUpdate("INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 13, 'A moment to energise', 3, 1, 9, 20, 1, 1);");
        statement.executeUpdate("INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 13, 'A moment to balance', 3, 1, 9, 20, 1, 1);");
        statement.executeUpdate("INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 13, 'pure black ceylon', 1, 2, 5, 10, 1, 1);");
        statement.executeUpdate("INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 13, 'cherry morello', 1, 2, 5, 10, 1, 1);");
        statement.executeUpdate("INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 13, 'pear chocolate', 1, 2, 5, 10, 1, 1);");
        statement.executeUpdate("INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 13, 'flirty lady', 1, 2, 1, 18, 1, 1);");
        statement.executeUpdate("INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 13, 'blue fruit', 1, 2, 5, 14, 1, 1);");
        statement.executeUpdate("INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 13, 'Orange Jaipur', 1, 2, 5, 9, 1, 1);");
        statement.executeUpdate("INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 11, 'temptation', 1, 1, 6, 4, 1, 1);");
        statement.executeUpdate("INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 10, 'finelly selected speciality tea', 1, 2, 3, 6, 1, 1);");
        statement.executeUpdate("INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 22, 'black', 1, 2, 3, 3, 1, 1);");
        statement.executeUpdate("INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 20, 'La via del te firenze', 1, 2, 3, 8, 2, 1);");
        statement.executeUpdate("INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 19, 'Cristmas tea', 5, 1, 6, 20, 1, 1);");
        statement.executeUpdate("INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 6, '100% pure ceylon tea', 1, 1, 11, 6, 1, 1);");
        statement.executeUpdate("INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 4, 'Black tea', 3, 1, 11, 21, 1, 1);");
        statement.executeUpdate("INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 13, 'Russian Earl Grey', 2, 1, 8, 13, 1, 1);");
        statement.executeUpdate("INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 2, 'English breakfast', 1, 1, 11, 10, 1, 1);");
        statement.executeUpdate("INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 2, 'flavoured tea', 1, 1, 11, 14, 1, 1);");
        statement.executeUpdate("INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 14, 'Lemon & Ginger', 3, 1, 11, 18, 1, 1);");
        statement.executeUpdate("INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 8, '2006', 4, 2, 3, 11, 1, 3);");
        statement.executeUpdate("INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 15, '1001 night', 4, 2, 3, 13, 1, 3);");
        statement.executeUpdate("INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 16, 'Noir', 4, 2, 6, 5, 1, 3);");
        statement.executeUpdate("INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 18, 'Zitrone', 6, 1, 11, 12, 1, 3);");
        statement.executeUpdate("INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 12, 'Green tea bags', 7, 2, 7, 13, 1, 3);");
        statement.executeUpdate("INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 23, 'green', 8, 2, 1, 13, 1, 3);");
        statement.executeUpdate("INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 3, 'black', 9, 2, 7, 13, 2, 3);");
        statement.executeUpdate("INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 7, 'Lychee', 2, 2, 3, 15, 1, 3);");
        statement.executeUpdate("INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 7, 'Earl Grey', 2, 2, 3, 15, 1, 3);");
        statement.executeUpdate("INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 7, 'Strawberry tea', 2, 2, 3, 15, 1, 3);");
        statement.executeUpdate("INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 7, 'Natural green tea', 2, 2, 3, 15, 1, 3);");
        statement.executeUpdate("INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 21, 'finest tea', 1, 2, 8, 9, 1, 3);");
        statement.executeUpdate("INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 17, 'smak natury', 3, 2, 3, 19, 1, 3);");
        statement.executeUpdate("INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 5, 'history', 2, 1, 11, 11, 1, 2);");
        statement.executeUpdate("INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 5, 'history', 2, 1, 11, 12, 1, 2);");
        statement.executeUpdate("INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 5, 'history', 2, 1, 11, 12, 1, 2);");
        statement.executeUpdate("INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 9, 'strawberry', 2, 2, 7, 14, 1, 2);");
        statement.executeUpdate("INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 9, 'green tea', 2, 1, 9, 13, 1, 2);");
        statement.executeUpdate("INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 9, 'black tea', 2, 1, 11, 10, 1, 2);");
        statement.executeUpdate("INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 9, 'indian', 2, 1, 9, 13, 1, 2);");
    }
}
