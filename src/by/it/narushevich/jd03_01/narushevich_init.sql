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
-- Table `narushevich`.`country`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `narushevich`.`country` ;

CREATE TABLE IF NOT EXISTS `narushevich`.`country` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `country` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `narushevich`.`city`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `narushevich`.`city` ;

CREATE TABLE IF NOT EXISTS `narushevich`.`city` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `city` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `narushevich`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `narushevich`.`users` ;

CREATE TABLE IF NOT EXISTS `narushevich`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `roles_id` INT NOT NULL,
  `country_id` INT NOT NULL,
  `city_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_users_roles`
    FOREIGN KEY (`roles_id`)
    REFERENCES `narushevich`.`roles` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `fk_users_country1`
    FOREIGN KEY (`country_id`)
    REFERENCES `narushevich`.`country` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_users_city1`
    FOREIGN KEY (`city_id`)
    REFERENCES `narushevich`.`city` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
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
-- Table `narushevich`.`exchange`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `narushevich`.`exchange` ;

CREATE TABLE IF NOT EXISTS `narushevich`.`exchange` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `exchange` VARCHAR(3) NULL,
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
-- Table `narushevich`.`size`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `narushevich`.`size` ;

CREATE TABLE IF NOT EXISTS `narushevich`.`size` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `size` VARCHAR(10) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `narushevich`.`in collection since`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `narushevich`.`in collection since` ;

CREATE TABLE IF NOT EXISTS `narushevich`.`in collection since` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `in collection since` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `narushevich`.`teatags`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `narushevich`.`teatags` ;

CREATE TABLE IF NOT EXISTS `narushevich`.`teatags` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `trademark_id` INT NOT NULL,
  `name` VARCHAR(45) NULL,
  `country_id` INT NOT NULL,
  `material_id` INT NOT NULL,
  `size_id` INT NOT NULL,
  `in collection since_id` INT NOT NULL,
  `exchange_id` INT NOT NULL,
  `users_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_teatags_users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `narushevich`.`users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_teatags_country1`
    FOREIGN KEY (`country_id`)
    REFERENCES `narushevich`.`country` (`id`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_teatags_material1`
    FOREIGN KEY (`material_id`)
    REFERENCES `narushevich`.`material` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_teatags_exchange1`
    FOREIGN KEY (`exchange_id`)
    REFERENCES `narushevich`.`exchange` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_teatags_trademark1`
    FOREIGN KEY (`trademark_id`)
    REFERENCES `narushevich`.`trademark` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_teatags_size1`
    FOREIGN KEY (`size_id`)
    REFERENCES `narushevich`.`size` (`id`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `fk_teatags_in collection since1`
    FOREIGN KEY (`in collection since_id`)
    REFERENCES `narushevich`.`in collection since` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
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
-- Data for table `narushevich`.`country`
-- -----------------------------------------------------
START TRANSACTION;
USE `narushevich`;
INSERT INTO `narushevich`.`country` (`id`, `country`) VALUES (DEFAULT, 'Belarus');
INSERT INTO `narushevich`.`country` (`id`, `country`) VALUES (DEFAULT, 'Russia');
INSERT INTO `narushevich`.`country` (`id`, `country`) VALUES (DEFAULT, 'Poland');
INSERT INTO `narushevich`.`country` (`id`, `country`) VALUES (DEFAULT, 'France');
INSERT INTO `narushevich`.`country` (`id`, `country`) VALUES (DEFAULT, 'Chech Republic');
INSERT INTO `narushevich`.`country` (`id`, `country`) VALUES (DEFAULT, 'Germany');
INSERT INTO `narushevich`.`country` (`id`, `country`) VALUES (DEFAULT, 'Japan');
INSERT INTO `narushevich`.`country` (`id`, `country`) VALUES (DEFAULT, 'South Korea');
INSERT INTO `narushevich`.`country` (`id`, `country`) VALUES (DEFAULT, 'Siria');

COMMIT;


-- -----------------------------------------------------
-- Data for table `narushevich`.`city`
-- -----------------------------------------------------
START TRANSACTION;
USE `narushevich`;
INSERT INTO `narushevich`.`city` (`id`, `city`) VALUES (DEFAULT, 'Minsk');
INSERT INTO `narushevich`.`city` (`id`, `city`) VALUES (DEFAULT, 'Moscow');
INSERT INTO `narushevich`.`city` (`id`, `city`) VALUES (DEFAULT, 'Warsaw');
INSERT INTO `narushevich`.`city` (`id`, `city`) VALUES (DEFAULT, 'Paris');
INSERT INTO `narushevich`.`city` (`id`, `city`) VALUES (DEFAULT, 'Smolensk');

COMMIT;


-- -----------------------------------------------------
-- Data for table `narushevich`.`users`
-- -----------------------------------------------------
START TRANSACTION;
USE `narushevich`;
INSERT INTO `narushevich`.`users` (`id`, `login`, `password`, `email`, `roles_id`, `country_id`, `city_id`) VALUES (DEFAULT, 'masha_05', 'qwerty', 'masha_05@tut.by', 1, 1, 1);
INSERT INTO `narushevich`.`users` (`id`, `login`, `password`, `email`, `roles_id`, `country_id`, `city_id`) VALUES (DEFAULT, 'fr_pole', 'asdfgh', 'pol_zhan@gmail.com', 2, 4, 4);
INSERT INTO `narushevich`.`users` (`id`, `login`, `password`, `email`, `roles_id`, `country_id`, `city_id`) VALUES (DEFAULT, 'dimon_rus', 'wasder', 'dimas@mail.ru', 2, 2, 2);

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
-- Data for table `narushevich`.`exchange`
-- -----------------------------------------------------
START TRANSACTION;
USE `narushevich`;
INSERT INTO `narushevich`.`exchange` (`id`, `exchange`) VALUES (DEFAULT, 'no');
INSERT INTO `narushevich`.`exchange` (`id`, `exchange`) VALUES (DEFAULT, 'yes');

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
INSERT INTO `narushevich`.`trademark` (`id`, `trademark`) VALUES (DEFAULT, 'Jaf tea');
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
-- Data for table `narushevich`.`size`
-- -----------------------------------------------------
START TRANSACTION;
USE `narushevich`;
INSERT INTO `narushevich`.`size` (`id`, `size`) VALUES (DEFAULT, '20 x 20');
INSERT INTO `narushevich`.`size` (`id`, `size`) VALUES (DEFAULT, '20 x 24');
INSERT INTO `narushevich`.`size` (`id`, `size`) VALUES (DEFAULT, '20 x 28');
INSERT INTO `narushevich`.`size` (`id`, `size`) VALUES (DEFAULT, '21 x 22');
INSERT INTO `narushevich`.`size` (`id`, `size`) VALUES (DEFAULT, '22 x 22');
INSERT INTO `narushevich`.`size` (`id`, `size`) VALUES (DEFAULT, '23 x 28');
INSERT INTO `narushevich`.`size` (`id`, `size`) VALUES (DEFAULT, '25 x 28');
INSERT INTO `narushevich`.`size` (`id`, `size`) VALUES (DEFAULT, '25 x 30');
INSERT INTO `narushevich`.`size` (`id`, `size`) VALUES (DEFAULT, '26 x 28');
INSERT INTO `narushevich`.`size` (`id`, `size`) VALUES (DEFAULT, '27 x 27');
INSERT INTO `narushevich`.`size` (`id`, `size`) VALUES (DEFAULT, '28 x 32');

COMMIT;


-- -----------------------------------------------------
-- Data for table `narushevich`.`in collection since`
-- -----------------------------------------------------
START TRANSACTION;
USE `narushevich`;
INSERT INTO `narushevich`.`in collection since` (`id`, `in collection since`) VALUES (DEFAULT, '1998');
INSERT INTO `narushevich`.`in collection since` (`id`, `in collection since`) VALUES (DEFAULT, '1999');
INSERT INTO `narushevich`.`in collection since` (`id`, `in collection since`) VALUES (DEFAULT, '2000');
INSERT INTO `narushevich`.`in collection since` (`id`, `in collection since`) VALUES (DEFAULT, '2001');
INSERT INTO `narushevich`.`in collection since` (`id`, `in collection since`) VALUES (DEFAULT, '2002');
INSERT INTO `narushevich`.`in collection since` (`id`, `in collection since`) VALUES (DEFAULT, '2003');
INSERT INTO `narushevich`.`in collection since` (`id`, `in collection since`) VALUES (DEFAULT, '2004');
INSERT INTO `narushevich`.`in collection since` (`id`, `in collection since`) VALUES (DEFAULT, '2005');
INSERT INTO `narushevich`.`in collection since` (`id`, `in collection since`) VALUES (DEFAULT, '2006');
INSERT INTO `narushevich`.`in collection since` (`id`, `in collection since`) VALUES (DEFAULT, '2007');
INSERT INTO `narushevich`.`in collection since` (`id`, `in collection since`) VALUES (DEFAULT, '2008');
INSERT INTO `narushevich`.`in collection since` (`id`, `in collection since`) VALUES (DEFAULT, '2009');
INSERT INTO `narushevich`.`in collection since` (`id`, `in collection since`) VALUES (DEFAULT, '2010');
INSERT INTO `narushevich`.`in collection since` (`id`, `in collection since`) VALUES (DEFAULT, '2011');
INSERT INTO `narushevich`.`in collection since` (`id`, `in collection since`) VALUES (DEFAULT, '2012');
INSERT INTO `narushevich`.`in collection since` (`id`, `in collection since`) VALUES (DEFAULT, '2013');
INSERT INTO `narushevich`.`in collection since` (`id`, `in collection since`) VALUES (DEFAULT, '2014');
INSERT INTO `narushevich`.`in collection since` (`id`, `in collection since`) VALUES (DEFAULT, '2015');
INSERT INTO `narushevich`.`in collection since` (`id`, `in collection since`) VALUES (DEFAULT, '2016');
INSERT INTO `narushevich`.`in collection since` (`id`, `in collection since`) VALUES (DEFAULT, '2017');
INSERT INTO `narushevich`.`in collection since` (`id`, `in collection since`) VALUES (DEFAULT, '2018');
INSERT INTO `narushevich`.`in collection since` (`id`, `in collection since`) VALUES (DEFAULT, '2019');
INSERT INTO `narushevich`.`in collection since` (`id`, `in collection since`) VALUES (DEFAULT, '2020');
INSERT INTO `narushevich`.`in collection since` (`id`, `in collection since`) VALUES (DEFAULT, '2021');
INSERT INTO `narushevich`.`in collection since` (`id`, `in collection since`) VALUES (DEFAULT, '2022');

COMMIT;


-- -----------------------------------------------------
-- Data for table `narushevich`.`teatags`
-- -----------------------------------------------------
START TRANSACTION;
USE `narushevich`;
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 1, 'English Tea #1', 1, 1, 11, 20, 1, 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 1, 'Cinnamon Haze', 3, 1, 11, 21, 1, 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 1, 'Earl Grey', 1, 1, 11, 5, 1, 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 1, 'Earl Grey', 1, 1, 11, 8, 1, 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 1, 'Green Tea', 1, 1, 11, 11, 1, 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 1, 'English Breakfast', 1, 1, 11, 4, 1, 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 1, 'English Breakfast', 1, 1, 11, 1, 1, 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 1, 'Lemon & Lime Twist', 3, 1, 11, 21, 1, 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 1, 'Classic black tea', 1, 1, 11, 16, 2, 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 13, 'Yellow Label tea', 1, 1, 11, 15, 1, 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 13, 'Yellow Label tea', 1, 1, 11, 8, 1, 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 13, 'Royal Ceylon', 1, 1, 11, 6, 1, 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 13, 'A moment to energise', 3, 1, 9, 20, 1, 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 13, 'A moment to balance', 3, 1, 9, 20, 1, 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 13, 'pure black ceylon', 1, 2, 5, 10, 1, 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 13, 'cherry morello', 1, 2, 5, 10, 1, 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 13, 'pear chocolate', 1, 2, 5, 10, 1, 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 13, 'flirty lady', 1, 2, 1, 18, 1, 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 13, 'blue fruit', 1, 2, 5, 14, 1, 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 13, 'Orange Jaipur', 1, 2, 5, 9, 1, 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 11, 'temptation', 1, 1, 6, 4, 1, 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 10, 'finelly selected speciality tea', 1, 2, 3, 6, 1, 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 22, 'black', 1, 2, 3, 3, 1, 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 20, 'La via del te firenze', 1, 2, 3, 8, 2, 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 19, 'Cristmas tea', 5, 1, 6, 20, 1, 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 6, '100% pure ceylon tea', 1, 1, 11, 6, 1, 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 4, 'Black tea', 3, 1, 11, 21, 1, 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 13, 'Russian Earl Grey', 2, 1, 8, 13, 1, 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 2, 'English breakfast', 1, 1, 11, 10, 1, 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 2, 'flavoured tea', 1, 1, 11, 14, 1, 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 14, 'Lemon & Ginger', 3, 1, 11, 18, 1, 1);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 8, '2006', 4, 2, 3, 11, 1, 3);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 15, '1001 night', 4, 2, 3, 13, 1, 3);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 16, 'Noir', 4, 2, 6, 5, 1, 3);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 18, 'Zitrone', 6, 1, 11, 12, 1, 3);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 12, 'Green tea bags', 7, 2, 7, 13, 1, 3);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 23, 'green', 8, 2, 1, 13, 1, 3);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 3, 'black', 9, 2, 7, 13, 2, 3);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 7, 'Lychee', 2, 2, 3, 15, 1, 3);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 7, 'Earl Grey', 2, 2, 3, 15, 1, 3);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 7, 'Strawberry tea', 2, 2, 3, 15, 1, 3);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 7, 'Natural green tea', 2, 2, 3, 15, 1, 3);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 21, 'finest tea', 1, 2, 8, 9, 1, 3);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 17, 'smak natury', 3, 2, 3, 19, 1, 3);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 5, 'history', 2, 1, 11, 11, 1, 2);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 5, 'history', 2, 1, 11, 12, 1, 2);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 5, 'history', 2, 1, 11, 12, 1, 2);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 9, 'strawberry', 2, 2, 7, 14, 1, 2);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 9, 'green tea', 2, 1, 9, 13, 1, 2);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 9, 'black tea', 2, 1, 11, 10, 1, 2);
INSERT INTO `narushevich`.`teatags` (`id`, `trademark_id`, `name`, `country_id`, `material_id`, `size_id`, `in collection since_id`, `exchange_id`, `users_id`) VALUES (DEFAULT, 9, 'indian', 2, 1, 9, 13, 1, 2);

COMMIT;

