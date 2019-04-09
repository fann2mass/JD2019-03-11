package by.it.bildziuh.jd01_12;

import java.util.*;

public class TaskB1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> list = new HashMap<>();
        splitToWords(scanner, list);
        print(list);
    }

    private static void splitToWords(Scanner scanner, Map<String, Integer> list) {
        String line;
        String[] words;

        while (!(line = scanner.nextLine()).equals("end")) {
            line = line.replaceAll("[,\";.—]", " ");
            line = line.replace("isn't", "don't");
            words = line.split(" ");
            WordsCount(words, list);
        }
    }

    private static void WordsCount(String[] words, Map<String, Integer> list) {
        for (String word : words) {
            if (list.containsKey(word)) {
                int newValue = list.get(word);
                list.replace(word, ++newValue);
            } else
                list.put(word, 1);
        }
    }

    private static void print(Map<String, Integer> list) {
        for (Map.Entry<String, Integer> entry : list.entrySet())
            System.out.println(entry.getKey() + "=" + entry.getValue());
    }

}

