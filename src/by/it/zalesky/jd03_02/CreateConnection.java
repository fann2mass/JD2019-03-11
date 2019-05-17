package by.it.zalesky.jd03_02;

import java.sql.Connection;

public class CreateConnection {


    private static Connection connection;

    static {
     try {
          Class.forName("com.mysql.jdbc.Driver");
      } catch (Exception ex) {
            // handle the error
        }
    }

    private static final String URL="jdbc:mysql://127.0.0.1:2016/";
    private static final String USER="root";
    private static final String PASSWORD="";



}
