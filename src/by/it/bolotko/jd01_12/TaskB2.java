package by.it.bolotko.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class TaskB2 {

    public static void main(String[] args) {
        ArrayList<String> arra = new ArrayList<String>();
        LinkedList<String> arrl = new LinkedList<String>();
        Scanner quantity = new Scanner(System.in);
        System.out.print("Quantity people: ");
        int n = quantity.nextInt();
        String[] name = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print((i + 1) + " person's name: ");
            name[i] = quantity.next();
            arra.add(name[i]);
            arrl.add(name[i]);
        }
        process(arra);
        System.out.println(arra);
        process(arrl);
        System.out.println(arrl);

    }

    static String process(ArrayList<String> peoples) {
        int count = 0;
        Iterator<String> it = peoples.iterator();
        while (peoples.size() > 1) {
            if (it.hasNext()) {
                it.next();
                count++;
                if (count == 2) {
                    it.remove();
                    count = 0;
                    System.out.println(peoples);
                }
            } else {
                it = peoples.iterator();
            }
        }
        String result = peoples.toString();
        result.replaceAll("^[a-zA-Z]", "");
        return result;
    }

    static String process(LinkedList<String> peoples) {
        int count = 0;
        Iterator<String> it = peoples.iterator();
        while (peoples.size() > 1) {
            if (it.hasNext()) {
                it.next();
                count++;
                if (count == 2) {
                    it.remove();
                    count = 0;
                    System.out.println(peoples);
                }
            } else {
                it = peoples.iterator();
            }
        }
        return peoples.toString();
    }
}
