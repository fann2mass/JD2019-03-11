package by.it._tasks_.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Test(list);
        List<String> listA = new ListA<>();
        System.out.println("Мой лист:");
        Test(listA);
    }

    private static void Test(List<String> list) {
        list.add("one");
        list.add("two");
        System.out.println(list);
        list.remove(1);
        System.out.println(list);
    }
}
