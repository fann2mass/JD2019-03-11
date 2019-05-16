-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema eslaikouskaya
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `eslaikouskaya` ;

-- -----------------------------------------------------
-- Schema eslaikouskaya
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `eslaikouskaya` DEFAULT CHARACTER SET utf8 ;
USE `eslaikouskaya` ;

-- -----------------------------------------------------
-- Table `eslaikouskaya`.`roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `eslaikouskaya`.`roles` ;

CREATE TABLE IF NOT EXISTS `eslaikouskaya`.`roles` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Role` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eslaikouskaya`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `eslaikouskaya`.`users` ;

CREATE TABLE IF NOT EXISTS `eslaikouskaya`.`users` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Login` VARCHAR(45) NULL,
  `Password` VARCHAR(45) NULL,
  `Email` VARCHAR(45) NULL,
  `roles_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `fk_users_roles`
    FOREIGN KEY (`roles_ID`)
    REFERENCES `eslaikouskaya`.`roles` (`ID`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eslaikouskaya`.`categories`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `eslaikouskaya`.`categories` ;

CREATE TABLE IF NOT EXISTS `eslaikouskaya`.`categories` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Category` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eslaikouskaya`.`classes`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `eslaikouskaya`.`classes` ;

CREATE TABLE IF NOT EXISTS `eslaikouskaya`.`classes` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Class` VARCHAR(45) NULL,
  `categories_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `fk_classes_categories1`
    FOREIGN KEY (`categories_ID`)
    REFERENCES `eslaikouskaya`.`categories` (`ID`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eslaikouskaya`.`materials`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `eslaikouskaya`.`materials` ;

CREATE TABLE IF NOT EXISTS `eslaikouskaya`.`materials` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NULL,
  `Price` VARCHAR(45) NULL,
  `classes_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `fk_materials_classes1`
    FOREIGN KEY (`classes_ID`)
    REFERENCES `eslaikouskaya`.`classes` (`ID`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `eslaikouskaya`.`purchases`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `eslaikouskaya`.`purchases` ;

CREATE TABLE IF NOT EXISTS `eslaikouskaya`.`purchases` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `users_ID` INT NOT NULL,
  `materials_ID` INT NOT NULL,
  `Number` INT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `fk_purchases_users1`
    FOREIGN KEY (`users_ID`)
    REFERENCES `eslaikouskaya`.`users` (`ID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_purchases_materials1`
    FOREIGN KEY (`materials_ID`)
    REFERENCES `eslaikouskaya`.`materials` (`ID`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `eslaikouskaya`.`roles`
-- -----------------------------------------------------
START TRANSACTION;
USE `eslaikouskaya`;
INSERT INTO `eslaikouskaya`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'Administrator');
INSERT INTO `eslaikouskaya`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'Manager');
INSERT INTO `eslaikouskaya`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'Guest');
INSERT INTO `eslaikouskaya`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'User');

COMMIT;


-- -----------------------------------------------------
-- Data for table `eslaikouskaya`.`users`
-- -----------------------------------------------------
START TRANSACTION;
USE `eslaikouskaya`;
INSERT INTO `eslaikouskaya`.`users` (`ID`, `Login`, `Password`, `Email`, `roles_ID`) VALUES (DEFAULT, 'Katya1234', 'qwerty', 'K@gmail.com', 1);
INSERT INTO `eslaikouskaya`.`users` (`ID`, `Login`, `Password`, `Email`, `roles_ID`) VALUES (DEFAULT, 'Pavel13', 'asdfgh', 'Pav@tut.by', 2);
INSERT INTO `eslaikouskaya`.`users` (`ID`, `Login`, `Password`, `Email`, `roles_ID`) VALUES (DEFAULT, 'AbrahamZERO', '123qwe', 'Azero@mail.ru', 3);
INSERT INTO `eslaikouskaya`.`users` (`ID`, `Login`, `Password`, `Email`, `roles_ID`) VALUES (DEFAULT, 'Lily_33', 'qazwsx', 'LilPop@mail.ru', 4);
INSERT INTO `eslaikouskaya`.`users` (`ID`, `Login`, `Password`, `Email`, `roles_ID`) VALUES (DEFAULT, 'Sharki07', '1029384756', 'Shark@gmail.com', 4);

COMMIT;


