-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema narushevich
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `narushevich` ;

-- -----------------------------------------------------
-- Schema narushevich
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `narushevich` DEFAULT CHARACTER SET utf8 ;
USE `narushevich` ;

-- -----------------------------------------------------
-- Table `narushevich`.`roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `narushevich`.`roles` ;

CREATE TABLE IF NOT EXISTS `narushevich`.`roles` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `narushevich`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `narushevich`.`users` ;

CREATE TABLE IF NOT EXISTS `narushevich`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nickname` VARCHAR(15) NULL,
  `login` VARCHAR(15) NULL,
  `password` VARCHAR(15) NULL,
  `email` VARCHAR(45) NULL,
  `roles_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_users_roles`
    FOREIGN KEY (`roles_id`)
    REFERENCES `narushevich`.`roles` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `narushevich`.`material`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `narushevich`.`material` ;

CREATE TABLE IF NOT EXISTS `narushevich`.`material` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `material` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `narushevich`.`trademark`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `narushevich`.`trademark` ;

CREATE TABLE IF NOT EXISTS `narushevich`.`trademark` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `trademark` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `narushevich`.`width_x_height`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `narushevich`.`width_x_height` ;

CREATE TABLE IF NOT EXISTS `narushevich`.`width_x_height` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `width_x_height` VARCHAR(10) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `narushevich`.`teatags`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `narushevich`.`teatags` ;

