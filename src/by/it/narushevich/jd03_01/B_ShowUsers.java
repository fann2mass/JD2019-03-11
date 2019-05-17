package by.it.narushevich.jd03_01;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class B_ShowUsers {

    public  static void show(Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery("select * from narushevich.users");
        while (resultSet.next()){
            String out = resultSet.getString("login")+", "+
                    resultSet.getString("email")+", "+
                    resultSet.getString("roles_id");
            System.out.println(out);
        }
    }
}
