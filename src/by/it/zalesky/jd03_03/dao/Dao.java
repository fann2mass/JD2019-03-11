package by.it.zalesky.jd03_03.dao;

import java.sql.SQLException;

public class Dao {

    private static volatile Dao instance;

    public RolesDao roles;
    public UsersDao users;
    public ProductsDao products;
    public CategoryDao category;
    public OrdersDao orders;

    public void resetDataBase() throws SQLException {
        C_Init.main(new String[]{});
    }

    private Dao(){
        roles = new RolesDao();
        users = new UsersDao();
        products = new ProductsDao();
        category = new CategoryDao();
        orders = new OrdersDao();
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
