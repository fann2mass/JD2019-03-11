package by.it.eslaikouskaya.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class C_Init {

	private static final String URL = "jdbc:mysql://127.0.0.1:3306/";
	private static final String USER = "root";
	private static final String PASSWORD = "qwerty123456";

	public static void main(String[] args) throws SQLException {
		try (
				Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
				Statement statement = connection.createStatement()
		) {
			statement.executeUpdate("DROP SCHEMA IF EXISTS `eslaikouskaya`");
			statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `eslaikouskaya` DEFAULT CHARACTER SET utf8 ;");
			statement.executeUpdate("CREATE TABLE IF NOT EXISTS `eslaikouskaya`.`roles` (\n" +
					"  `ID` INT NOT NULL AUTO_INCREMENT,\n" +
					"  `Role` VARCHAR(45) NULL,\n" +
					"  PRIMARY KEY (`ID`))\n" +
					"ENGINE = InnoDB;\n");
			statement.executeUpdate("CREATE TABLE IF NOT EXISTS `eslaikouskaya`.`users` (\n" +
					"  `ID` INT NOT NULL AUTO_INCREMENT,\n" +
					"  `Login` VARCHAR(45) NULL,\n" +
					"  `Password` VARCHAR(45) NULL,\n" +
					"  `Email` VARCHAR(45) NULL,\n" +
					"  `roles_ID` INT NOT NULL,\n" +
					"  PRIMARY KEY (`ID`),\n" +
					"  CONSTRAINT `fk_users_roles`\n" +
					"    FOREIGN KEY (`roles_ID`)\n" +
					"    REFERENCES `eslaikouskaya`.`roles` (`ID`)\n" +
					"    ON DELETE RESTRICT\n" +
					"    ON UPDATE RESTRICT)\n" +
					"ENGINE = InnoDB;");
			statement.executeUpdate("CREATE TABLE IF NOT EXISTS `eslaikouskaya`.`categories` (\n" +
					"  `ID` INT NOT NULL AUTO_INCREMENT,\n" +
					"  `Category` VARCHAR(45) NULL,\n" +
					"  PRIMARY KEY (`ID`))\n" +
					"ENGINE = InnoDB;");
			statement.executeUpdate("CREATE TABLE IF NOT EXISTS `eslaikouskaya`.`classes` (\n" +
					"  `ID` INT NOT NULL AUTO_INCREMENT,\n" +
					"  `Class` VARCHAR(45) NULL,\n" +
					"  `categories_ID` INT NOT NULL,\n" +
					"  PRIMARY KEY (`ID`),\n" +
					"  CONSTRAINT `fk_classes_categories1`\n" +
					"    FOREIGN KEY (`categories_ID`)\n" +
					"    REFERENCES `eslaikouskaya`.`categories` (`ID`)\n" +
					"    ON DELETE RESTRICT\n" +
					"    ON UPDATE RESTRICT)\n" +
					"ENGINE = InnoDB;\n");
			statement.executeUpdate("CREATE TABLE IF NOT EXISTS `eslaikouskaya`.`materials` (\n" +
					"  `ID` INT NOT NULL AUTO_INCREMENT,\n" +
					"  `Name` VARCHAR(45) NULL,\n" +
					"  `Price` VARCHAR(45) NULL,\n" +
					"  `classes_ID` INT NOT NULL,\n" +
					"  PRIMARY KEY (`ID`),\n" +
					"  CONSTRAINT `fk_materials_classes1`\n" +
					"    FOREIGN KEY (`classes_ID`)\n" +
					"    REFERENCES `eslaikouskaya`.`classes` (`ID`)\n" +
					"    ON DELETE RESTRICT\n" +
					"    ON UPDATE RESTRICT)\n" +
					"ENGINE = InnoDB;\n");
			statement.executeUpdate("CREATE TABLE IF NOT EXISTS `eslaikouskaya`.`purchases` (\n" +
					"  `ID` INT NOT NULL AUTO_INCREMENT,\n" +
					"  `users_ID` INT NOT NULL,\n" +
					"  `materials_ID` INT NOT NULL,\n" +
					"  `Number` INT NULL,\n" +
					"  PRIMARY KEY (`ID`),\n" +
					"  CONSTRAINT `fk_purchases_users1`\n" +
					"    FOREIGN KEY (`users_ID`)\n" +
					"    REFERENCES `eslaikouskaya`.`users` (`ID`)\n" +
					"    ON DELETE CASCADE\n" +
					"    ON UPDATE CASCADE,\n" +
					"  CONSTRAINT `fk_purchases_materials1`\n" +
					"    FOREIGN KEY (`materials_ID`)\n" +
					"    REFERENCES `eslaikouskaya`.`materials` (`ID`)\n" +
					"    ON DELETE RESTRICT\n" +
					"    ON UPDATE RESTRICT)\n" +
					"ENGINE = InnoDB;");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'Administrator');");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'Manager');\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'Guest');\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'User');\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`users` (`ID`, `Login`, `Password`, `Email`, `roles_ID`) VALUES (DEFAULT, 'Katya1234', 'qwerty', 'K@gmail.com', 1);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`users` (`ID`, `Login`, `Password`, `Email`, `roles_ID`) VALUES (DEFAULT, 'Pavel13', 'asdfgh', 'Pav@tut.by', 2);");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`users` (`ID`, `Login`, `Password`, `Email`, `roles_ID`) VALUES (DEFAULT, 'AbrahamZERO', '123qwe', 'Azero@mail.ru', 3);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`users` (`ID`, `Login`, `Password`, `Email`, `roles_ID`) VALUES (DEFAULT, 'Lily_33', 'qazwsx', 'LilPop@mail.ru', 4);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`users` (`ID`, `Login`, `Password`, `Email`, `roles_ID`) VALUES (DEFAULT, 'Sharki07', '1029384756', 'Shark@gmail.com', 4);");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`categories` (`ID`, `Category`) VALUES (DEFAULT, 'Sanitary');\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`categories` (`ID`, `Category`) VALUES (DEFAULT, 'Metal rolling');\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`categories` (`ID`, `Category`) VALUES (DEFAULT, 'Building materials');\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`categories` (`ID`, `Category`) VALUES (DEFAULT, 'Roof');\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Polipropilen pipeline system', 1);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Steel pipe billet', 1);");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Valve', 1);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Fastener', 1);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Radiator and heating system', 1);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Polyethylene pipe', 1);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Asbestos-cement pipe', 1);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Plumbing equipment', 1);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Sealing materials and stuff', 1);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Pipes sewer PVC and NPVH', 1);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Corner', 2);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Grooved fittings', 2);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Round tube', 2);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Strip', 2);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Profile pipe', 2);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Sheet', 2);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Knitting wire', 2);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Channel', 2);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Smooth circle', 2);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Square', 2);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Gas silicate blocks', 3);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Brick', 3);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Polycarbonate', 3);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Drywall and Hardware', 3);");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Cement and mortar', 3);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Chipboard', 3);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Grid', 3);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Well ring', 3);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Pavement tile curb', 3);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Thermal insulation', 3);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Guided roofing', 4);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Slate', 4);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Shingles', 4);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Ondulin and accessories', 4);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Metal profile', 4);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Under-roof film', 4);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Gray reinforced pipes', '20', 1);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Squares', '10', 1);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Clutch', '15', 1);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Americans', '15', 1);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Tee', '17', 1);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Support зшзу', '18', 1);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Crane', '13', 1);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Polypropylene filter', '10', 1);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Drives', '30', 2);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Threads', '31', 2);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Locknuts', '35', 2);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Couplings', '18', 2);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Kegs', '10', 2);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Barrel', '12', 2);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Squares', '27', 2);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Tee', '25', 2);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Bends', '23', 2);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Black steel billet', '23', 2);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Galvanized steel billet', '24', 2);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Ball valves', '25', 3);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Coupling taps', '18', 3);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Flanged cranes', '8', 3);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Gate Valves', '34', 3);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Entili', '19', 3);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Filters', '30', 3);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Check Valves', '20', 3);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Flanges to Check Valves', '21', 3);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`purchases` (`ID`, `users_ID`, `materials_ID`, `Number`) VALUES (DEFAULT, 3, 15, 3);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`purchases` (`ID`, `users_ID`, `materials_ID`, `Number`) VALUES (DEFAULT, 3, 1, 3);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`purchases` (`ID`, `users_ID`, `materials_ID`, `Number`) VALUES (DEFAULT, 4, 12, 10);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`purchases` (`ID`, `users_ID`, `materials_ID`, `Number`) VALUES (DEFAULT, 4, 13, 1);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`purchases` (`ID`, `users_ID`, `materials_ID`, `Number`) VALUES (DEFAULT, 4, 14, 2);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`purchases` (`ID`, `users_ID`, `materials_ID`, `Number`) VALUES (DEFAULT, 5, 8, 1);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`purchases` (`ID`, `users_ID`, `materials_ID`, `Number`) VALUES (DEFAULT, 5, 3, 1);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`purchases` (`ID`, `users_ID`, `materials_ID`, `Number`) VALUES (DEFAULT, 5, 4, 15);\n");
		}
	}
}
