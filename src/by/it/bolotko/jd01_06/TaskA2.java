package by.it.bolotko.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {

    private static String[] words=new String[0];
    private static int[] counters=new int[0];

    private static int process(String word){
        for (int i = 0; i <words.length; i++) {
            if (words[i].equals(word))
            return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        StringBuilder sb=new StringBuilder(Poem.text);
        Pattern pattern=Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(sb);
        while (matcher.find()){
            String word=matcher.group();
            int p = process(word);
            if (p>=0){
                counters[p]++;
            }
            else {
                int last=words.length; //последний элемент
                words=Arrays.copyOf(words, last+1);
                words[last]=word;      //запомним слово
                counters=Arrays.copyOf(counters, last+1);
                counters[last]=1;      //укажем частоту повторений = 1
            }
        }
        for (int i = 0; i < words.length; i++) {
            System.out.printf("%s=%d%n",words[i],counters[i]);
        }
    }
}
