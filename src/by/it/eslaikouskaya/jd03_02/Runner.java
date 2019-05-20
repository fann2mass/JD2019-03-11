package by.it.eslaikouskaya.jd03_02;


import by.it.eslaikouskaya.jd03_02.beans.*;
import by.it.eslaikouskaya.jd03_02.crud.*;

import java.sql.SQLException;

public class Runner {
	public static void main(String[] args) throws SQLException {
		User user = new User(0, "Ivanov", "qwerty", "ivan@ya.ru", 2);
		UserCRUD userCRUD = new UserCRUD();
		userCRUD.create(user);
		user = userCRUD.read(user.getId());
		System.out.println(user);
		user.setLogin("LLLLLLLLLLLLLLLLLLLLL");
		userCRUD.update(user);
		user = userCRUD.read(user.getId());
		System.out.println(user);
		userCRUD.delete(user);

		Role role = new Role(0, "Manager");
		RoleCRUD roleCRUD = new RoleCRUD();
		roleCRUD.create(role);
		role = roleCRUD.read(role.getId());
		System.out.println(role);
		role.setRole("Менеджер среднего звена");
		roleCRUD.update(role);
		role = roleCRUD.read(role.getId());
		System.out.println(role);
		roleCRUD.delete(role);

		Material material = new Material(0, "Уголок", 15, 3);
		MaterialCRUD materialCRUD = new MaterialCRUD();
		materialCRUD.create(material);
		material = materialCRUD.read(material.getId());
		System.out.println(material);
		material.setPrice(13);
		materialCRUD.update(material);
		material = materialCRUD.read(material.getId());
		System.out.println(material);
		materialCRUD.delete(material);

		Purchase purchase = new Purchase(0, 2, 5, 10);
		PurchaseCRUD purchaseCRUD = new PurchaseCRUD();
		purchaseCRUD.create(purchase);
		purchase = purchaseCRUD.read(purchase.getId());
		System.out.println(purchase);
		purchase.setMaterialsId(15);
		purchaseCRUD.update(purchase);
		purchase = purchaseCRUD.read(purchase.getId());
		System.out.println(purchase);
		purchaseCRUD.delete(purchase);

		Grade grade = new Grade(0, "Душ", 2);
		GradeCRUD gradeCRUD = new GradeCRUD();
		gradeCRUD.create(grade);
		grade = gradeCRUD.read(grade.getId());
		System.out.println(grade);
		grade.setCategoriesId(1);
		gradeCRUD.update(grade);
		grade = gradeCRUD.read(grade.getId());
		System.out.println(grade);
		gradeCRUD.delete(grade);

		Category category = new Category(0, "Полы");
		CategoryCRUD categoryCRUD = new CategoryCRUD();
		categoryCRUD.create(category);
		category = categoryCRUD.read(category.getId());
		System.out.println(category);
		category.setCategory("Полы и стены");
		categoryCRUD.update(category);
		category = categoryCRUD.read(category.getId());
		System.out.println(category);
		categoryCRUD.delete(category);
	}
}