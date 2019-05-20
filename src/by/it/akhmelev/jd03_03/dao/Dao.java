package by.it.akhmelev.jd03_03.dao;

import java.sql.SQLException;

public class Dao {

    private static volatile Dao instance;

    public RoleDao role;
    public UserDao user;
    public AdDao ad;

    public void resetDataBase() throws SQLException {
        C_Init.main(new String[]{});
    }

    private Dao() {
        role=new RoleDao();
        user=new UserDao();
        ad=new AdDao();
    }

    public static Dao getDao(){
        if (instance==null){
            synchronized (Dao.class){
                if (instance==null){
                    instance=new Dao();
                }
            }
        }

        return instance;
    }


}
