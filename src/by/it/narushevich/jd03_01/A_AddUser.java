package by.it.narushevich.jd03_01;

import java.sql.*;

public class A_AddUser {

    public static void createUsers(Statement statement) throws SQLException {

            statement.executeUpdate("insert into users(id, login, password, email, roles_id, country_id, city_id)" +
                    "values (default,'masha_05','qwerty','masha_05@tut.by', 1, 1, 1)");
            statement.executeUpdate("insert into users(id, login, password, email, roles_id, country_id, city_id)" +
                    "values (default, 'fr_pole','asdfgh','pol_zhan@gmail.com', 2, 4, 4)");
            statement.executeUpdate("insert into users(id, login, password, email, roles_id, country_id, city_id)" +
                    "values (default, 'dimon_rus','wasder','dimas@mail.ru', 2, 2, 2)");

    }
}
