package by.it.bolotko.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> mathClass = Math.class;
        Method[] methods = mathClass.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            Method method = methods[i];
            //if ((method.getModifiers()& Modifier.PUBLIC) != Modifier.PUBLIC)
            System.out.println(method);
        }
    }
}
