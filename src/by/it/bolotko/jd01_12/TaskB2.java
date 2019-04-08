package by.it.bolotko.jd01_12;

import java.util.*;

public class TaskB2 {

    public static void main(String[] args) {
        Scanner quantity = new Scanner(System.in);
        System.out.print("Quantity people: ");
        int n = quantity.nextInt();
        String[] name = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print((i + 1) + " person's name: ");
            name[i] = quantity.next();
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


    //static String process(ArrayList<String> peoples) {
    //int count = 0;
    //Iterator<String> it = peoples.iterator();
    //while (peoples.size() > 1) {
    //if (it.hasNext()) {
    // it.next();
    //count++;
    //if (count == 2) {
    // it.remove();
    // count = 0;
    // System.out.println(peoples);
    //}
    // } else {
    // it = peoples.iterator();
    // }
    //  }
    //    return peoples.toString();
    // }
}
