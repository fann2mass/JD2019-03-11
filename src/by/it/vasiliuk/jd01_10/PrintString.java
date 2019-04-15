package by.it.vasiliuk.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {
        Class<String> object = String.class;
        Method[] methods = object.getDeclaredMethods();
        for (Method method : methods) {
            int modifier = method.getModifiers();
            if(!Modifier.isStatic(modifier)){
                System.out.println(method.getName());
            }
        }
    }
}
