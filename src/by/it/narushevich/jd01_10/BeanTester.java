package by.it.narushevich.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class BeanTester {
    public static void main(String[] args) throws Exception {

        Class<Bean> bean = Bean.class;
        Class<Param> param = Param.class;
        Method a = param.getMethod("a");
        Method b = param.getMethod("b");
        Method[] methods = bean.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(param)) {
                Param annotation = method.getAnnotation(param);
                int valueA = (int) a.invoke(annotation);
                int valueB = (int) b.invoke(annotation);
                String nameMethod = method.getName();
                double result;
                Object instance = bean.getDeclaredConstructor().newInstance();
                int modifiers = method.getModifiers();
                if ((modifiers & Modifier.STATIC) == Modifier.STATIC)
                    result = (double) method.invoke(null,valueA,valueB);
                else
                    result = (double) method.invoke(instance,valueA,valueB);
                System.out.println("Вызов метода "+nameMethod+" дал результат: "+result);
            }
        }
    }
}
