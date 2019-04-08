package by.it.narushevich.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> mathClass = Math.class;
        Method[] methods = mathClass.getDeclaredMethods();
        for (Method method : methods) {
            int modifiers = method.getModifiers();
            if ((modifiers & Modifier.PUBLIC) == Modifier.PUBLIC) {
                StringBuilder name = new StringBuilder("public ");
                if (Modifier.isStatic(modifiers))
                    name.append("static ");
                Class<?> returnType = method.getReturnType();
                String simpleName = method.getName();
                name.append(returnType).append(' ').append(simpleName).append('(');
                Class<?>[] parameterTypes = method.getParameterTypes();
                for (int i = 0; i < parameterTypes.length; i++) {
                    name.append(parameterTypes[i]);
                    if (i != parameterTypes.length - 1)
                        name.append(',');
                }
                name.append(')');
                System.out.println(name);
            }
        }
        Field[] fields = mathClass.getDeclaredFields();
        for (Field field : fields) {
            int modifiers = field.getModifiers();
            if (Modifier.isPublic(modifiers)) {
                if (Modifier.isStatic(modifiers)) {
                    Class<?> type = field.getType();
                    StringBuilder f = new StringBuilder();
                    f.append(type).append(' ');
                    String fieldName = field.getName();
                    f.append(fieldName);
                    System.out.println(f);
                }
            }
        }
    }
}
