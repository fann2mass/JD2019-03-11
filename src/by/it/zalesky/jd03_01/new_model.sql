-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema zalesky
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `zalesky` ;

-- -----------------------------------------------------
-- Schema zalesky
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `zalesky` DEFAULT CHARACTER SET utf8 ;
USE `zalesky` ;

-- -----------------------------------------------------
-- Table `zalesky`.`Roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `zalesky`.`Roles` ;

CREATE TABLE IF NOT EXISTS `zalesky`.`Roles` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(50) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zalesky`.`Users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `zalesky`.`Users` ;

CREATE TABLE IF NOT EXISTS `zalesky`.`Users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(100) NULL,
  `password` VARCHAR(100) NULL,
  `email` VARCHAR(100) NULL,
  `Roles_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_Roles`
    FOREIGN KEY (`Roles_id`)
    REFERENCES `zalesky`.`Roles` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zalesky`.`Category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `zalesky`.`Category` ;

CREATE TABLE IF NOT EXISTS `zalesky`.`Category` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`));


-- -----------------------------------------------------
-- Table `zalesky`.`Products`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `zalesky`.`Products` ;

CREATE TABLE IF NOT EXISTS `zalesky`.`Products` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(200) NULL,
  `discription` TEXT(200) NULL,
  `price` DECIMAL NULL,
  `Category_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_Products_Category1`
    FOREIGN KEY (`Category_id`)
    REFERENCES `zalesky`.`Category` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zalesky`.`Orders`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `zalesky`.`Orders` ;

CREATE TABLE IF NOT EXISTS `zalesky`.`Orders` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `product` VARCHAR(255) NULL,
  `price` DECIMAL NULL,
  `quantity` INT NOT NULL,
  `address` VARCHAR(100) NOT NULL,
  `postal_code` VARCHAR(45) NOT NULL,
  `Users_id` INT NOT NULL,
  `Products_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_Orders_Users1`
    FOREIGN KEY (`Users_id`)
    REFERENCES `zalesky`.`Users` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `fk_Orders_Products1`
    FOREIGN KEY (`Products_id`)
    REFERENCES `zalesky`.`Products` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `zalesky`.`Roles`
-- -----------------------------------------------------
START TRANSACTION;
USE `zalesky`;
INSERT INTO `zalesky`.`Roles` (`id`, `role`) VALUES (DEFAULT, 'Administrator');
INSERT INTO `zalesky`.`Roles` (`id`, `role`) VALUES (DEFAULT, 'User');
INSERT INTO `zalesky`.`Roles` (`id`, `role`) VALUES (DEFAULT, 'Guest');
INSERT INTO `zalesky`.`Roles` (`id`, `role`) VALUES (DEFAULT, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `zalesky`.`Users`
-- -----------------------------------------------------
START TRANSACTION;
USE `zalesky`;
INSERT INTO `zalesky`.`Users` (`id`, `login`, `password`, `email`, `Roles_id`) VALUES (DEFAULT, 'Administrator', 'admin', 'admin@t.by', 1);
INSERT INTO `zalesky`.`Users` (`id`, `login`, `password`, `email`, `Roles_id`) VALUES (DEFAULT, 'User', 'user', 'user@t.by', 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `zalesky`.`Category`
-- -----------------------------------------------------
START TRANSACTION;
USE `zalesky`;
INSERT INTO `zalesky`.`Category` (`id`, `name`) VALUES (DEFAULT, 'laptops');
INSERT INTO `zalesky`.`Category` (`id`, `name`) VALUES (DEFAULT, 'desktops');

COMMIT;


-- -----------------------------------------------------
-- Data for table `zalesky`.`Products`
-- -----------------------------------------------------
START TRANSACTION;
USE `zalesky`;
INSERT INTO `zalesky`.`Products` (`id`, `title`, `discription`, `price`, `Category_id`) VALUES (DEFAULT, 'Dell-Allienwar', 'Notebook', 2000, 1);
INSERT INTO `zalesky`.`Products` (`id`, `title`, `discription`, `price`, `Category_id`) VALUES (DEFAULT, 'HyperX-PC', 'Desktop', 2500, 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `zalesky`.`Orders`
-- -----------------------------------------------------
START TRANSACTION;
USE `zalesky`;
INSERT INTO `zalesky`.`Orders` (`id`, `product`, `price`, `quantity`, `address`, `postal_code`, `Users_id`, `Products_id`) VALUES (DEFAULT, 'Dell-Allienwar', 2000, 1, 'ул.Машерова 21', '98125', 2, 1);

COMMIT;

