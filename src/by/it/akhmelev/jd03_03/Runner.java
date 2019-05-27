package by.it.akhmelev.jd03_03;

import by.it.akhmelev.jd03_03.beans.Ad;
import by.it.akhmelev.jd03_03.beans.Role;
import by.it.akhmelev.jd03_03.beans.User;
import by.it.akhmelev.jd03_03.dao.Dao;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {
        Dao dao=Dao.getDao();

        User user=new User(0,"Ivanov","qwerty","ivan@ya.ru",2);
        dao.user.create(user);
        user=dao.user.read(user.getId());
        System.out.println(user);
        user.setLogin("LLLLLLLLLLLLLLLLLLLLL");
        dao.user.update(user);
        user=dao.user.read(user.getId());
        System.out.println(user);
        dao.user.delete(user);
        
        //а теперь Role
        Role role=new Role(0,"Manager");
        dao.role.create(role);
        role=dao.role.read(role.getId());
        System.out.println(role);
        role.setRole("Менеджер среднего звена");
        dao.role.update(role);
        role=dao.role.read(role.getId());
        System.out.println(role);
        dao.role.delete(role);

        //а теперь Ad
        Ad ad=new Ad(0,"test description","test address",3,5,9,66,99999,2);
        dao.ad.create(ad);
        ad=dao.ad.read(ad.getId());
        System.out.println(ad);
        ad.setDescription("test description after update");
        dao.ad.update(ad);
        ad=dao.ad.read(ad.getId());
        System.out.println(ad);
        dao.ad.delete(ad);
    }
}
