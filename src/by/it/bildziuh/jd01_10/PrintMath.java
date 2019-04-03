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
                int count = method.getParameterCount();
                System.out.print(modifiers(method.getModifiers()));
                System.out.print(method.getName());
                System.out.println(parameters(count, method));
                if (method.getTypeParameters()!=null)
                    System.out.print(method.getParameters()[0].toString().replace("arg0", ""));
                else
                    System.out.print("void ");
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
            default:
                return null;
        }
    }

    private static String parameters(int count, Method method) {
        switch (count) {
            case 1:
                return "(" + method.getParameterTypes()[0] + ")";
            case 2:
                return "(" + method.getParameterTypes()[0] + "," + method.getParameterTypes()[1] + ")";
            case 3:
                return "(" + method.getParameterTypes()[0] + "," + method.getParameterTypes()[1] + "," + method.getParameterTypes()[2] + ")";
            default:
                return "()";
        }
    }
    */
}
