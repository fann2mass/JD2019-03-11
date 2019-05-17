package by.it.akhmelev.jd03_02;

import by.it.akhmelev.jd03_02.beans.Ad;
import by.it.akhmelev.jd03_02.beans.Role;
import by.it.akhmelev.jd03_02.beans.User;
import by.it.akhmelev.jd03_02.crud.AdCRUD;
import by.it.akhmelev.jd03_02.crud.RoleCRUD;
import by.it.akhmelev.jd03_02.crud.UserCRUD;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {
        User user=new User(0,"Ivanov","qwerty","ivan@ya.ru",2);
        UserCRUD userCRUD=new UserCRUD();
        userCRUD.create(user);
        user=userCRUD.read(user.getId());
        System.out.println(user);
        user.setLogin("LLLLLLLLLLLLLLLLLLLLL");
        userCRUD.update(user);
        user=userCRUD.read(user.getId());
        System.out.println(user);
        userCRUD.delete(user);
        
        //а теперь Role
        Role role=new Role(0,"Manager");
        RoleCRUD roleCRUD=new RoleCRUD();
        roleCRUD.create(role);
        role=roleCRUD.read(role.getId());
        System.out.println(role);
        role.setRole("Менеджер среднего звена");
        roleCRUD.update(role);
        role=roleCRUD.read(role.getId());
        System.out.println(role);
        roleCRUD.delete(role);

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
