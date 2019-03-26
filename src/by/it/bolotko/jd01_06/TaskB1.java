package by.it.bolotko.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {

        String[] wordArray = Poem.text.split("[\\s,.:!?]+");
        Pattern pattern = Pattern.compile("^[бвгджзйклмнпрстфхцчшщБВГДЖЗЙКЛМНПРСТФХЦЧШЩ].*[аоэиуыеёюяАОЭИУЫЕЁЮЯ]$");
        for (String word : wordArray) {
            Matcher matcher = pattern.matcher(word);
            if (matcher.find()) {
                System.out.println(word);
            }
        }
    }
}
