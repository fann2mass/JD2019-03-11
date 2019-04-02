package by.it.bildziuh.jd01_10;

import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args) throws Exception{

        Class<Bean> beanClass = Bean.class;
        Method [] methods = beanClass.getDeclaredMethods();

        for (int i = 0; i < methods.length; i++) {
            System.out.println(methods[i]);
        }
    }
}
