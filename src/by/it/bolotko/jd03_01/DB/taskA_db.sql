-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema TaskA
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `TaskA` ;

-- -----------------------------------------------------
-- Schema TaskA
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `TaskA` DEFAULT CHARACTER SET utf8 ;
USE `TaskA` ;

-- -----------------------------------------------------
-- Table `TaskA`.`roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `TaskA`.`roles` ;

CREATE TABLE IF NOT EXISTS `TaskA`.`roles` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(100) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TaskA`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `TaskA`.`users` ;

CREATE TABLE IF NOT EXISTS `TaskA`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user` VARCHAR(100) NULL,
  `roles_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_users_roles1`
    FOREIGN KEY (`roles_id`)
    REFERENCES `TaskA`.`roles` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TaskA`.`cars`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `TaskA`.`cars` ;

CREATE TABLE IF NOT EXISTS `TaskA`.`cars` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `car` VARCHAR(100) NULL,
  `users_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_cars_users`
    FOREIGN KEY (`users_id`)
    REFERENCES `TaskA`.`users` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TaskA`.`information`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `TaskA`.`information` ;

CREATE TABLE IF NOT EXISTS `TaskA`.`information` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `model` VARCHAR(100) NULL,
  `colour` VARCHAR(100) NULL,
  `price` VARCHAR(100) NULL,
  `cars_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_information_cars1`
    FOREIGN KEY (`cars_id`)
    REFERENCES `TaskA`.`cars` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
