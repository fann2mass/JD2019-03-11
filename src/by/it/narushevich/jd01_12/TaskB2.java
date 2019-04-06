package by.it.narushevich.jd01_12;

import java.util.*;

public class TaskB2 {

    public static void main(String[] args) {
        System.out.println("Введите число человек: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] peoples = new String[n];
        for (int i = 0; i < peoples.length; i++) {
            peoples[i] = "name" + (i + 1);
        }

        List<String> arr = Arrays.asList(peoples);
        ArrayList<String> resA = new ArrayList<>(arr);
        LinkedList<String> resL = new LinkedList<>(arr);
        String resultA = process(resA);
        String resultL = process(resL);
        System.out.println("Последним останется " + resultA);
        System.out.println("Последним останется " + resultL);

    }

    static String process(LinkedList<String> peoples) {
        int safePos = 0;
        int step = 2;
        for (int i = 0; i < peoples.size(); i++) {
            safePos = (safePos + step) % (i + 1);
        }
        String s = Integer.toString(safePos);

        ListIterator<String> listIt = peoples.listIterator();
        while (listIt.hasNext()) {
            if (listIt.next().endsWith(s))
                return listIt.next();
        }
        return listIt.next();
    }


    static String process(ArrayList<String> peoples) {
        int pos = 0;
        int step = 2;
        while (peoples.size() != 1) {
            pos = (pos + step - 1) % peoples.size();
            peoples.remove(pos);
        }
        return peoples.get(0);
    }
}
