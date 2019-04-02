package by.it.bildziuh.jd01_10;

import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args) throws Exception {

        Class<Bean> bean = Bean.class;
        Class<Param> anno = Param.class;
        Method a = anno.getMethod("a");
        Method b = anno.getMethod("b");
        Object instance = bean.getDeclaredConstructor().newInstance();
        Method[] methods = bean.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(anno)) {
                Param an = method.getAnnotation(anno);
                int aValue = (int) a.invoke(an);
                int bValue = (int) b.invoke(an);
                double result = (double) method.invoke(instance, aValue, bValue);
                System.out.println("Имя найденого метода: " + method.getName() + " результат запуска: " + result);
            }
        }
    }
}
