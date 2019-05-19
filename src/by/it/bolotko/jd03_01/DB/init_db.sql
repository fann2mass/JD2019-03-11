-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema bolotko
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `bolotko` ;

-- -----------------------------------------------------
-- Schema bolotko
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bolotko` DEFAULT CHARACTER SET utf8 ;
USE `bolotko` ;

-- -----------------------------------------------------
-- Table `bolotko`.`roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bolotko`.`roles` ;

CREATE TABLE IF NOT EXISTS `bolotko`.`roles` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(100) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bolotko`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bolotko`.`users` ;

CREATE TABLE IF NOT EXISTS `bolotko`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(100) NULL,
  `password` VARCHAR(100) NULL,
  `email` VARCHAR(100) NULL,
  `phone` VARCHAR(20) NULL,
  `roles_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_users_roles`
    FOREIGN KEY (`roles_id`)
    REFERENCES `bolotko`.`roles` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bolotko`.`cars`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `bolotko`.`cars` ;

CREATE TABLE IF NOT EXISTS `bolotko`.`cars` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `car_type` VARCHAR(100) NULL,
  `mark` VARCHAR(100) NULL,
  `model` VARCHAR(100) NULL,
  `year_of_issue` VARCHAR(100) NULL,
  `fuel_type` VARCHAR(100) NULL,
  `price` DOUBLE NULL,
  `users_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_cars_users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `bolotko`.`users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `bolotko`.`roles`
-- -----------------------------------------------------
START TRANSACTION;
USE `bolotko`;
INSERT INTO `bolotko`.`roles` (`id`, `role`) VALUES (DEFAULT, 'admin');
INSERT INTO `bolotko`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user');
INSERT INTO `bolotko`.`roles` (`id`, `role`) VALUES (DEFAULT, 'moderator');
INSERT INTO `bolotko`.`roles` (`id`, `role`) VALUES (DEFAULT, 'guest');

COMMIT;


-- -----------------------------------------------------
-- Data for table `bolotko`.`users`
-- -----------------------------------------------------
START TRANSACTION;
USE `bolotko`;
INSERT INTO `bolotko`.`users` (`id`, `login`, `password`, `email`, `phone`, `roles_id`) VALUES (DEFAULT, 'administrator', 'qwerty', 'kostja100pro@gmail.com', '+375(29)7326543', 1);
INSERT INTO `bolotko`.`users` (`id`, `login`, `password`, `email`, `phone`, `roles_id`) VALUES (DEFAULT, 'nikolaj', 'jalokin', 'nikolajab@mail.ru', '+375(33)5897326', 2);
INSERT INTO `bolotko`.`users` (`id`, `login`, `password`, `email`, `phone`, `roles_id`) VALUES (DEFAULT, 'dinis', 'sinid', 'dinis228@gmail.com', '+375(44)2417438', 2);
INSERT INTO `bolotko`.`users` (`id`, `login`, `password`, `email`, `phone`, `roles_id`) VALUES (DEFAULT, 'moderator1', 'rotaredom1', 'moderator1@gmail.com', '+375(29)7634920', 3);
INSERT INTO `bolotko`.`users` (`id`, `login`, `password`, `email`, `phone`, `roles_id`) VALUES (DEFAULT, 'moderator2', 'rotaredom2', 'moderator2@gmail.com', '+375(29)7634921', 3);
INSERT INTO `bolotko`.`users` (`id`, `login`, `password`, `email`, `phone`, `roles_id`) VALUES (DEFAULT, 'user1', '0000', 'test1@yandex.ru', '+375(29)7634900', 4);
INSERT INTO `bolotko`.`users` (`id`, `login`, `password`, `email`, `phone`, `roles_id`) VALUES (DEFAULT, 'user2', '0000', 'test2@yandex.ru', '+375(29)7634900', 4);
INSERT INTO `bolotko`.`users` (`id`, `login`, `password`, `email`, `phone`, `roles_id`) VALUES (DEFAULT, 'maksim', 'miskam', 'maksim1997@mail.ru', '+375(33)5356226', 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `bolotko`.`cars`
-- -----------------------------------------------------
START TRANSACTION;
USE `bolotko`;
INSERT INTO `bolotko`.`cars` (`id`, `car_type`, `mark`, `model`, `year_of_issue`, `fuel_type`, `price`, `users_id`) VALUES (DEFAULT, 'passenger', 'Audi', 'A4', '1998', 'gasoline', 4395, 2);
INSERT INTO `bolotko`.`cars` (`id`, `car_type`, `mark`, `model`, `year_of_issue`, `fuel_type`, `price`, `users_id`) VALUES (DEFAULT, 'passenger', 'BMW', 'M5', '2008', 'gasoline', 26470, 2);
INSERT INTO `bolotko`.`cars` (`id`, `car_type`, `mark`, `model`, `year_of_issue`, `fuel_type`, `price`, `users_id`) VALUES (DEFAULT, 'truck', 'Avia', 'A21', '1987', 'diesel', 799, 3);
INSERT INTO `bolotko`.`cars` (`id`, `car_type`, `mark`, `model`, `year_of_issue`, `fuel_type`, `price`, `users_id`) VALUES (DEFAULT, 'passenger', 'Dacia', 'Logan', '2008', 'gasoline', 3602, 8);
INSERT INTO `bolotko`.`cars` (`id`, `car_type`, `mark`, `model`, `year_of_issue`, `fuel_type`, `price`, `users_id`) VALUES (DEFAULT, 'truck', 'KIA', 'K2500', '2015', 'diesel', 13636, 8);

COMMIT;

