package by.it.zalesky.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class B_AddRoles {

    public static void main(String[] args) {

            try (Connection connection= DriverManager.getConnection
                    (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
                 Statement statement= connection.createStatement()) {

                statement.executeUpdate("CREATE TABLE IF NOT EXISTS `zalesky`.`Roles` (\n" +
                        " `id` INT NOT NULL AUTO_INCREMENT,\n" +
                        " `role` VARCHAR(50) NULL,\n" +
                        " PRIMARY KEY (`id`))\n" +
                        " ENGINE = InnoDB; ");

                statement.executeUpdate("INSERT INTO `zalesky`.`Roles` (`id`, `role`) VALUES (DEFAULT, 'Administrator2');\n");
                statement.executeUpdate("INSERT INTO `zalesky`.`Roles` (`id`, `role`) VALUES (DEFAULT, 'User2');\n");
                statement.executeUpdate("INSERT INTO `zalesky`.`Roles` (`id`, `role`) VALUES (DEFAULT, 'Guest2');");

            }
            catch (Exception e){
                e.printStackTrace();
            }

        }
    }

