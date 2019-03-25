package by.it.khlystunova.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
  В каждом слове текста 4-ю и 7-ю буквы заменить символом #.
  Для слов короче 4 символов корректировку не выполнять.
   Для слов короче 7 символов заменять только 4-ю букву.
 */

public class TaskA1 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(Poem.text);
        System.out.println(sb);
        Pattern word4 = Pattern.compile("[а-яА-ЯёЁ]{4,}");
        Matcher matcher = word4.matcher(sb);//создали объект matcher на основании шаблона word4 и передали ему наш объект StringBuilder.
        while(matcher.find()){//ищет последовательность символов, соответствующих шаблону word4, в любом месте строки.
            sb.setCharAt(matcher.start()+3,'#');//когда matcher нашел нужное нам слово(не меньше 4 символов),берем с начала слова 4 символ и меняем его на #
            if(matcher.group().length()>6)//если слово больше 7 символов, то заменяем 7 символ #.
            sb.setCharAt(matcher.start()+6,'#');
        }
        System.out.println(sb);

    }
}
