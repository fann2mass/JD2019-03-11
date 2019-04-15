package by.it.vasiliuk.jd01_11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Runner {
    public static void main(String[] args) {
        List<String> list_full = new ArrayList<>();
        TestA(list_full);
        System.out.println("List A");
        list_full = new ListA<>();
        TestA(list_full);
        System.out.println("List B");
        list_full=new ListB<>();
        TestB(list_full);
        Set<String> array = new HashSet<>();
        TaskC(array);
        System.out.println("Set C");
        array=new SetC<>();
        TaskC(array);

    }

    private static void TaskC(Set<String> array) {
        System.out.println(array);
        System.out.println("Array adjunction [one, two, two, three]");
        array.add("one");
        array.add("two");
        array.add("two");
        array.add("three");
        System.out.println(array);
        System.out.println("Removing element two");
        array.remove("two");
        System.out.println(array);
        System.out.println("Cheking if element - one exists");
        boolean one = array.contains("one");
        System.out.println(one);
        System.out.println("Cheking if element - five exists");
        boolean five = array.contains("five");
        System.out.println(five);
        System.out.println("Array capability:");
        System.out.println(array.size());
        System.out.println("Emptyness checking");
        System.out.println(array.isEmpty());
        System.out.println("Adjunction five seven seven");
        ArrayList<String> array2 = new ArrayList<>();
        array2.add("five");
        array2.add("seven");
        array2.add("seven");
        array2.add("nine");
        System.out.println("Collection "+ array2);
        array.addAll(array2);
        System.out.println(array);
        System.out.println("Do elements fullfill the collection");
        boolean b = array.containsAll(array2);
        System.out.println(b);
        System.out.println("Collection removal  "+array2);
        array.removeAll(array2);
        System.out.println(array);
        System.out.println("Full clearing");
        array.clear();
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
        System.out.println("Checking addall in list2 "+list2);
        System.out.println("Primal list "+ list);
        list.addAll(list2);
        System.out.println("Adjunction list with list2");
        System.out.println("Expected five elements array:[one, three, 4, 5, 6]");
        System.out.println(list);
        System.out.println("Proper position adjunction");
        list.add(1,"index");
        System.out.println(list);
        System.out.println("Checking set(2,new) в list");
        String elemInIndex = list.set(2, "new");
        System.out.println("Primal element in 2 position "+elemInIndex);
        System.out.println(list);


    }
}
