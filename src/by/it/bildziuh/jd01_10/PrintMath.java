package by.it.bildziuh.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;


public class PrintMath {
    public static void main(String[] args) {

        Class<Math> mathClass = Math.class;
        Method[] methods = mathClass.getDeclaredMethods(); // в массив methods помещаем все методы из класса Math.
        Field[] fields = mathClass.getDeclaredFields(); /*в массив fields помещаем все поля из класса Math.
         Некоторые математические опекрации не выделены в отдельные методы и находятся непосредственно в классе Math,
         например число ПИ или число Эйлера(E).*/

        for (Method method : methods) {  //перебираем все методы класса Math, которые мы получили в строке 12
            if ((method.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC) { /* по заданию нам необходимо напечатать
                 только публичные методы */

                System.out.print(modifiers(method.getModifiers())); /* getModifiers - возвращает число, в десятичной системе счисления
                 соответсвующее модификаторам рассматриваемого метода, подробнее внутри метода modifiers в строке 46*/
                System.out.print(method.getReturnType() + " "); // получаем тип возвращаемого значение (int/double/string/void и т.д.)
                System.out.print(method.getName()); // получаем имя метода (abs/pow/atan/wait/random и т.д.)
                System.out.println(parameters(method.getParameterCount(), method)); /* метод для вывода типа передаваемых в метод параметра(ов)
                 getParameterCount() - получаем количество параметров передаваемых в рассматриваемый метод (в классе Math их от 0 до 2)*/

                 /* Ниже способ номер два одной строкой для методов — просто удаляем лишнее по заданию из строки,
                 но привязываемся к текущему значению реплейса */
                 //System.out.println((String.valueOf(method).replace("java.lang.Math.", "")));
            }
        }

        for (Field field : fields) { //перебираем все методы класса Math, которые мы получили в строке 13
            if ((field.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC) {//по заданию нам необходимо напечатать только публичные поля

                System.out.print(modifiers(field.getModifiers())); // читаем строки номер 21 и 22
                System.out.print(field.getType() + " "); // получаем тип поля (в текущем задании оба числа Е и Пи имеют тип double)
                System.out.println(field.getName()); //получаем имя поля (E/PI и еще несколько, не проходящих условие "public")

                 /* Ниже способ номер два одной строкой для полей — просто удаляем лишнее по заданию из строки,
                 но привязываемся к текущему значению реплейса */
                 //System.out.println((String.valueOf(field).replace("java.lang.Math.", "")));
            }
        }
    }

    private static String modifiers(int mods) {
        switch (mods) { /* модификаторы хранятся одним числом в двоичном виде, но т.к. командой getModifiers мы получаем их значение
             в десятичной системе счисления, то и свич привязываем к ней. Например первая единица в двоичной системе счисления
             отвечает за "public", значит все возвращаемые в десятичной системе счисления нечетные числа будут указывать на публичный тип.
             бинарные значения чисел читаем справа налево. */
            case 1: //0001 - в бинарном: первый бит отвечает за модификатор "public"
                return "public ";
            case 9: //1001 - в бинарном: первый бит читаем выше, 4й бит отвечает за модификатор "static"
                return "public static ";
            case 17: //10001 - в бинарном: первый читаем выше, 5й бит отвечает за модификатор "final"
                return "public final ";
            case 25: //11001 - в бинарном: первый, четвёртый и пятый читаем выше
                return "public static final ";
            case 257://100000001 - в бинарном: первый читаем выше, 9й бит отвечает за модификатор "native"
                return "public native ";
            case 273://100010001 - в бинарном. первый, пятый и девятый биты читаем выше
                return "public final native ";
            default: /* применялся во время выполнения для поиска неопределённых значений, так же реализован тут, что бы не было
                 необходимости писать "return" вне свича. */
                return null + " ";
        }
    }

    private static String parameters(int count, Method method) {
        switch (count) { /*count = getParameterCount() - строка 26
             method.getParameterTypes() - возвращает массив с типами передаваемых в метод параметров
             например, для метода, в которые передаются параметры (float,double) массив будет выглядеть:
             method.getParameterTypes()[0] - float
             method.getParameterTypes()[1] - double*/
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
