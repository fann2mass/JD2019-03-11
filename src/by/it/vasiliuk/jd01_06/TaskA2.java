package by.it.vasiliuk.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {
    private static String[] words = new String[0];
    private static int[] counters = new int[0];
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]{4,}");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()){
            String word = matcher.group();
            process(word);
        }
    }
    private static void process(String word){
        for(int i = 0;i < words.length; i++){
            if (words[i].equals(word)){
                counters[i]++;
                return;
            }
        }
        words=Arrays.copyOf(words,counters.length+1);
        words[words.length-1]=word;

        counters=Arrays.copyOf(counters,counters.length+1);
        counters[words.length-1]=1;
    }
}
