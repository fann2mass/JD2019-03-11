package by.it.akhmelev.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        Test(list);
        System.out.println("----------My ListA----------");
        list=new ListA<>();
        Test(list);

    }

    private static void Test(List<String> list) {
        list.add("one");
        list.add("two");
        System.out.println(list);
        list.add("three");
        System.out.println(list);
        System.out.println("Index 1 value = "+list.get(1));
        list.remove(1);
        System.out.println(list);
    }
}