CREATE TABLE IF NOT EXISTS `narushevich`.`teatags` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `trademark_id` INT NOT NULL,
  `subtitle` VARCHAR(45) NULL,
  `material_id` INT NOT NULL,
  `width_x_height_id` INT NOT NULL,
  `in_collection_since` DATE NOT NULL,
  `users_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_teatags_users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `narushevich`.`users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_teatags_material1`
    FOREIGN KEY (`material_id`)
    REFERENCES `narushevich`.`material` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_teatags_trademark1`
    FOREIGN KEY (`trademark_id`)
    REFERENCES `narushevich`.`trademark` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_teatags_size1`
    FOREIGN KEY (`width_x_height_id`)
    REFERENCES `narushevich`.`width_x_height` (`id`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `narushevich`.`roles`
-- -----------------------------------------------------
START TRANSACTION;
USE `narushevich`;
INSERT INTO `narushevich`.`roles` (`id`, `role`) VALUES (DEFAULT, 'admin');
INSERT INTO `narushevich`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user');
INSERT INTO `narushevich`.`roles` (`id`, `role`) VALUES (DEFAULT, 'moderator');
INSERT INTO `narushevich`.`roles` (`id`, `role`) VALUES (DEFAULT, 'guest');

COMMIT;


-- -----------------------------------------------------
-- Data for table `narushevich`.`users`
-- -----------------------------------------------------
START TRANSACTION;
USE `narushevich`;
INSERT INTO `narushevich`.`users` (`id`, `nickname`, `login`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'Mari_Ann', 'masha_05', 'qwerty', 'masha_05@tut.by', 1);
INSERT INTO `narushevich`.`users` (`id`, `nickname`, `login`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'Zhan_Pol', 'fr_pole', 'asdfgh', 'pol_zhan@gmail.com', 2);
INSERT INTO `narushevich`.`users` (`id`, `nickname`, `login`, `password`, `email`, `roles_id`) VALUES (DEFAULT, 'Dima_96', 'dimon_rus', 'wasder', 'dimas@mail.ru', 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `narushevich`.`material`
-- -----------------------------------------------------
START TRANSACTION;
USE `narushevich`;
INSERT INTO `narushevich`.`material` (`id`, `material`) VALUES (DEFAULT, 'cardboard');
INSERT INTO `narushevich`.`material` (`id`, `material`) VALUES (DEFAULT, 'paper');
INSERT INTO `narushevich`.`material` (`id`, `material`) VALUES (DEFAULT, 'plastic');

COMMIT;


-- -----------------------------------------------------
-- Data for table `narushevich`.`trademark`
-- -----------------------------------------------------
START TRANSACTION;
USE `narushevich`;
INSERT INTO `narushevich`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'Ahmad tea');
INSERT INTO `narushevich`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'Akbar');
INSERT INTO `narushevich`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'Alattar');
INSERT INTO `narushevich`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'Auchan');
INSERT INTO `narushevich`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'Brooke Bond');
INSERT INTO `narushevich`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'Chelton');
INSERT INTO `narushevich`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'Dilmah');
INSERT INTO `narushevich`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'Forest of Arden');
INSERT INTO `narushevich`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'Golden Bowl');
INSERT INTO `narushevich`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'Greenfield');
INSERT INTO `narushevich`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'Jaf Tea');
INSERT INTO `narushevich`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'Kakoo');
INSERT INTO `narushevich`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'Lipton');
INSERT INTO `narushevich`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'Lord Nelson');
INSERT INTO `narushevich`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'Mabroc');
INSERT INTO `narushevich`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'Maitre de The');
INSERT INTO `narushevich`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'Malwa');
INSERT INTO `narushevich`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'Messmer');
INSERT INTO `narushevich`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'Mistral');
INSERT INTO `narushevich`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'Natursan');
INSERT INTO `narushevich`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'Pickwick');
INSERT INTO `narushevich`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'Princess Java');
INSERT INTO `narushevich`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'Tea');

COMMIT;


-- -----------------------------------------------------
-- Data for table `narushevich`.`width_x_height`
-- -----------------------------------------------------
START TRANSACTION;
USE `narushevich`;
INSERT INTO `narushevich`.`width_x_height` (`id`, `width_x_height`) VALUES (DEFAULT, '20 x 20');
INSERT INTO `narushevich`.`width_x_height` (`id`, `width_x_height`) VALUES (DEFAULT, '20 x 24');
INSERT INTO `narushevich`.`width_x_height` (`id`, `width_x_height`) VALUES (DEFAULT, '20 x 28');
INSERT INTO `narushevich`.`width_x_height` (`id`, `width_x_height`) VALUES (DEFAULT, '21 x 22');
INSERT INTO `narushevich`.`width_x_height` (`id`, `width_x_height`) VALUES (DEFAULT, '22 x 22');
INSERT INTO `narushevich`.`width_x_height` (`id`, `width_x_height`) VALUES (DEFAULT, '23 x 28');
INSERT INTO `narushevich`.`width_x_height` (`id`, `width_x_height`) VALUES (DEFAULT, '25 x 28');
INSERT INTO `narushevich`.`width_x_height` (`id`, `width_x_height`) VALUES (DEFAULT, '25 x 30');
INSERT INTO `narushevich`.`width_x_height` (`id`, `width_x_height`) VALUES (DEFAULT, '26 x 28');
INSERT INTO `narushevich`.`width_x_height` (`id`, `width_x_height`) VALUES (DEFAULT, '27 x 27');
INSERT INTO `narushevich`.`width_x_height` (`id`, `width_x_height`) VALUES (DEFAULT, '28 x 32');

COMMIT;


-- -----------------------------------------------------
-- Data for table `narushevich`.`teatags`
-- -----------------------------------------------------
START TRANSACTION;
USE `narushevich`;
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `users_id`) VALUES (DEFAULT, 1, 'English Tea #1', 1, 11, '2017.04.01', 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `users_id`) VALUES (DEFAULT, 1, 'Cinnamon Haze', 1, 11, '2018.05.05', 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `users_id`) VALUES (DEFAULT, 1, 'Earl Grey', 1, 11, '2002.01.07', 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `users_id`) VALUES (DEFAULT, 1, 'Earl Grey', 1, 11, '2005.09.14', 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `users_id`) VALUES (DEFAULT, 1, 'Green Tea', 1, 11, '2008.04.18', 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `users_id`) VALUES (DEFAULT, 1, 'English Breakfast', 1, 11, '2001.04.05', 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `users_id`) VALUES (DEFAULT, 1, 'English Breakfast', 1, 11, '1998.10.18', 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `users_id`) VALUES (DEFAULT, 1, 'Lemon & Lime Twist', 1, 11, '2018.01.06', 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `users_id`) VALUES (DEFAULT, 1, 'Classic black tea', 1, 11, '2013.05.20', 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `users_id`) VALUES (DEFAULT, 13, 'Yellow Label tea', 1, 11, '2012.03.20', 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `users_id`) VALUES (DEFAULT, 13, 'Yellow Label tea', 1, 11, '2005.03.20', 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `users_id`) VALUES (DEFAULT, 13, 'Royal Ceylon', 1, 11, '2003.05.10', 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `users_id`) VALUES (DEFAULT, 13, 'A moment to energise', 1, 9, '2017.12.31', 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `users_id`) VALUES (DEFAULT, 13, 'A moment to balance', 1, 9, '2017.12.31', 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `users_id`) VALUES (DEFAULT, 13, 'pure black ceylon', 2, 5, '2007.02.15', 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `users_id`) VALUES (DEFAULT, 13, 'cherry morello', 2, 5, '2007.10.12', 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `users_id`) VALUES (DEFAULT, 13, 'pear chocolate', 2, 5, '2007.08.29', 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `users_id`) VALUES (DEFAULT, 13, 'flirty lady', 2, 1, '2015.07.14', 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `users_id`) VALUES (DEFAULT, 13, 'blue fruit', 2, 5, '2011.03.20', 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `users_id`) VALUES (DEFAULT, 13, 'Orange Jaipur', 2, 5, '2006.12.16', 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `users_id`) VALUES (DEFAULT, 11, 'temptation', 1, 6, '2001.10.02', 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `users_id`) VALUES (DEFAULT, 10, 'finelly selected speciality tea', 2, 3, '2003.05.16', 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `users_id`) VALUES (DEFAULT, 22, 'black', 2, 3, '2000.12.28', 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `users_id`) VALUES (DEFAULT, 20, 'La via del te firenze', 2, 3, '2005.09.12', 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `users_id`) VALUES (DEFAULT, 19, 'Cristmas tea', 1, 6, '2017.12.25', 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `users_id`) VALUES (DEFAULT, 6, '100% pure ceylon tea', 1, 11, '2003.11.12', 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `users_id`) VALUES (DEFAULT, 4, 'Black tea', 1, 11, '2018.04.06', 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `users_id`) VALUES (DEFAULT, 13, 'Russian Earl Grey', 1, 8, '2010.05.20', 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `users_id`) VALUES (DEFAULT, 2, 'English breakfast', 1, 11, '2007.08.31', 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `users_id`) VALUES (DEFAULT, 2, 'flavoured tea', 1, 11, '2011.05.10', 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `users_id`) VALUES (DEFAULT, 14, 'Lemon & Ginger', 1, 11, '2015.10.18', 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `users_id`) VALUES (DEFAULT, 8, '2006', 2, 3, '2008.09.15', 2);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `users_id`) VALUES (DEFAULT, 15, '1001 night', 2, 3, '2010.04.20', 2);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `users_id`) VALUES (DEFAULT, 16, 'Noir', 2, 6, '2002.01.19', 2);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `users_id`) VALUES (DEFAULT, 18, 'Zitrone', 1, 11, '2009.02.14', 2);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `users_id`) VALUES (DEFAULT, 12, 'Green tea bags', 2, 7, '2010.11.05', 2);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `users_id`) VALUES (DEFAULT, 23, 'green', 2, 1, '2010.11.06', 2);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `users_id`) VALUES (DEFAULT, 3, 'black', 2, 7, '2010.04.09', 2);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `users_id`) VALUES (DEFAULT, 7, 'Lychee', 2, 3, '2012.03.22', 2);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `users_id`) VALUES (DEFAULT, 7, 'Earl Grey', 2, 3, '2012.01.19', 2);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `users_id`) VALUES (DEFAULT, 7, 'Strawberry tea', 2, 3, '2012.06.15', 2);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `users_id`) VALUES (DEFAULT, 7, 'Natural green tea', 2, 3, '2012.07.25', 2);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `users_id`) VALUES (DEFAULT, 21, 'finest tea', 2, 8, '2006.07.14', 2);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `users_id`) VALUES (DEFAULT, 17, 'smak natury', 2, 3, '2016.12.15', 2);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `users_id`) VALUES (DEFAULT, 5, 'history', 1, 11, '2008.04.14', 3);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `users_id`) VALUES (DEFAULT, 5, 'history', 1, 11, '2008.04.14', 3);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `users_id`) VALUES (DEFAULT, 5, 'history', 1, 11, '2008.04.14', 3);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `users_id`) VALUES (DEFAULT, 9, 'strawberry', 2, 7, '2011.06.30', 3);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `users_id`) VALUES (DEFAULT, 9, 'green tea', 1, 9, '2010.03.25', 3);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `users_id`) VALUES (DEFAULT, 9, 'black tea', 1, 11, '2007.12.15', 3);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `subtitle`, `material_id`, `width_x_height_id`, `in_collection_since`, `users_id`) VALUES (DEFAULT, 9, 'indian', 1, 9, '2010.05.04', 3);

COMMIT;

