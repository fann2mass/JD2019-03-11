package by.it.narushevich.jd03_01;

import java.sql.*;

public class A_AddUser {

    public static void createUsers(Statement statement) throws SQLException {

        statement.executeUpdate("INSERT INTO narushevich_ab.users " +
                "(`id`, `nickname`, `login`, `password`, `email`, `fk_roles`) " +
                "VALUES (DEFAULT, 'Mari_Ann', 'masha_05', 'qwerty', 'masha_05@tut.by', 1);");
        statement.executeUpdate("INSERT INTO narushevich_ab.users " +
                "(`id`, `nickname`, `login`, `password`, `email`, `fk_roles`) " +
                "VALUES (DEFAULT, 'Zhan', 'fr_pole', 'asdfgh', 'pol_zhan@gmail.com', 2);");
        statement.executeUpdate("INSERT INTO narushevich_ab.users " +
                "(`id`, `nickname`, `login`, `password`, `email`, `fk_roles`) " +
                "VALUES (DEFAULT, 'Dima', 'dimon_rus', 'wasder', 'dimas@mail.ru', 2);");

    }
}
