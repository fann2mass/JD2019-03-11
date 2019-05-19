package by.it.narushevich.jd03_02;

import by.it.narushevich.jd03_02.beans.*;
import by.it.narushevich.jd03_02.crud.*;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {
        User user=new User(0,"Ivanetz","Ivanov","qwerty","ivan@ya.ru",2);
        UserCRUD userCRUD=new UserCRUD();
        userCRUD.create(user);
        user=userCRUD.read(user.getId());
        System.out.println(user);
        user.setLogin("Merry Rodger");
        userCRUD.update(user);
        user=userCRUD.read(user.getId());
        System.out.println(user);
        userCRUD.delete(user);

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

        Teatag teatag=new Teatag();
        teatag.setSubtitle("Very tasty tea");
        teatag.setUsers_id(3);
        teatag.setMaterial_id(1);
        teatag.setTrademark_id(2);
        teatag.setWidth_x_height_id(11);
        TeatagCRUD teatagCRUD=new TeatagCRUD();
        teatagCRUD.create(teatag);
        teatag=teatagCRUD.read(teatag.getId());
        System.out.println(teatag);
        teatag.setSubtitle("Jasmin tea");
        teatagCRUD.update(teatag);
        teatag=teatagCRUD.read(teatag.getId());
        System.out.println(teatag);
        teatagCRUD.delete(teatag);

        Material material = new Material(0,"Aluminium");
        MaterialCRUD materialCRUD=new MaterialCRUD();
        materialCRUD.create(material);
        material=materialCRUD.read(material.getId());
        System.out.println(material);
        material.setMaterial("Wood");
        materialCRUD.update(material);
        material=materialCRUD.read(material.getId());
        System.out.println(material);
        materialCRUD.delete(material);

        Trademark trademark = new Trademark(0,"Conference");
        TrademarkCRUD trademarkCRUD=new TrademarkCRUD();
        trademarkCRUD.create(trademark);
        trademark=trademarkCRUD.read(trademark.getId());
        System.out.println(trademark);
        trademark.setTrademark("My Mark");
        trademarkCRUD.update(trademark);
        trademark=trademarkCRUD.read(trademark.getId());
        System.out.println(trademark);
        trademarkCRUD.delete(trademark);

        Width_x_Height width_x_height = new Width_x_Height(0,"35 x 44");
        Width_x_HeightCRUD width_x_heightCRUD=new Width_x_HeightCRUD();
        width_x_heightCRUD.create(width_x_height);
        width_x_height=width_x_heightCRUD.read(width_x_height.getId());
        System.out.println(width_x_height);
        width_x_height.setWidth_x_height("30 x 50");
        width_x_heightCRUD.update(width_x_height);
        width_x_height=width_x_heightCRUD.read(width_x_height.getId());
        System.out.println(width_x_height);
        width_x_heightCRUD.delete(width_x_height);
    }
}
