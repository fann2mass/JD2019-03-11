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
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS `narushevich`.`users` (\n" +
                "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                "  `nickname` VARCHAR(15) NULL,\n" +
                "  `login` VARCHAR(15) NULL,\n" +
                "  `password` VARCHAR(15) NULL,\n" +
                "  `email` VARCHAR(45) NULL,\n" +
                "  `roles_id` INT NOT NULL,\n" +
                "  PRIMARY KEY (`id`),\n" +
                "  CONSTRAINT `fk_users_roles`\n" +
                "    FOREIGN KEY (`roles_id`)\n" +
                "    REFERENCES `narushevich`.`roles` (`id`)\n" +
                "    ON DELETE RESTRICT\n" +
                "    ON UPDATE RESTRICT)\n" +
                "ENGINE = InnoDB;");
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS `narushevich`.`material` (\n" +
                "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                "  `material` VARCHAR(45) NULL,\n" +
                "  PRIMARY KEY (`id`))\n" +
                "ENGINE = InnoDB;");
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS `narushevich`.`trademark` (\n" +
                "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                "  `trademark` VARCHAR(45) NULL,\n" +
                "  PRIMARY KEY (`id`))\n" +
                "ENGINE = InnoDB;");
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS `narushevich`.`width_x_height` (\n" +
                "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                "  `width_x_height` VARCHAR(10) NULL,\n" +
                "  PRIMARY KEY (`id`))\n" +
                "ENGINE = InnoDB;");
        statement.executeUpdate("CREATE TABLE IF NOT EXISTS `narushevich`.`teatags` (\n" +
                "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                "  `trademark_id` INT NOT NULL,\n" +
                "  `subtitle` VARCHAR(45) NULL,\n" +
                "  `material_id` INT NOT NULL,\n" +
                "  `width_x_height_id` INT NOT NULL,\n" +
                "  `in_collection_since` VARCHAR(10) NULL,\n" +
                "  `num_in_catalog` VARCHAR(10) NULL,\n" +
                "  `users_id` INT NOT NULL,\n" +
                "  PRIMARY KEY (`id`),\n" +
                "  CONSTRAINT `fk_teatags_users1`\n" +
                "    FOREIGN KEY (`users_id`)\n" +
                "    REFERENCES `narushevich`.`users` (`id`)\n" +
                "    ON DELETE CASCADE\n" +
                "    ON UPDATE CASCADE,\n" +
                "  CONSTRAINT `fk_teatags_material1`\n" +
                "    FOREIGN KEY (`material_id`)\n" +
                "    REFERENCES `narushevich`.`material` (`id`)\n" +
                "    ON DELETE NO ACTION\n" +
                "    ON UPDATE CASCADE,\n" +
                "  CONSTRAINT `fk_teatags_trademark1`\n" +
                "    FOREIGN KEY (`trademark_id`)\n" +
                "    REFERENCES `narushevich`.`trademark` (`id`)\n" +
                "    ON DELETE NO ACTION\n" +
                "    ON UPDATE CASCADE,\n" +
                "  CONSTRAINT `fk_teatags_size1`\n" +
                "    FOREIGN KEY (`width_x_height_id`)\n" +
                "    REFERENCES `narushevich`.`width_x_height` (`id`)\n" +
                "    ON DELETE NO ACTION\n" +
                "    ON UPDATE CASCADE)\n" +
                "ENGINE = InnoDB;");
        statement.executeUpdate("INSERT INTO `narushevich`.`roles` (`id`, `role`) VALUES (DEFAULT, 'admin');");
        statement.executeUpdate("INSERT INTO `narushevich`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user');");
        statement.executeUpdate("INSERT INTO `narushevich`.`roles` (`id`, `role`) VALUES (DEFAULT, 'moderator');");
        statement.executeUpdate("INSERT INTO `narushevich`.`roles` (`id`, `role`) VALUES (DEFAULT, 'guest');");
        statement.executeUpdate("INSERT INTO `narushevich`.`users` (`id`, `nickname`, `login`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'Mari_Ann', 'masha_05', 'qwerty', 'masha_05@tut.by', 1);");
        statement.executeUpdate("INSERT INTO `narushevich`.`users` (`id`, `nickname`, `login`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'Zhan_Pol', 'fr_pole', 'asdfgh', 'pol_zhan@gmail.com', 2);");
        statement.executeUpdate("INSERT INTO `narushevich`.`users` (`id`, `nickname`, `login`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'Dima_96', 'dimon_rus', 'wasder', 'dimas@mail.ru', 2);");
        statement.executeUpdate("INSERT INTO `narushevich`.`material` (`id`, `material`) VALUES (DEFAULT, 'cardboard');");
        statement.executeUpdate("INSERT INTO `narushevich`.`material` (`id`, `material`) VALUES (DEFAULT, 'paper');");
        statement.executeUpdate("INSERT INTO `narushevich`.`material` (`id`, `material`) VALUES (DEFAULT, 'plastic');");
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
        statement.executeUpdate("INSERT INTO `narushevich`.`width_x_height` (`id`, `width_x_height`) VALUES (DEFAULT, '20 x 20');");
        statement.executeUpdate("INSERT INTO `narushevich`.`width_x_height` (`id`, `width_x_height`) VALUES (DEFAULT, '20 x 24');\n");
        statement.executeUpdate("INSERT INTO `narushevich`.`width_x_height` (`id`, `width_x_height`) VALUES (DEFAULT, '20 x 28');\n");
        statement.executeUpdate("INSERT INTO `narushevich`.`width_x_height` (`id`, `width_x_height`) VALUES (DEFAULT, '21 x 22');\n");
        statement.executeUpdate("INSERT INTO `narushevich`.`width_x_height` (`id`, `width_x_height`) VALUES (DEFAULT, '22 x 22');\n");
        statement.executeUpdate("INSERT INTO `narushevich`.`width_x_height` (`id`, `width_x_height`) VALUES (DEFAULT, '23 x 28');\n");
        statement.executeUpdate("INSERT INTO `narushevich`.`width_x_height` (`id`, `width_x_height`) VALUES (DEFAULT, '25 x 28');");
        statement.executeUpdate("INSERT INTO `narushevich`.`width_x_height` (`id`, `width_x_height`) VALUES (DEFAULT, '25 x 30');");
        statement.executeUpdate("INSERT INTO `narushevich`.`width_x_height` (`id`, `width_x_height`) VALUES (DEFAULT, '26 x 28');\n");
        statement.executeUpdate("INSERT INTO `narushevich`.`width_x_height` (`id`, `width_x_height`) VALUES (DEFAULT, '27 x 27');\n");
        statement.executeUpdate("INSERT INTO `narushevich`.`width_x_height` (`id`, `width_x_height`) VALUES (DEFAULT, '28 x 32');\n");
        statement.executeUpdate("INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `num_in_catalog`, `users_id`) VALUES (DEFAULT, 1, 'English Tea #1', 1, 11, '2017-04-01','02-08-3', 1);");
        statement.executeUpdate("INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `num_in_catalog`, `users_id`) VALUES (DEFAULT, 1, 'Cinnamon Haze', 1, 11, '2018-05-05','02-08-4', 1);");
        statement.executeUpdate("INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `num_in_catalog`, `users_id`) VALUES (DEFAULT, 1, 'Earl Grey', 1, 11, '2002-01-07','02-09-1', 1);");
        statement.executeUpdate("INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `num_in_catalog`, `users_id`) VALUES (DEFAULT, 1, 'Earl Grey', 1, 11, '2005-09-14','02-09-2', 1);");
        statement.executeUpdate("INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `num_in_catalog`, `users_id`) VALUES (DEFAULT, 1, 'Green Tea', 1, 11, '2008-04-18','02-09-4', 1);");
        statement.executeUpdate("INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `num_in_catalog`, `users_id`) VALUES (DEFAULT, 1, 'English Breakfast', 1, 11, '2001-04-05','02-10-1', 1);");
        statement.executeUpdate("INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `num_in_catalog`, `users_id`) VALUES (DEFAULT, 1, 'English Breakfast', 1, 11, '1998-10-18','02-10-2', 1);");
        statement.executeUpdate("INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `num_in_catalog`, `users_id`) VALUES (DEFAULT, 1, 'Lemon & Lime Twist', 1, 11, '2018-01-06','02-10-3', 1);");
        statement.executeUpdate("INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `num_in_catalog`, `users_id`) VALUES (DEFAULT, 1, 'Classic black tea', 1, 11, '2013-05-20','02-10-4', 1);");
        statement.executeUpdate("INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `num_in_catalog`, `users_id`) VALUES (DEFAULT, 13, 'Yellow Label tea', 1, 11, '2012-03-20','02-11-2', 1);");
        statement.executeUpdate("INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `num_in_catalog`, `users_id`) VALUES (DEFAULT, 13, 'Yellow Label tea', 1, 11, '2005-03-20','02-11-1', 1);");
        statement.executeUpdate("INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `num_in_catalog`, `users_id`) VALUES (DEFAULT, 13, 'Royal Ceylon', 1, 11, '2003-05-10','02-11-3', 1);");
        statement.executeUpdate("INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `num_in_catalog`, `users_id`) VALUES (DEFAULT, 13, 'A moment to energise', 1, 9, '2017-12-31','02-13-2', 1);");
        statement.executeUpdate("INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `num_in_catalog`, `users_id`) VALUES (DEFAULT, 13, 'A moment to balance', 1, 9, '2017-12-31','02-13-3', 1);");
        statement.executeUpdate("INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `num_in_catalog`, `users_id`) VALUES (DEFAULT, 13, 'pure black ceylon', 2, 5, '2007-02-15','01-17-1', 1);");
        statement.executeUpdate("INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `num_in_catalog`, `users_id`) VALUES (DEFAULT, 13, 'cherry morello', 2, 5, '2007-10-12','01-17-2', 1);");
        statement.executeUpdate("INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `num_in_catalog`, `users_id`) VALUES (DEFAULT, 13, 'pear chocolate', 2, 5, '2007-08-29','01-17-3', 1);");
        statement.executeUpdate("INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `num_in_catalog`, `users_id`) VALUES (DEFAULT, 13, 'flirty lady', 2, 1, '2015-07-14','01-17-4', 1);");
        statement.executeUpdate("INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `num_in_catalog`, `users_id`) VALUES (DEFAULT, 13, 'blue fruit', 2, 5, '2011-03-20','01-17-5', 1);");
        statement.executeUpdate("INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `num_in_catalog`, `users_id`) VALUES (DEFAULT, 13, 'Orange Jaipur', 2, 5, '2006-12-16','01-18-3', 1);");
        statement.executeUpdate("INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `num_in_catalog`, `users_id`) VALUES (DEFAULT, 11, 'temptation', 1, 6, '2001-10-02','01-14-1', 1);");
        statement.executeUpdate("INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `num_in_catalog`, `users_id`) VALUES (DEFAULT, 10, 'finelly selected speciality tea', 2, 3, '2003-05-16','01-15-1', 1);");
        statement.executeUpdate("INSERT INTO `narushevich`. `teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `num_in_catalog`, `users_id`) VALUES(DEFAULT, 22, 'black', 2, 3, '2000-12-28','01-06-1', 1);");
        statement.executeUpdate("INSERT INTO `narushevich`. `teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `num_in_catalog`, `users_id`) VALUES(DEFAULT, 20, 'La via del te firenze', 2, 3, '2005-09-12','01-04-5', 1);");
        statement.executeUpdate("INSERT INTO `narushevich`. `teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `num_in_catalog`, `users_id`) VALUES(DEFAULT, 19, 'Cristmas tea', 1, 6, '2017-12-25','01-27-1', 1);");
        statement.executeUpdate("INSERT INTO `narushevich`. `teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `num_in_catalog`, `users_id`) VALUES(DEFAULT, 6, '100% pure ceylon tea', 1, 11, '2003-11-12','02-04-2', 1);");
        statement.executeUpdate("INSERT INTO `narushevich`. `teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `num_in_catalog`, `users_id`) VALUES(DEFAULT, 4, 'Black tea', 1, 11, '2018-04-06','02-01-1', 1);");
        statement.executeUpdate("INSERT INTO `narushevich`. `teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `num_in_catalog`, `users_id`) VALUES(DEFAULT, 13, 'Russian Earl Grey', 1, 8, '2010-05-20','02-12-4', 1);");
        statement.executeUpdate("INSERT INTO `narushevich`. `teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `num_in_catalog`, `users_id`) VALUES(DEFAULT, 2, 'English breakfast', 1, 11, '2007-08-31','02-19-4', 1);");
        statement.executeUpdate("INSERT INTO `narushevich`. `teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `num_in_catalog`, `users_id`) VALUES(DEFAULT, 2, 'flavoured tea', 1, 11, '2011-05-10','02-19-3', 1);");
        statement.executeUpdate("INSERT INTO `narushevich`. `teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `num_in_catalog`, `users_id`) VALUES(DEFAULT, 14, 'Lemon & Ginger', 1, 11, '2015-10-18','02-21-2', 1);");
        statement.executeUpdate("INSERT INTO `narushevich`. `teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `num_in_catalog`, `users_id`) VALUES(DEFAULT, 8, '2006', 2, 3, '2008-09-15','01-02-4', 2);");
        statement.executeUpdate("INSERT INTO `narushevich`. `teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `num_in_catalog`, `users_id`) VALUES(DEFAULT, 15, '1001 night', 2, 3, '2010-04-20','01-02-2', 2);");
        statement.executeUpdate("INSERT INTO `narushevich`. `teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `num_in_catalog`, `users_id`) VALUES(DEFAULT, 16, 'Noir', 2, 6, '2002-01-19','01-04-2', 2);");
        statement.executeUpdate("INSERT INTO `narushevich`. `teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `num_in_catalog`, `users_id`) VALUES(DEFAULT, 18, 'Zitrone', 1, 11, '2009-02-14','02-26-1', 2);");
        statement.executeUpdate("INSERT INTO `narushevich`. `teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `num_in_catalog`, `users_id`) VALUES(DEFAULT, 12, 'Green tea bags', 2, 7, '2010-11-05','02-26-2', 2);");
        statement.executeUpdate("INSERT INTO `narushevich`. `teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `num_in_catalog`, `users_id`) VALUES(DEFAULT, 23, 'green', 2, 1, '2010-11-06','01-03-3', 2);");
        statement.executeUpdate("INSERT INTO `narushevich`. `teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `num_in_catalog`, `users_id`) VALUES(DEFAULT, 7, 'Ceylon gold', 2, 8, '2010-04-09','02-06-3', 2);");
        statement.executeUpdate("INSERT INTO `narushevich`. `teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `num_in_catalog`, `users_id`) VALUES(DEFAULT, 7, 'Lychee', 2, 3, '2012-03-22','01-09-4', 2);");
        statement.executeUpdate("INSERT INTO `narushevich`. `teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `num_in_catalog`, `users_id`) VALUES(DEFAULT, 7, 'Earl Grey', 2, 3, '2012-01-19','01-09-5', 2);");
        statement.executeUpdate("INSERT INTO `narushevich`. `teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `num_in_catalog`, `users_id`) VALUES(DEFAULT, 7, 'Strawberry tea', 2, 3, '2012-06-15','01-09-2', 2);");
        statement.executeUpdate("INSERT INTO `narushevich`. `teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `num_in_catalog`, `users_id`) VALUES(DEFAULT, 7, 'Natural green tea', 2, 3, '2012-07-25','01-09-1', 2);");
        statement.executeUpdate("INSERT INTO `narushevich`. `teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `num_in_catalog`, `users_id`) VALUES(DEFAULT, 21, 'finest taste', 2, 8, '2006-07-14','01-16-1', 2);");
        statement.executeUpdate("INSERT INTO `narushevich`. `teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `num_in_catalog`, `users_id`) VALUES(DEFAULT, 17, 'Exclusive smak natury', 2, 3, '2016-12-15','01-24-3', 2);");
        statement.executeUpdate("INSERT INTO `narushevich`. `teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `num_in_catalog`, `users_id`) VALUES(DEFAULT, 5, 'history', 1, 11, '2008-04-14','02-35-1', 3);");
        statement.executeUpdate("INSERT INTO `narushevich`. `teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `num_in_catalog`, `users_id`) VALUES(DEFAULT, 5, 'history', 1, 11, '2008-04-14','02-35-2', 3);");
        statement.executeUpdate("INSERT INTO `narushevich`. `teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `num_in_catalog`, `users_id`) VALUES(DEFAULT, 5, 'history', 1, 11, '2008-04-14','02-35-3', 3);");
        statement.executeUpdate("INSERT INTO `narushevich`. `teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `num_in_catalog`, `users_id`) VALUES(DEFAULT, 9, 'strawberry', 2, 7, '2011-06-30','02-39-3',  3);");
        statement.executeUpdate("INSERT INTO `narushevich`. `teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `num_in_catalog`, `users_id`) VALUES(DEFAULT, 9, 'green tea', 1, 9, '2010-03-25','02-38-4', 3);");
        statement.executeUpdate("INSERT INTO `narushevich`. `teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `num_in_catalog`, `users_id`) VALUES(DEFAULT, 9, 'black tea', 1, 11, '2007-12-15','02-38-3', 3);");
        statement.executeUpdate("INSERT INTO `narushevich`. `teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `num_in_catalog`, `users_id`) VALUES(DEFAULT, 9, 'indian', 1, 9, '2010-05-04','02-38-1', 3);");

    }
}
