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
        for (String man : peoples) {
            System.out.println(man);
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
        return null;
    }

    static String process(ArrayList<String> peoples) {
        return null;
    }


}
