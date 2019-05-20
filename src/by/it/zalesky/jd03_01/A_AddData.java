package by.it.zalesky.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class A_AddData {

    public static void main(String[] args) {

        try (Connection connection= DriverManager.getConnection
                (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement= connection.createStatement()) {
            statement.executeUpdate(
                    "INSERT INTO Products(`title`,`price`,`discription`,`Category_id`)"+
                            " VALUES ('Ноутбук','1900','Игровой ноутбук',1);");
            statement.executeUpdate(
                    "INSERT INTO Products(title,price,discription,Category_id)"+
                            " VALUES ('PC','2050','Офисный ПК',2);");
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

}
