package by.it.bildziuh.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;


public class PrintMath {
    public static void main(String[] args) {

        Class<Math> mathClass = Math.class;
        Method[] methods = mathClass.getMethods();
        Field[] fields = mathClass.getFields();

        for (Method method : methods) {
            if ((method.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC) {
                System.out.println((String.valueOf(method).replace("java.lang.Math.", "")));
/*
                System.out.print(modifiers(method.getModifiers()));
                System.out.print(method.getName());

                if (method.getParameterCount() == 2)
                    System.out.println("(" + method.getReturnType() + "," + method.getReturnType() + ")");
                else
                    System.out.println("(" + method.getReturnType() + ")");
                    */
            }
        }

        for (Field field : fields) {
            if ((field.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC)
                System.out.println((String.valueOf(field).replace("java.lang.Math.", "")));
        }
    }
/*
    private static String modifiers(int mods) {
        switch (mods) {
            case 1:
                return "public ";
            case 9:
                return "public static ";
            case 17:
                return "public final ";
            case 257:
                return "public native ";
            case 273:
                return "public final native ";
        }
        return null;
    }
*/
}
