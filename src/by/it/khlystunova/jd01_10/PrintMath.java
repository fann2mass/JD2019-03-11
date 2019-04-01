package by.it.khlystunova.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/*TaskB1. Напишите программу PrintMath, которая выводит на консоль все публичные поля и методы
стандартного класса Math в следующем формате (тест потребует точное совпадение!):
public static float abs(float)
public static double pow(double,double)*/
public class PrintMath {
    public static void main(String[] args) {
      Class<?> object = Math.class;
        Method[] methods = object.getDeclaredMethods();
        for (Method method : methods) {
            int modifiers = method.getModifiers();
            if(Modifier.isPublic(modifiers)){
                StringBuilder name = new StringBuilder("public ");
                if(Modifier.isStatic(modifiers)){
                    name.append("static ");
                }
                name.append(method.getReturnType().getSimpleName()).append(" ");
                name.append(method.getName());
                name.append("(");
                Class<?>[] parameterTypes = method.getParameterTypes();
                for (int i = 0; i < parameterTypes.length; i++) {
                    if(i>0)name.append(",");
                    name.append(parameterTypes[i].getSimpleName());
                }
                name.append(")");
                System.out.println(name);
            }

        }
        Field[] fields = object.getFields();
        for (Field field : fields) {
            int modifiers = field.getModifiers();
            if(Modifier.isPublic(modifiers)){
                StringBuilder sb = new StringBuilder("public ");
                if(Modifier.isStatic(modifiers)){
                    sb.append("static ");
                    if(Modifier.isFinal(modifiers)){
                        sb.append("final ");
                    }
                    sb.append(field.getType()).append(" ");
                    sb.append(field.getName());
                }
                System.out.println(sb);
            }

        }
    }
}
