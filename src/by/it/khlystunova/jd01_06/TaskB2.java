package by.it.khlystunova.jd01_06;
/*Вывести через \n все предложения текста в порядке
возрастания количества символов (!) в каждом из них.
В предложениях нужно сначала заменить все небуквенные символы
и их последовательности на один пробел и выполнить trim() для каждого предложения.*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {
        Pattern point = Pattern.compile("[./]+");
        String[] array = point.split(Poem.text);//делим текст на предложения.
        StringBuilder[] arrayBuilders = new StringBuilder[array.length];
        //делаем из массива string такой же массив stringBuilder так же делаем trim() для каждого предложения.
        for (int i = 0; i < array.length; i++) {
            StringBuilder s = new StringBuilder(array[i].trim());
            arrayBuilders[i]= s;
        }
        //берем предложение, заменяем в нем все небуквенные символы и их посдедовательности на 1 пробел
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