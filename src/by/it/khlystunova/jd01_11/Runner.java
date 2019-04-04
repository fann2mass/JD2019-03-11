package by.it.khlystunova.jd01_11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Runner {
    public static void main(String[] args) {
       /* List<String> list = new ArrayList<>();
        TestA(list);
        System.out.println("----------My ListA----------");
        list = new ListA<>();
        TestA(list);
        System.out.println("----------My ListB----------");
        list=new ListB<>();
        TestB(list);*/
        //TaskC
        Set<String> array = new HashSet<>();
        TaskC(array);
        System.out.println("----------My SetC----------");
        array=new SetC<>();
        TaskC(array);

    }

    private static void TaskC(Set<String> array) {
        System.out.println(array);
        System.out.println("добавляем в массив [one, two, two, three]");
        array.add("one");
        array.add("two");
        array.add("two");
        array.add("three");
        System.out.println(array);
        System.out.println("Удаляем элемент two");
        array.remove("two");
        System.out.println(array);
        System.out.println("Есть ли в массиве элемент - one ?");
        boolean one = array.contains("one");
        System.out.println(one);
        System.out.println("Есть ли в массиве элемент - five ?");
        boolean five = array.contains("five");
        System.out.println(five);
        System.out.println("Размер массива равен:");
        System.out.println(array.size());
        System.out.println("Массив пустой?");
        System.out.println(array.isEmpty());
        System.out.println("добавляем в массив five seven seven");
        Set<String> array2 = new HashSet<>();
        array2.add("five");
        array2.add("seven");
        array2.add("seven");
        System.out.println("Коллекция "+ array2);
        array.addAll(array2);
        System.out.println(array);
        System.out.println("есть ли в массиве все элементы из коллекции?");
        boolean b = array.containsAll(array2);
        System.out.println(b);
        System.out.println("удаляем из массива коллекцию  "+array2);
        array.removeAll(array2);
        System.out.println(array);

    }


    private static void TestA(List<String> list) {
        list.add("one");
        list.add("two");
        list.add("three");
        System.out.println(list);
        System.out.println("Index 1 value = "+list.get(1));
        list.remove(1);
        System.out.println(list);
    }
    private static void TestB(List<String> list) {
        TestA(list);
        List<String> list2 = new ListB<>();
        list2.add("4");
        list2.add("5");
        list2.add("6");
        System.out.println("Проверяем addAll массив list2 "+list2);
        System.out.println("изначальный лист "+ list);
        list.addAll(list2);
        System.out.println("Массив list плюс list2");
        System.out.println("Ожидается массив из 5 элементов:[one, three, 4, 5, 6]");
        System.out.println(list);
        System.out.println("Проверяем добовления элемента на указ. позицию");
        list.add(1,"index");
        System.out.println(list);
        System.out.println("Проверяем set(2,new) в list");
        String elemInIndex = list.set(2, "new");
        System.out.println("начальный элемент в позиции 2 "+elemInIndex);
        System.out.println(list);


    }
}
