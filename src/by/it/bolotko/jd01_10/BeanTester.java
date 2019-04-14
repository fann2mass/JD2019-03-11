package by.it.bolotko.jd01_10;

import java.lang.reflect.Method;

	public class BeanTester {
		public static void main(String[] args) throws Exception {
			Method[] methods = Bean.class.getDeclaredMethods();
			for (Method method : methods) {
				if (method.isAnnotationPresent(Param.class)) {
					Param annotation = method.getAnnotation(Param.class);
					int a = annotation.a();
					int b = annotation.b();
					Object instance = Bean.class.getDeclaredConstructor().newInstance();
					Object invoke = method.invoke(instance, a, b);
					System.out.println(method.getName() + invoke);
				}
			}
		}
	}
