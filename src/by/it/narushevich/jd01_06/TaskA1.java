package by.it.narushevich.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(Poem.text);
        Pattern word4=Pattern.compile("[а-яА-ЯёЁ]{4,}");
        Matcher match = word4.matcher(sb);
        while(match.find()){
            sb.setCharAt(match.start()+3, '#');
            if (match.end()-match.start()>6)
                sb.setCharAt(match.start()+6, '#');
        }
        System.out.println(sb);
    }
}
