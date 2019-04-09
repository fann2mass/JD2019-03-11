package by.it.bolotko.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {

        Class<Math> mathClass = Math.class;
        Method[] methods = mathClass.getDeclaredMethods();
        Field[] fields = mathClass.getDeclaredFields();
        for (Method method : methods) {
            if ((method.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC) {
                System.out.print(modifiers(method.getModifiers()));
                System.out.print(method.getReturnType() + " ");
                System.out.print(method.getName());
                System.out.println(parameters(method.getParameterCount(), method));
            }
        }

        for (Field field : fields) {
            if ((field.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC) {

                System.out.print(modifiers(field.getModifiers()));
                System.out.print(field.getType() + " ");
                System.out.println(field.getName());
            }
        }
    }

    private static String modifiers(int mods) {
        switch (mods) {
            case 1: //0001 - в бинарном коде: первый бит отвечает за модификатор "public"
                return "public ";
            case 9: //1001 - в бинарном коде: первый бит читаем выше, 4й бит отвечает за модификатор "static"
                return "public static ";
            case 17: //10001 - в бинарном коде: первый читаем выше, 5й бит отвечает за модификатор "final"
                return "public final ";
            case 25: //11001 - в бинарном коде: первый, четвёртый и пятый читаем выше
                return "public static final ";
            case 257://100000001 - в бинарном коде: первый читаем выше, 9й бит отвечает за модификатор "native"
                return "public native ";
            case 273://100010001 - в бинарном коде: первый, пятый и девятый биты читаем выше
                return "public final native ";
            default: /* применялся во время выполнения для поиска неопределённых значений, так же реализован тут, что бы не было
                 необходимости писать "return" вне свича. */
                return null + " ";
        }
    }

    private static String parameters(int count, Method method) {
        switch (count) {
            case 1:
                return "(" + method.getParameterTypes()[0] + ")"; /*если в метод передаётся 1 значение, выводит первое значение массива,
             которое имеет индекс [0]*/
            case 2:
                return "(" + method.getParameterTypes()[0] + "," + method.getParameterTypes()[1] + ")"; /*если в метод передаётся 2 значение,
             выводит первое и второе значения массива, которые имею индексы [0] и [1] соответственно.*/
            case 3: // для текущего задания не нужен, добавил, когда проверял на других классах
                return "(" + method.getParameterTypes()[0] + "," + method.getParameterTypes()[1] + "," + method.getParameterTypes()[2] + ")";
            default:  // в текущем задании для методов, в которые не передаются какие-либо значения (например, Math.random)
                return "()";
        }
    }
}