-- -----------------------------------------------------
-- Data for table `eslaikouskaya`.`categories`
-- -----------------------------------------------------
START TRANSACTION;
USE `eslaikouskaya`;
INSERT INTO `eslaikouskaya`.`categories` (`ID`, `Category`) VALUES (DEFAULT, 'Sanitary');
INSERT INTO `eslaikouskaya`.`categories` (`ID`, `Category`) VALUES (DEFAULT, 'Metal rolling');
INSERT INTO `eslaikouskaya`.`categories` (`ID`, `Category`) VALUES (DEFAULT, 'Building materials');
INSERT INTO `eslaikouskaya`.`categories` (`ID`, `Category`) VALUES (DEFAULT, 'Roof');

COMMIT;


-- -----------------------------------------------------
-- Data for table `eslaikouskaya`.`classes`
-- -----------------------------------------------------
START TRANSACTION;
USE `eslaikouskaya`;
INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Polipropilen pipeline system', 1);
INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Steel pipe billet', 1);
INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Valve', 1);
INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Fastener', 1);
INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Radiator and heating system', 1);
INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Polyethylene pipe', 1);
INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Asbestos-cement pipe', 1);
INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Plumbing equipment', 1);
INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Sealing materials and stuff', 1);
INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Pipes sewer PVC and NPVH', 1);
INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Corner', 2);
INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Grooved fittings', 2);
INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Round tube', 2);
INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Strip', 2);
INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Profile pipe', 2);
INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Sheet', 2);
INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Knitting wire', 2);
INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Channel', 2);
INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Smooth circle', 2);
INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Square', 2);
INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Gas silicate blocks', 3);
INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Brick', 3);
INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Polycarbonate', 3);
INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Drywall and Hardware', 3);
INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Cement and mortar', 3);
INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Chipboard', 3);
INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Grid', 3);
INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Well ring', 3);
INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Pavement tile curb', 3);
INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Thermal insulation', 3);
INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Guided roofing', 4);
INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Slate', 4);
INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Shingles', 4);
INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Ondulin and accessories', 4);
INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Metal profile', 4);
INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Under-roof film', 4);

COMMIT;


-- -----------------------------------------------------
-- Data for table `eslaikouskaya`.`materials`
-- -----------------------------------------------------
START TRANSACTION;
USE `eslaikouskaya`;
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Gray reinforced pipes', '20', 1);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Squares', '10', 1);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Clutch', '15', 1);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Americans', '15', 1);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Tee', '17', 1);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Support зшзу', '18', 1);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Crane', '13', 1);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Polypropylene filter', '10', 1);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Drives', '30', 2);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Threads', '31', 2);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Locknuts', '35', 2);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Couplings', '18', 2);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Kegs', '10', 2);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Barrel', '12', 2);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Squares', '27', 2);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Tee', '25', 2);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Bends', '23', 2);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Black steel billet', '23', 2);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Galvanized steel billet', '24', 2);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Ball valves', '25', 3);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Coupling taps', '18', 3);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Flanged cranes', '8', 3);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Gate Valves', '34', 3);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Entili', '19', 3);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Filters', '30', 3);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Check Valves', '20', 3);
INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Flanges to Check Valves', '21', 3);

COMMIT;


-- -----------------------------------------------------
-- Data for table `eslaikouskaya`.`purchases`
-- -----------------------------------------------------
START TRANSACTION;
USE `eslaikouskaya`;
INSERT INTO `eslaikouskaya`.`purchases` (`ID`, `users_ID`, `materials_ID`, `Number`) VALUES (DEFAULT, 3, 15, 3);
INSERT INTO `eslaikouskaya`.`purchases` (`ID`, `users_ID`, `materials_ID`, `Number`) VALUES (DEFAULT, 3, 1, 3);
INSERT INTO `eslaikouskaya`.`purchases` (`ID`, `users_ID`, `materials_ID`, `Number`) VALUES (DEFAULT, 4, 12, 10);
INSERT INTO `eslaikouskaya`.`purchases` (`ID`, `users_ID`, `materials_ID`, `Number`) VALUES (DEFAULT, 4, 13, 1);
INSERT INTO `eslaikouskaya`.`purchases` (`ID`, `users_ID`, `materials_ID`, `Number`) VALUES (DEFAULT, 4, 14, 2);
INSERT INTO `eslaikouskaya`.`purchases` (`ID`, `users_ID`, `materials_ID`, `Number`) VALUES (DEFAULT, 5, 8, 1);
INSERT INTO `eslaikouskaya`.`purchases` (`ID`, `users_ID`, `materials_ID`, `Number`) VALUES (DEFAULT, 5, 3, 1);
INSERT INTO `eslaikouskaya`.`purchases` (`ID`, `users_ID`, `materials_ID`, `Number`) VALUES (DEFAULT, 5, 4, 15);

COMMIT;

