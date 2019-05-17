package by.it.bolotko.jd03_02;

import by.it.bolotko.jd03_02.beans.Role;
import by.it.bolotko.jd03_02.beans.User;
import by.it.bolotko.jd03_02.crud.RoleCRUD;
import by.it.bolotko.jd03_02.crud.UserCRUD;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {

        //проверка User
        User user=new User(0,"сlient","tneilс","сlient@yandex.ru","+375334537781",2);
        UserCRUD userCRUD=new UserCRUD();
        userCRUD.create(user);
        user=userCRUD.read(user.getId());
        System.out.println(user);
        user.setLogin("PROVEROCHKA");
        userCRUD.update(user);
        user=userCRUD.read(user.getId());
        System.out.println(user);
        userCRUD.delete(user);

        //а теперь Role
        Role role=new Role(0,"cleaner");
        RoleCRUD roleCRUD=new RoleCRUD();
        roleCRUD.create(role);
        role=roleCRUD.read(role.getId());
        System.out.println(role);
        role.setRole("batman");
        roleCRUD.update(role);
        role=roleCRUD.read(role.getId());
        System.out.println(role);
        roleCRUD.delete(role);
    }
}
