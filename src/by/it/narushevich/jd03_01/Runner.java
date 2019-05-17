package by.it.narushevich.jd03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class Runner {

    public static void main(String[] args) throws SQLException {

        Driver driver = new FabricMySQLDriver();
        DriverManager.registerDriver(driver);

        try (Connection connection = DriverManager.getConnection(
                ConnectPath.URL,
                ConnectPath.USER,
                ConnectPath.PASSWORD);
             Statement statement = connection.createStatement()
        ) {
            CheckConnection.check(connection);
            //B_AddRoles.createRoles(statement);
            //A_AddUser.createUsers(statement);
            //A_AddData.createCollection(statement);
            C_init.createFullDataBase(statement);
            B_ShowUsers.show(statement);
            //C_reset.resetDataBase(statement);
        }
    }
}
