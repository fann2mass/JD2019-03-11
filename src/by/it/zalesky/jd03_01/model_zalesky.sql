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
-- Table `zalesky`.`roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `zalesky`.`roles` ;

CREATE TABLE IF NOT EXISTS `zalesky`.`roles` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(100) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zalesky`.`customers`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `zalesky`.`customers` ;

CREATE TABLE IF NOT EXISTS `zalesky`.`customers` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `ContactName` VARCHAR(100) NULL,
  `CompanyName` VARCHAR(100) NULL,
  `Phone` DOUBLE NULL,
  `roles_id` INT NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `fk_customers_roles`
    FOREIGN KEY (`roles_id`)
    REFERENCES `zalesky`.`roles` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `zalesky`.`orders`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `zalesky`.`orders` ;

CREATE TABLE IF NOT EXISTS `zalesky`.`orders` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Adress` VARCHAR(200) NULL,
  `City` VARCHAR(100) NULL,
  `Region` VARCHAR(100) NULL,
  `PostalCode` INT NULL,
  `Country` VARCHAR(50) NULL,
  `Price` INT NULL,
  `customers_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `fk_orders_customers1`
    FOREIGN KEY (`customers_ID`)
    REFERENCES `zalesky`.`customers` (`ID`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `zalesky`.`roles`
-- -----------------------------------------------------
START TRANSACTION;
USE `zalesky`;
INSERT INTO `zalesky`.`roles` (`id`, `role`) VALUES (DEFAULT, 'admin');
INSERT INTO `zalesky`.`roles` (`id`, `role`) VALUES (DEFAULT, 'user');
INSERT INTO `zalesky`.`roles` (`id`, `role`) VALUES (DEFAULT, 'moderator');
INSERT INTO `zalesky`.`roles` (`id`, `role`) VALUES (DEFAULT, 'guest');

COMMIT;


-- -----------------------------------------------------
-- Data for table `zalesky`.`customers`
-- -----------------------------------------------------
START TRANSACTION;
USE `zalesky`;
INSERT INTO `zalesky`.`customers` (`ID`, `ContactName`, `CompanyName`, `Phone`, `roles_id`) VALUES (DEFAULT, 'Derec', 'Bob\'s Heating', 5035557555, 1);
INSERT INTO `zalesky`.`customers` (`ID`, `ContactName`, `CompanyName`, `Phone`, `roles_id`) VALUES (DEFAULT, 'Peter', 'Deck Guru', 5095556221, 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `zalesky`.`orders`
-- -----------------------------------------------------
START TRANSACTION;
USE `zalesky`;
INSERT INTO `zalesky`.`orders` (`ID`, `Adress`, `City`, `Region`, `PostalCode`, `Country`, `Price`, `customers_ID`) VALUES (DEFAULT, '2732 Baker Blvd', 'Everett', 'WA', 97403, 'USA', 750, 2);

COMMIT;

