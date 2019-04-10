package by.it.narushevich.jd01_12;

import java.util.*;

public class TaskC1 {
    public static void main(String[] args) {
        List<String> cFirst = new ArrayList<>();
        Map<String, Integer> c1 = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        String text;
        StringBuilder sb = new StringBuilder();
        for (; ; ) {
            text = scanner.nextLine();
            if (text.equals("end")) break;
            sb.append(text).append('\n');
        }
        String[] list = sb.toString().split("\n");
        for (int i = 0; i < list.length; i++) {
            cFirst.add(list[i]);
            c1.put(list[i], i + 1);
        }

        System.out.println(cFirst);
        c1.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .forEach(System.out::println);
    }
}
