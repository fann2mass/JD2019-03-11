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
-- Table `khlystunova`.`firm`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `khlystunova`.`firm` ;

CREATE TABLE IF NOT EXISTS `khlystunova`.`firm` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `firm` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `khlystunova`.`steam`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `khlystunova`.`steam` ;

CREATE TABLE IF NOT EXISTS `khlystunova`.`steam` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Steam` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `khlystunova`.`coffemachines`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `khlystunova`.`coffemachines` ;

CREATE TABLE IF NOT EXISTS `khlystunova`.`coffemachines` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(50) NULL,
  `firm_ID` INT NOT NULL,
  `Power` INT NULL,
  `Size` VARCHAR(50) NULL,
  `Weight` DOUBLE NULL,
  `steam_ID` INT NOT NULL,
  `WaterContainer` VARCHAR(45) NULL,
  `BeansContainer` VARCHAR(45) NULL,
  `Color` VARCHAR(45) NULL,
  `Price` DOUBLE NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `fk_coffemachines_firm1`
    FOREIGN KEY (`firm_ID`)
    REFERENCES `khlystunova`.`firm` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_coffemachines_steam1`
    FOREIGN KEY (`steam_ID`)
    REFERENCES `khlystunova`.`steam` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `khlystunova`.`requests`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `khlystunova`.`requests` ;

CREATE TABLE IF NOT EXISTS `khlystunova`.`requests` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `users_ID` INT NOT NULL,
  `Contact` VARCHAR(45) NULL,
  `DeliveryAddress` VARCHAR(50) NULL,
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
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
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
-- Data for table `khlystunova`.`firm`
-- -----------------------------------------------------
START TRANSACTION;
USE `khlystunova`;
INSERT INTO `khlystunova`.`firm` (`ID`, `firm`) VALUES (DEFAULT, 'Gagia');
INSERT INTO `khlystunova`.`firm` (`ID`, `firm`) VALUES (DEFAULT, 'Italic');

COMMIT;


-- -----------------------------------------------------
-- Data for table `khlystunova`.`steam`
-- -----------------------------------------------------
START TRANSACTION;
USE `khlystunova`;
INSERT INTO `khlystunova`.`steam` (`ID`, `Steam`) VALUES (DEFAULT, 'automatic');
INSERT INTO `khlystunova`.`steam` (`ID`, `Steam`) VALUES (DEFAULT, 'autonomy');
INSERT INTO `khlystunova`.`steam` (`ID`, `Steam`) VALUES (DEFAULT, 'panarello');

COMMIT;


-- -----------------------------------------------------
-- Data for table `khlystunova`.`coffemachines`
-- -----------------------------------------------------
START TRANSACTION;
USE `khlystunova`;
INSERT INTO `khlystunova`.`coffemachines` (`ID`, `Name`, `firm_ID`, `Power`, `Size`, `Weight`, `steam_ID`, `WaterContainer`, `BeansContainer`, `Color`, `Price`) VALUES (DEFAULT, 'LC/D', 1, 1600, '625x472x510 ', 49.3, 1, '13 l', '7 l', 'Metalic', 5650);
INSERT INTO `khlystunova`.`coffemachines` (`ID`, `Name`, `firm_ID`, `Power`, `Size`, `Weight`, `steam_ID`, `WaterContainer`, `BeansContainer`, `Color`, `Price`) VALUES (DEFAULT, 'GE-GD ONE', 2, 1200, '530x550x420 ', 30.4, 2, '2,3 l', '2 l', 'Red', 4620);

COMMIT;


-- -----------------------------------------------------
-- Data for table `khlystunova`.`requests`
-- -----------------------------------------------------
START TRANSACTION;
USE `khlystunova`;
INSERT INTO `khlystunova`.`requests` (`ID`, `users_ID`, `Contact`, `DeliveryAddress`, `coffemachines_ID`) VALUES (DEFAULT, 2, '+375293455837', 'Frolova27f3', 1);
INSERT INTO `khlystunova`.`requests` (`ID`, `users_ID`, `Contact`, `DeliveryAddress`, `coffemachines_ID`) VALUES (DEFAULT, 3, '+375296256313', 'Pr.Mira27b12', 2);

COMMIT;

