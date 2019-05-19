package by.it.narushevich.jd03_01;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class B_ShowUsers {

    public  static void show(Statement statement) throws SQLException {

        ResultSet resultSet = statement.executeQuery("SELECT * FROM narushevich_ab.users");
        while (resultSet.next()){
            String out = resultSet.getString("nickname")+", "+
                    resultSet.getString("login")+", "+
                    resultSet.getString("email");
            System.out.println(out);
        }
    }
}
