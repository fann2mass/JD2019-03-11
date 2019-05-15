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
CREATE TABLE IF NOT EXISTS `narushevich`.`roles` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `narushevich`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `narushevich`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `location` VARCHAR(45) NULL,
  `roles_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_users_roles`
    FOREIGN KEY (`roles_id`)
    REFERENCES `narushevich`.`roles` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `narushevich`.`teatags`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `narushevich`.`teatags` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `trademark` VARCHAR(45) NULL,
  `country` VARCHAR(45) NULL,
  `material` VARCHAR(45) NULL,
  `size` DECIMAL NULL,
  `incollectionsince` INT NULL,
  `exchange` TINYINT NULL,
  `users_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_teatags_users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `narushevich`.`users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
