package by.it.narushevich.jd01_11;

import java.util.*;

public class Runner {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        Test(list);
        System.out.println("-------------My ListA---------------");
        list = new ListA<>();
        Test(list);
        System.out.println("-------------My ListB---------------");
        list = new ListB<>();
        Test(list);
        System.out.println("-------------My SetC----------------");
        Set<String> set = new SetC<>();
        set.add("bool");




    }

    private static void Test(List<String> list) {
        list.add("one");
        list.add("two");
        list.add("three");
        System.out.println("Index 1 value = " + list.get(1));
        list.remove(1);
        list.set(0,"new");
        System.out.println(list);
        list.add(1,"four");
        System.out.println(list);
        List<String> c = new ArrayList<>();
        c.add("six");
        c.add("seven");
        c.add("nine");
        list.addAll(c);
        System.out.println(list);



    }


}
