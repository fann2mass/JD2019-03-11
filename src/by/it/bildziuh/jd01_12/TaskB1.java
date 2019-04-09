package by.it.bildziuh.jd01_12;

import java.util.*;

public class TaskB1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> words = new LinkedHashMap<String, Integer>();
        String word;
        while (!(word = scanner.next()).equals("end")) {
            if (words.containsKey(word)) {
                int newValue = words.get(word);
                words.replace(word, ++newValue);
            } else {
                words.put(word, 1);
            }
        }
        print(words);
    }


    private static void print(Map<String,Integer> list) {
        for (Map.Entry<String, Integer> entry : list.entrySet())
            System.out.println(entry.getKey() + " = " + entry.getValue());
    }

}

