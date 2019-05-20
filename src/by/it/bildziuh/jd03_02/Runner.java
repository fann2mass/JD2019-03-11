package by.it.bildziuh.jd03_02;

import by.it.bildziuh.jd03_02.beans.Mod;
import by.it.bildziuh.jd03_02.beans.Role;
import by.it.bildziuh.jd03_02.beans.User;
import by.it.bildziuh.jd03_02.crud.ModCRUD;
import by.it.bildziuh.jd03_02.crud.RoleCRUD;
import by.it.bildziuh.jd03_02.crud.UserCRUD;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {

        User user=new User(0,"TestUser","qwerty","test@test.com",2);
        UserCRUD userCRUD=new UserCRUD();
        userCRUD.create(user);
        user=userCRUD.read(user.getId());
        System.out.println(user);
        user.setLogin("TestSuccess");
        userCRUD.update(user);
        user=userCRUD.read(user.getId());
        System.out.println(user);
        userCRUD.delete(user);
        
        Role role=new Role(0,"Moderaptor");
        RoleCRUD roleCRUD=new RoleCRUD();
        roleCRUD.create(role);
        role=roleCRUD.read(role.getId());
        System.out.println(role);
        role.setRole("Moderator");
        roleCRUD.update(role);
        role=roleCRUD.read(role.getId());
        System.out.println(role);
        roleCRUD.delete(role);

        Mod mod=new Mod();
        mod.setGame("Skyrim");
        mod.setGroup("Global improvements");
        mod.setName("New Skyrim");
        mod.setDescription("best description ever");
        mod.setSize(400);
        mod.setLink("gdrive");
        mod.setUsers_id(3);
        ModCRUD modCRUD =new ModCRUD();
        modCRUD.create(mod);
        mod= modCRUD.read(mod.getId());
        System.out.println(mod);
        mod.setName("Newest Skyrim");
        mod.setDescription("even better description for mod");
        modCRUD.update(mod);
        mod= modCRUD.read(mod.getId());
        System.out.println(mod);
        modCRUD.delete(mod);
    }
}
