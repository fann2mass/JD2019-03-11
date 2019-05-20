package by.it.akhmelev.jd03_03;

import by.it.akhmelev.jd03_03.beans.Ad;
import by.it.akhmelev.jd03_03.beans.Role;
import by.it.akhmelev.jd03_03.beans.User;
import by.it.akhmelev.jd03_03.crud.AdCRUD;
import by.it.akhmelev.jd03_03.dao.RoleDao;
import by.it.akhmelev.jd03_03.dao.UserDao;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {
        User user=new User(0,"Ivanov","qwerty","ivan@ya.ru",2);
        UserDao userDao=new UserDao();
        userDao.create(user);
        user=userDao.read(user.getId());
        System.out.println(user);
        user.setLogin("LLLLLLLLLLLLLLLLLLLLL");
        userDao.update(user);
        user=userDao.read(user.getId());
        System.out.println(user);
        userDao.delete(user);
        
        //а теперь Role
        Role role=new Role(0,"Manager");
        RoleDao roleDao=new RoleDao();
        roleDao.create(role);
        role=roleDao.read(role.getId());
        System.out.println(role);
        role.setRole("Менеджер среднего звена");
        roleDao.update(role);
        role=roleDao.read(role.getId());
        System.out.println(role);
        roleDao.delete(role);

        //а теперь Ad
        Ad ad=new Ad();
        ad.setDescription("qqqqqqqqqqqqqqqqqqqq");
        ad.setUsersId(3);
        AdCRUD adCRUD=new AdCRUD();
        adCRUD.create(ad);
        ad=adCRUD.read(ad.getId());
        System.out.println(ad);
        ad.setDescription("wwwwwwwwwwwwwwwww");
        adCRUD.update(ad);
        ad=adCRUD.read(ad.getId());
        System.out.println(ad);
        adCRUD.delete(ad);
    }
}
