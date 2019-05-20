package by.it.eslaikouskaya.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class C_Init {

	private static final String URL = "jdbc:mysql://127.0.0.1:3306/";
	private static final String USER = "root";
	private static final String PASSWORD = "qwerty123456";

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception ex) {
			// handle the error
		}
	}

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
					"ENGINE = InnoDB;");
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
					"ENGINE = InnoDB;");
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
					"ENGINE = InnoDB;\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'Administrator');\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'Manager');\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'Guest');\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`roles` (`ID`, `Role`) VALUES (DEFAULT, 'User');\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`users` (`ID`, `Login`, `Password`, `Email`, `roles_ID`) VALUES (DEFAULT, 'Katya1234', 'qwerty', 'K@gmail.com', 1);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`users` (`ID`, `Login`, `Password`, `Email`, `roles_ID`) VALUES (DEFAULT, 'Pavel13', 'asdfgh', 'Pav@tut.by', 2);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`users` (`ID`, `Login`, `Password`, `Email`, `roles_ID`) VALUES (DEFAULT, 'AbrahamZERO', '123qwe', 'Azero@mail.ru', 3);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`users` (`ID`, `Login`, `Password`, `Email`, `roles_ID`) VALUES (DEFAULT, 'Lily_33', 'qazwsx', 'LilPop@mail.ru', 4);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`users` (`ID`, `Login`, `Password`, `Email`, `roles_ID`) VALUES (DEFAULT, 'Sharki07', '1029384756', 'Shark@gmail.com', 4);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`categories` (`ID`, `Category`) VALUES (DEFAULT, 'Сантехника');\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`categories` (`ID`, `Category`) VALUES (DEFAULT, 'Металлопрокат');\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`categories` (`ID`, `Category`) VALUES (DEFAULT, 'Стройматериалы');\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`categories` (`ID`, `Category`) VALUES (DEFAULT, 'Кровля');\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Трубы канализационные ПВХ и НПВХ', 1);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Уплотнительные матриалы и прочее', 1);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Сантехническое оборудование', 1);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Трубы асбестоцементные', 1);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Трубы полиэтиленовые', 1);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Радиаторы и системы отопления', 1);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Элементы креплений', 1);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Запорная арматура', 1);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Трубные стальные заготовки', 1);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Системы трубопровода из полипропилена', 1);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Уголок', 2);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Арматура рифленая', 2);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Трубы круглые', 2);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Полоса', 2);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Трубы профильные', 2);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Листы', 2);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Проволока вязальная', 2);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Швеллер', 2);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Круг гладкий', 2);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Квадрат', 2);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Блоки газосиликатные', 3);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Кирпич', 3);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Поликарбонат', 3);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Цемент и строительные смеси', 3);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Плиты стружечные', 3);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Сетка', 3);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Кольца колодцев', 3);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Плитка тротуарная бордюры', 3);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Теплоизоляция', 3);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Направляемая кровля', 4);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Шифер', 4);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Гибкая черепица', 4);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Ондулин и комплектующие', 4);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Металлопрофиль', 4);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`classes` (`ID`, `Class`, `categories_ID`) VALUES (DEFAULT, 'Пленка подкровельная', 4);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Труба серая армированная', '20', 1);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Угольник', '10', 1);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Муфта', '15', 1);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Американка', '15', 1);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Тройник', '17', 1);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Опора', '18', 1);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Кран', '13', 1);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Фильтр из полипропилена', '10', 1);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Сгон', '30', 2);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Резьба', '31', 2);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Контргайка', '35', 2);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Муфта', '18', 2);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Бочонок', '10', 2);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Угольник', '12', 2);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Тройник', '27', 2);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Отвод', '25', 2);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Черная трубная заготовка', '23', 2);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Оцинкованная трубная заготовка', '23', 2);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Кран шаровой', '24', 3);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Кран муфтовый', '25', 3);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Кран фланцевый', '18', 3);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Задвижка', '8', 3);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Вентиль', '34', 3);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Фильтр', '19', 3);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Обратный клапан', '30', 3);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Фланец к обратному клапану', '20', 3);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Болт', '21', 4);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Гайка', '9', 4);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Шайба', '20', 4);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Шпилька', '11', 4);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Хомут ремонтный', '12', 4);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Хомут для крепления труб', '8', 4);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Радиатор алюминевый', '31', 5);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Радиатор биметаллический', '36', 5);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Радиатор чугунный', '30', 5);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Кронштейн', '29', 5);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Клапан для регулировки', '28', 5);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Монтажный комплект', '20', 5);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Труба ПЭ 25-63 мм', '23', 6);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Муфта', '16', 6);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Тройник', '14', 6);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Угольник', '11', 6);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Заглушка', '9', 6);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Фитинг к полиэтиленовым трубам', '10', 6);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Труба безнапорная 110х3.95м', '35', 7);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Труба безнапорная 160х3.95м ', '24', 7);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Труба напорная 200х5м', '37', 7);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Унитаз', '34', 8);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Умывальник', '31', 8);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Душевой поддон', '34', 8);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Биде', '11', 8);\nINSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Писсуар', '11', 8);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Смеситель', '10', 8);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Гибкая подводка', '26', 8);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Паронитовая прокладка', '34', 9);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Техпластина', '31', 9);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Каболка', '23', 9);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Лен сантехнический ', '26', 9);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Шнур асбестовый', '29', 9);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Асбокартон', '10', 9);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Электроды', '14', 9);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Труба для наружной канализации', '33', 10);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Труба для внутренней канализации', '23', 10);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Фасонная часть', '29', 10);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Трап', '18', 10);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Люк', '35', 10);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Уголок 25-100 мм', '32', 11);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Арматура рифленая\\n6 — 20 мм', '17', 12);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Труба ВГП 15-50 мм', '12', 13);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Труба электросварная 57-325 мм', '10', 13);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Труба оцинкованная 15-108 мм', '6', 13);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Полоса 25х4 и 40х4', '9', 14);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Труба профильная 15х15-100х100', '9', 15);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Лист г/к 2 — 10 мм', '9', 16);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Лист х/к 0.8 — 1.5 мм', '12', 16);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Лист оцинкованный ', '14', 16);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Лист с полимерным покрытием', '14', 16);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Лист рифленый', '15', 16);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Лист ПВЛ', '19', 16);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Проволока вязальная 1.2 — 5 мм', '31', 17);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Швеллер 8 — 20 мм', '34', 18);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Круг 6 -12 мм', '24', 19);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Квадрат 10х10 мм', '27', 20);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Блок 100х290х600', '26', 21);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Блок 200х290х600', '21', 21);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Блок 250х300х600', '31', 21);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Блок 250х400х600', '10', 21);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Перемычка', '19', 21);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Блок газосиликатный', '16', 21);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Кирпич силикатный ', '26', 22);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Кирпич керамический', '23', 22);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Кирпич цветной ', '27', 22);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Кирпич гиперпрессованный', '26', 22);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Кирпич лицевой ', '19', 22);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Кирпич огнеупорный', '21', 22);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Поликарбонат 4-10мм ', '30', 23);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Поликарбонат 2100х6000', '29', 23);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Поликарбонат прозрачный', '28', 23);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Поликарбонат цветной', '29', 23);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Профиль торцевой', '20', 23);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Профиль пристенный', '13', 23);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Профиль соединительный', '8', 23);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Гипсокартон стеновой ', '12', 24);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Гипсокартон потолочный', '22', 24);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Гипсокартон влагостойкий', '10', 24);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Профиль', '12', 24);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Подвес', '17', 24);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Краб', '14', 24);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Цемент', '30', 25);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Штукатурка', '27', 25);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Шпатлевка', '26', 25);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Клей', '36', 25);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Расствор', '16', 25);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Стяжка', '14', 25);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'ДСП', '12', 26);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'ДВП', '19', 26);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Плита ОСБ 9-18 мм', '17', 26);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Фанера', '20', 26);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'ЦСП', '28', 26);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Сетка 3мм 0.5х2 (50х50)', '29', 27);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Сетка 3мм 1х2(100х100)', '27', 27);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Сетка 3мм 1х2(150х150)', '32', 27);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Сетка 4мм 0.5х2 (50х50)', '22', 27);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Сетка 4мм 1х2(100х100)', '33', 27);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Сетка 5мм 1х2(100х100)', '30', 27);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Сетка рабица', '10', 27);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Сетка ССШ', '20', 27);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Кольцо ж/б 1.0 -2.0 м', '17', 28);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Плита перекрытия', '27', 28);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Днище колодца ', '14', 28);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Доборные кольца 0.7м', '29', 28);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Люки чугунные', '35', 28);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Люки полимерные', '33', 28);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Плитка серая', '32', 29);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Плитка красная', '17', 29);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'кирпичик 60,80мм', '9', 29);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, '\\\"Старый город\\\"', '10', 29);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, '\\\"Черепашка\\\"', '15', 29);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, '\\\"Калифорния\\\"', '21', 29);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Квадрат ажурный ', '12', 29);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Борт тратуарный', '20', 29);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Борт дорожный', '31', 29);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Утеплитель фасадный ', '34', 30);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Рулон', '25', 30);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Плита', '35', 30);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, '«Кнауф»', '18', 30);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Минвата', '19', 30);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Пенопласт', '26', 30);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Керамзит', '29', 30);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'ТЕХНОНИКОЛЬ', '20', 31);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'БИКРОСТ', '33', 31);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'ЛИНОКРОМ', '32', 31);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'ЭЛАКРОМ', '26', 31);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Шифер', '18', 32);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Шиферный гвоздь', '11', 32);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, '\\\"Шинглас\\\"', '31', 33);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Подкладочный ковер', '18', 33);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Гвоздь', '19', 33);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Мастика', '22', 33);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Ондулин красный', '22', 34);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Ондулин коричневый', '26', 34);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Ондулин зеленый', '24', 34);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Конек', '18', 34);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Ендова', '17', 34);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Ветровая планка', '13', 34);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Ондулин черепица', '22', 34);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Гвоздь', '20', 34);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Пленка', '29', 34);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Металлочерепица', '22', 35);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Профнастил', '30', 35);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Доборный элементы', '18', 35);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Кровля', '14', 35);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Саморез', '32', 35);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Пленка', '26', 35);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Гидроизоляция ', '26', 36);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Пароизоляция', '27', 36);\n");
			statement.executeUpdate("INSERT INTO `eslaikouskaya`.`materials` (`ID`, `Name`, `Price`, `classes_ID`) VALUES (DEFAULT, 'Армированная пленка', '15', 36);\n");
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
