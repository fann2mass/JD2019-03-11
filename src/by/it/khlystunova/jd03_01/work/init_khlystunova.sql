-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema khlystunova
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `khlystunova` ;

-- -----------------------------------------------------
-- Schema khlystunova
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `khlystunova` DEFAULT CHARACTER SET utf8 ;
USE `khlystunova` ;

-- -----------------------------------------------------
-- Table `khlystunova`.`roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `khlystunova`.`roles` ;

CREATE TABLE IF NOT EXISTS `khlystunova`.`roles` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Role` VARCHAR(50) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `khlystunova`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `khlystunova`.`users` ;

CREATE TABLE IF NOT EXISTS `khlystunova`.`users` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Login` VARCHAR(45) NULL,
  `Password` VARCHAR(45) NULL,
  `Email` VARCHAR(45) NULL,
  `roles_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `fk_users_roles`
    FOREIGN KEY (`roles_ID`)
    REFERENCES `khlystunova`.`roles` (`ID`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `khlystunova`.`coffemachines`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `khlystunova`.`coffemachines` ;

CREATE TABLE IF NOT EXISTS `khlystunova`.`coffemachines` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(50) NULL,
  `Firm` VARCHAR(50) NULL,
  `Type` VARCHAR(45) NULL,
  `Power` INT NULL,
  `Size` VARCHAR(50) NULL,
  `Weight` DOUBLE NULL,
  `Steam` VARCHAR(45) NULL,
  `WaterContainer` VARCHAR(45) NULL,
  `BeansContainer` VARCHAR(45) NULL,
  `Color` VARCHAR(45) NULL,
  `Price` DOUBLE NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `khlystunova`.`requests`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `khlystunova`.`requests` ;

CREATE TABLE IF NOT EXISTS `khlystunova`.`requests` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Contact` VARCHAR(45) NULL,
  `DeliveryAdress` VARCHAR(50) NULL,
  `DeliveryMethod` VARCHAR(45) NULL,
  `MethodPayment` VARCHAR(45) NULL,
  `users_ID` INT NOT NULL,
  `coffemachines_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `fk_requests_users1`
    FOREIGN KEY (`users_ID`)
    REFERENCES `khlystunova`.`users` (`ID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_requests_coffemachines1`
    FOREIGN KEY (`coffemachines_ID`)
    REFERENCES `khlystunova`.`coffemachines` (`ID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `khlystunova`.`roles`
-- -----------------------------------------------------
START TRANSACTION;
USE `khlystunova`;
INSERT INTO `khlystunova`.`roles` (`ID`, `Role`) VALUES (1, 'Administrator');
INSERT INTO `khlystunova`.`roles` (`ID`, `Role`) VALUES (2, 'User');
INSERT INTO `khlystunova`.`roles` (`ID`, `Role`) VALUES (3, 'Guest');

COMMIT;


-- -----------------------------------------------------
-- Data for table `khlystunova`.`users`
-- -----------------------------------------------------
START TRANSACTION;
USE `khlystunova`;
INSERT INTO `khlystunova`.`users` (`ID`, `Login`, `Password`, `Email`, `roles_ID`) VALUES (DEFAULT, 'admin', 'padmin', 'admin@gmail.com', 1);
INSERT INTO `khlystunova`.`users` (`ID`, `Login`, `Password`, `Email`, `roles_ID`) VALUES (DEFAULT, 'Petrov', 'puser', 'user@gmail.com', 2);
INSERT INTO `khlystunova`.`users` (`ID`, `Login`, `Password`, `Email`, `roles_ID`) VALUES (DEFAULT, 'Sidorov', 'psidorov', 'sidorov@mail.ru', 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `khlystunova`.`coffemachines`
-- -----------------------------------------------------
START TRANSACTION;
USE `khlystunova`;
INSERT INTO `khlystunova`.`coffemachines` (`ID`, `Name`, `Firm`, `Type`, `Power`, `Size`, `Weight`, `Steam`, `WaterContainer`, `BeansContainer`, `Color`, `Price`) VALUES (DEFAULT, 'LC/D', 'GAGIA', 'professional ', 1600, '625x472x510 ', 49.3, 'Panarello', '13 l', '7 l', 'Metalic', 5650);
INSERT INTO `khlystunova`.`coffemachines` (`ID`, `Name`, `Firm`, `Type`, `Power`, `Size`, `Weight`, `Steam`, `WaterContainer`, `BeansContainer`, `Color`, `Price`) VALUES (DEFAULT, 'GE-GD ONE', 'GAGIA', 'professional ', 1200, '530x550x420 ', 30.4, 'Panarello', '2,3 l', '2 l', 'Red', 4620);

COMMIT;


-- -----------------------------------------------------
-- Data for table `khlystunova`.`requests`
-- -----------------------------------------------------
START TRANSACTION;
USE `khlystunova`;
INSERT INTO `khlystunova`.`requests` (`ID`, `Contact`, `DeliveryAdress`, `DeliveryMethod`, `MethodPayment`, `users_ID`, `coffemachines_ID`) VALUES (DEFAULT, '+375293455837', 'Frolova27f3', 'pickup', 'cash', 2, 1);
INSERT INTO `khlystunova`.`requests` (`ID`, `Contact`, `DeliveryAdress`, `DeliveryMethod`, `MethodPayment`, `users_ID`, `coffemachines_ID`) VALUES (DEFAULT, '+375296256313', 'Pr.Mira27b12', 'courier', 'card', 3, 2);

COMMIT;

