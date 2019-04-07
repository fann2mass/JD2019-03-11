package by.it.bolotko.jd01_12;

import java.util.*;

public class TaskB3 {

    public static void main(String[] args) {
        int n = 4096;
        System.out.print("Quantity people: " + n);
        String[] name = new String[n];
        for (int i = 0; i < n; i++) {
            name[i] = String.valueOf(((Math.random() * 10) + 1));
            System.out.print((i + 1) + " person's name: " + name[i]);
            System.out.println();
        }
        List<String> base = Arrays.asList(name);
        ArrayList<String> arra = new ArrayList<>(base);
        LinkedList<String> arrl = new LinkedList<>(base);

        process(arra);
        System.out.println("Result ArrayList: " + arra);

        process(arrl);
        System.out.println("Result LinkedList: " + arrl);
    }

    private static String process(ArrayList<String> peoples) {
        Iterator<String> iterator = peoples.iterator();
        while (peoples.size() != 1) {
            if (!iterator.hasNext())
                iterator = peoples.iterator();
            iterator.next();
            if (!iterator.hasNext())
                iterator = peoples.iterator();
            iterator.next();
            iterator.remove();
        }
        return peoples.get(0);
    }

    private static String process(LinkedList<String> peoples) {
        Iterator<String> iterator = peoples.iterator();
        while (peoples.size() != 1) {
            if (!iterator.hasNext())
                iterator = peoples.iterator();
            iterator.next();
            if (!iterator.hasNext())
                iterator = peoples.iterator();
            iterator.next();
            iterator.remove();
        }
        return peoples.get(0);
    }
}
