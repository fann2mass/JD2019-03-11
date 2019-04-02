package by.it.zalesky.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {

        Class<String> stringClass = String.class;
        Method[] m = stringClass.getDeclaredMethods();
        for (Method method : m) {
            int modifiers = method.getModifiers();
            if ((modifiers & Modifier.STATIC) != Modifier.STATIC){
                String name = method.getName();
                System.out.println(name);
            }
        }

    }
}
