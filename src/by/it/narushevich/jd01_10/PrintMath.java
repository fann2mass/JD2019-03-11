package by.it.narushevich.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> mathClass = Math.class;
        Method[] methods = mathClass.getDeclaredMethods();
        for (Method method : methods) {
            int modifiers = method.getModifiers();
            if ((modifiers & Modifier.PUBLIC) == Modifier.PUBLIC) // поиск только публичных методов
            {
                StringBuilder builder = new StringBuilder("public");
                if (Modifier.isStatic(modifiers))
                    builder.append("static ");
                String returnTypename = method.getReturnType().getSimpleName();


                System.out.println(builder);
            }

        }

    }
}
