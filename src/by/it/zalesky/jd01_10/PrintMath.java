package by.it.zalesky.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;


public class PrintMath {

    public static void main(String[] args) {
        Class<Math> mathClass = Math.class;
        Class<Param> paramClass = Param.class;
        Param annotation = mathClass.getAnnotation(paramClass);
        Method[] methods = mathClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);

            int modifiers = method.getModifiers();
            if (Modifier.isPublic(modifiers)) {


                StringBuilder name = new StringBuilder("public ");
                name.append("static ");

                String returnTypename = method.getReturnType().getSimpleName();
                name.append(returnTypename).append(' ');
                name.append(method.getName()).append('(');
                Class<?>[] parameterTypes = method.getParameterTypes();
                for (int i = 0; i < parameterTypes.length; i++) {
                    if (i > 0) name.append(',');
                    name.append(parameterTypes[i].getSimpleName());
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