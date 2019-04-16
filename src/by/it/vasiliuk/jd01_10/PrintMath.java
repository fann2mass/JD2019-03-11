package by.it.vasiliuk.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {
        Class<?> object = Math.class;
        Method[] methods = object.getDeclaredMethods();
        for (Method method : methods) {
            int modifiers = method.getModifiers();
            if(Modifier.isPublic(modifiers)){
                StringBuilder name_descript = new StringBuilder("public ");
                if(Modifier.isStatic(modifiers)){
                    name_descript.append("static ");
                }
                name_descript.append(method.getReturnType().getSimpleName()).append(" ");
                name_descript.append(method.getName());
                name_descript.append("(");
                Class<?>[] parameterTypes = method.getParameterTypes();
                for (int i = 0; i < parameterTypes.length; i++) {
                    if(i>0)name_descript.append(",");
                    name_descript.append(parameterTypes[i].getSimpleName());
                }
                name_descript.append(")");
                System.out.println(name_descript);
            }

        }
        Field[] fields = object.getFields();
        for (Field field : fields) {
            int modifiers = field.getModifiers();
            StringBuilder field_descript = new StringBuilder("public ");
            if(Modifier.isStatic(modifiers)){
                field_descript.append("static ");
                if(Modifier.isFinal(modifiers)){
                    field_descript.append("final ");
                }
                field_descript.append(field.getType()).append(" ");
                field_descript.append(field.getName());
            }
            System.out.println(field_descript);
            // }

        }
    }
}
