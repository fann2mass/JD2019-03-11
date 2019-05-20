package by.it.zalesky.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class B_AddRoles {

    public static void main(String[] args) {


            try (Connection connection= DriverManager.getConnection
                    (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
                 Statement statement= connection.createStatement()) {

                statement.executeUpdate(
                        "INSERT INTO Roles(`role`,`id`)"+
                                " VALUES ('Guest',2);");

            }
            catch (Exception e){
                e.printStackTrace();
            }

        }
    }

