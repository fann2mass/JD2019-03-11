package by.it.vasiliuk.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {
        Pattern point = Pattern.compile("[./]+");
        String[] array = point.split(Poem.text);
        StringBuilder[] arrayBuilders = new StringBuilder[array.length];
        for (int i = 0; i < array.length; i++) {
            StringBuilder s = new StringBuilder(array[i].trim());
            arrayBuilders[i]= s;
        }
        Pattern simbol = Pattern.compile("[^а-яА-ЯёЁ]");
        for (StringBuilder arrayBuilder : arrayBuilders) {
            Matcher matcher = simbol.matcher(arrayBuilder);
            while (matcher.find()) {
                arrayBuilder.setCharAt(matcher.start(), ' ');
            }
            System.out.println(arrayBuilder);
        }
    }

}