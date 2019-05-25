package by.it.zalesky.jd03_02;

import by.it.zalesky.jd03_02.beans.*;
import by.it.zalesky.jd03_02.crud.*;

import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) throws SQLException {

        Users users = new Users(0, "User0", "user0", "user0@t.by", 2);
        UsersCRUD usersCRUD = new UsersCRUD();
        usersCRUD.create(users);
        users=usersCRUD.read(users.getId());
        System.out.println(users);
        users.setLogin("loginUser1");
        usersCRUD.update(users);
        users = usersCRUD.read(users.getId());
        System.out.println(users);
        usersCRUD.delete(users);

        Roles roles = new Roles(0, "Moderator");
        RolesCRUD rolesCRUD = new RolesCRUD();
        rolesCRUD.create(roles);
        roles = rolesCRUD.read(roles.getId());
        System.out.println(roles);
        roles.setRole("Модератор интернет-магазина");
        rolesCRUD.update(roles);
        roles = rolesCRUD.read(roles.getId());
        System.out.println(roles);
        rolesCRUD.delete(roles);

        Category category = new Category(0, "Laptops");
        CategoryCRUD categoryCRUD = new CategoryCRUD();
        categoryCRUD.create(category);
        category = categoryCRUD.read(category.getId());
        System.out.println(category);
        category.setName("Ноутбуки");
        categoryCRUD.update(category);
        category = categoryCRUD.read(category.getId());
        System.out.println(category);
        categoryCRUD.delete(category);

        Products products = new Products(0, "Dell-inspiron", "Рабочийй ноутбук", 850, 1);
        ProductsCRUD productsCRUD = new ProductsCRUD();
        productsCRUD.create(products);
        products = productsCRUD.read(products.getId());
        System.out.println(products);
        products.setPrice(850);
        productsCRUD.update(products);
        products = productsCRUD.read(products.getId());
        productsCRUD.delete(products);

        Orders orders = new Orders(0, 850, 1, "ул.Ленинская 12", 2, 1);
        OrdersCRUD ordersCRUD = new OrdersCRUD();
        ordersCRUD.create(orders);
        orders = ordersCRUD.read(orders.getId());
        System.out.println(orders);
        orders.setAddress("DFSDFS");
        ordersCRUD.update(orders);
        orders = ordersCRUD.read(orders.getId());
        ordersCRUD.delete(orders);

    }
}
