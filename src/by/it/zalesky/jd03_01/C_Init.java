package by.it.zalesky.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class C_Init {

    private static final String URL="jdbc:mysql://127.0.0.1:2016/";
    private static final String USER="root";
    private static final String PASSWORD="";

//    static {
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//        } catch (Exception ex) {
//            // handle the error
//        }
//    }


    public static void main(String[] args) throws SQLException {
        try (
        Connection connection= DriverManager.getConnection(URL,USER,PASSWORD);
        Statement statement = connection.createStatement()
        ){
            statement.executeUpdate("DROP SCHEMA IF EXISTS `zalesky`");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `zalesky` DEFAULT CHARACTER SET utf8;");
            statement.executeUpdate("DROP TABLE IF EXISTS `zalesky`.`Roles`");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `zalesky`.`Roles` (\n" +
            " `id` INT NOT NULL AUTO_INCREMENT,\n" +
            " `role` VARCHAR(50) NULL,\n" +
            " PRIMARY KEY (`id`))\n" +
            " ENGINE = InnoDB; ");
            statement.executeUpdate("DROP TABLE IF EXISTS `zalesky`.`Users`");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `zalesky`.`Users` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `login` VARCHAR(100) NULL,\n" +
                    "  `password` VARCHAR(100) NULL,\n" +
                    "  `email` VARCHAR(100) NULL,\n" +
                    "  `Roles_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  CONSTRAINT `fk_Customer_Roles`\n" +
                    "    FOREIGN KEY (`Roles_id`)\n" +
                    "    REFERENCES `zalesky`.`Roles` (`id`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("DROP TABLE IF EXISTS `zalesky`.`Category`");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `zalesky`.`Category` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `name` VARCHAR(255) NOT NULL,\n" +
                    "  PRIMARY KEY (`id`));");
            statement.executeUpdate("DROP TABLE IF EXISTS `zalesky`.`Products`");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `zalesky`.`Products` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `title` VARCHAR(200) NULL,\n" +
                    "  `discription` TEXT(200) NULL,\n" +
                    "  `price` DECIMAL NULL,\n" +
                    "  `Category_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  CONSTRAINT `fk_Products_Category1`\n" +
                    "    FOREIGN KEY (`Category_id`)\n" +
                    "    REFERENCES `zalesky`.`Category` (`id`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB;");
            statement.executeUpdate("DROP TABLE IF EXISTS `zalesky`.`Orders`");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `zalesky`.`Orders` (\n" +
                    "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `product` VARCHAR(255) NULL,\n" +
                    "  `price` DECIMAL NULL,\n" +
                    "  `quantity` INT NOT NULL,\n" +
                    "  `address` VARCHAR(100) NOT NULL,\n" +
                    "  `postal_code` VARCHAR(45) NOT NULL,\n" +
                    "  `order_date` DATE NULL,\n" +
                    "  `order_time` TIME NULL,\n" +
                    "  `Users_id` INT NOT NULL,\n" +
                    "  `Products_id` INT NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  CONSTRAINT `fk_Orders_Users1`\n" +
                    "    FOREIGN KEY (`Users_id`)\n" +
                    "    REFERENCES `zalesky`.`Users` (`id`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT,\n" +
                    "  CONSTRAINT `fk_Orders_Products1`\n" +
                    "    FOREIGN KEY (`Products_id`)\n" +
                    "    REFERENCES `zalesky`.`Products` (`id`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT);");
            statement.executeUpdate("INSERT INTO `zalesky`.`Roles` (`id`, `role`) VALUES (DEFAULT, 'Administrator');\n");
            statement.executeUpdate("INSERT INTO `zalesky`.`Roles` (`id`, `role`) VALUES (DEFAULT, 'User');\n");
            statement.executeUpdate("INSERT INTO `zalesky`.`Roles` (`id`, `role`) VALUES (DEFAULT, 'Administrator');\n");
            statement.executeUpdate("INSERT INTO `zalesky`.`Roles` (`id`, `role`) VALUES (DEFAULT, NULL);\n");
            statement.executeUpdate("INSERT INTO `zalesky`.`Users` (`id`, `login`, `password`, `email`, `Roles_id`) VALUES (DEFAULT, 'Administrator', 'admin', 'admin@t.by', 1);\n");
            statement.executeUpdate("INSERT INTO `zalesky`.`Users` (`id`, `login`, `password`, `email`, `Roles_id`) VALUES (DEFAULT, 'User', 'user', 'user@t.by', 2);\n");
            statement.executeUpdate("INSERT INTO `zalesky`.`Category` (`id`, `name`) VALUES (DEFAULT, 'laptops');\n");
            statement.executeUpdate("INSERT INTO `zalesky`.`Category` (`id`, `name`) VALUES (DEFAULT, 'desktops');\n");
            statement.executeUpdate("INSERT INTO `zalesky`.`Products` (`id`, `title`, `discription`, `price`, `Category_id`) VALUES (DEFAULT, 'Dell-Allienwar', 'Notebook', 2000, 1);\n");
            statement.executeUpdate("INSERT INTO `zalesky`.`Products` (`id`, `title`, `discription`, `price`, `Category_id`) VALUES (DEFAULT, 'HyperX-PC', 'Desktop', 2500, 2);\n");
            statement.executeUpdate("INSERT INTO `zalesky`.`Orders` (`id`, `product`, `price`, `quantity`, `address`, `postal_code`, `order_date`, `order_time`, `Users_id`, `Products_id`) VALUES (DEFAULT, 'Dell-Allienwar', 2000, 1, 'ул.Машерова 21', '98125', '21.06.2019', '22.00', 2, 1);\n");

        }

    }
}
