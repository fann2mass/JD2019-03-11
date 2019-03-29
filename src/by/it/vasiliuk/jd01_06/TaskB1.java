package by.it.vasiliuk.jd01_06;


import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TaskB1 {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]{2,}");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()) {
            String word = matcher.group();
            process(word);
        }
    }
    private static void process(String word) {
        String newWord = word.toLowerCase();
        char first = newWord.charAt(0);
        char last = newWord.charAt(newWord.length()-1);
        if(first!='а'&&first!='о'&&first!='и'&&first!='е'&&first!='ё'&&first!='э'&&first!='ы'&&first!='у'&&first!='ю'&&first!='я'){
            if(last=='а'||last=='о'||last=='и'||last=='е'||last=='ё'||last=='э'||last=='ы'||last=='у'||last=='ю'||last=='я'){
                System.out.println(word);
            }
        }
    }
}