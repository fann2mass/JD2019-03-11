package by.it.akhmelev.jd01_10;


import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {

    public static void main(String[] args) {
        Class<Math> mathClass = Math.class;
        Method[] methods = mathClass.getDeclaredMethods();
        for (Method method : methods) {
            int modifiers = method.getModifiers();
            if (Modifier.isPublic(modifiers)){
                StringBuilder name=new StringBuilder("public ");
                if (Modifier.isStatic(modifiers))
                    name.append("static ");
                String returnTypename=method.getReturnType().getSimpleName();
                name.append(returnTypename).append(' ');
                name.append(method.getName()).append('(');
                Class<?>[] parameterTypes = method.getParameterTypes();
                for (int i = 0; i < parameterTypes.length; i++) {
                    if (i>0) name.append(',');
                    name.append(parameterTypes[i].getSimpleName());
                }
                name.append(')');
                System.out.println(name);
            }
        }
    }


}
