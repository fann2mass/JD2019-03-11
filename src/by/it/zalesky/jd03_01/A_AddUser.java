package by.it.zalesky.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class A_AddUser {

    public static void main(String[] args) {

        try (Connection connection= DriverManager.getConnection
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement= connection.createStatement()) {
             statement.executeUpdate(
                    "INSERT INTO Users(`login`,`password`,`email`,`Roles_id`)"+
                            " VALUES ('TestAdmin','tadmin','tadmin@t.by',1);");
             statement.executeUpdate(
                    "INSERT INTO Users(login,password,email,Roles_id)"+
                            " VALUES ('TestUser1','tuser1','tuser@t.by',2);");
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}

