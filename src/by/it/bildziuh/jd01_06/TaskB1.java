package by.it.bildziuh.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]{3,}");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()) {
            String word = matcher.group();
            compare(word);

        }
    }

    private static void compare(String word) {
        char[] vowels = {'а', 'я', 'о', 'ё', 'ы', 'и', 'э', 'е', 'у', 'ю'};
        String sorted = word.toLowerCase();

        for (int i = 0; i < vowels.length; i++) {
            if (sorted.charAt(0) != vowels[5] && sorted.charAt(sorted.length() - 1) == vowels[i])
                System.out.println(word);

        }
    }
}

