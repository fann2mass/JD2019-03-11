package by.it.khlystunova.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*Определить, сколько раз повторяется в тексте каждое слово,
 которое встречается в нем, используя массивы.
 Вывести результаты на консоль в формате слово=повторы*/
public class TaskA2 {
    private  static String[] words = new String[0];
    private static int[] counters = new int[0];

    public static void main(String[] args) {
        //почему мы тут не создаем stringBuilder?да потому что мы тут ничего не изменяем.
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");//создали шаблон со ссылкой pattern
        Matcher matcher = pattern.matcher(Poem.text);//т.к у класса Matcher нет своего конструктора,создаем его через pattern.matcher(Последовательность символов для сопоставления).
        while(matcher.find()){//find находим начало слова удв. шаблону
            String word  = matcher.group();//group возвращает всю посдедовательность(слово целиком) удв. шаблону.
            process(word);
        }
        for (int i = 0; i <words.length ; i++) {
            System.out.printf("%s=%d%n",words[i],counters[i]);

        }
    }

    private static void process(String word) {
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word)) {
                counters[i]++;
                return;
            }
        }
        words = Arrays.copyOf(words, words.length + 1);//увеличиваем массив на 1.
        words[words.length - 1] = word;//записываем переданное слово в конец массива.

        counters = Arrays.copyOf(counters, counters.length + 1);
        counters[words.length - 1] = 1;

    }
}



