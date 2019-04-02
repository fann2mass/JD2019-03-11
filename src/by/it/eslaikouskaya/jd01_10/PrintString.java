package by.it.eslaikouskaya.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
	public static void main(String[] args) {
		Method [] methods = String.class.getDeclaredMethods();
		for (Method method : methods) {
			if ((method.getModifiers()& Modifier.STATIC)!= Modifier.STATIC){
				System.out.println(method);
			}

		}
	}
}
