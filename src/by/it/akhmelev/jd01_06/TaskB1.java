package by.it.akhmelev.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {

    private static final String v="уеэоаыяиюУЕЭОАЫЯИЮёЁ";

    public static void main(String[] args) {
        Pattern pattern=Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()){
            String word = matcher.group();
            if (check(word))
                System.out.println(word);
        }
    }

    private static boolean check(String word) {
        boolean first=v.indexOf(word.charAt(0))<0;
        boolean last=v.indexOf(word.charAt(word.length()-1))>=0;
        return first&&last;
    }
}
