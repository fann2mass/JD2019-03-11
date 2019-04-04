package by.it.eslaikouskaya.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
	public static void main(String[] args) {
		Method[] methods = Math.class.getDeclaredMethods();
		for (Method method : methods) {
			if ((method.getModifiers() & Modifier.STATIC) == Modifier.STATIC) {
				if ((method.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC) {
					System.out.println(String.valueOf(method).replace("java.lang.Math.", ""));
				}

			}
		}
		Field[] fields = Math.class.getFields();
		for (Field field : fields) {
			System.out.println(String.valueOf(field).replace("java.lang.Math.", ""));
		}
	}
}
