package by.it.zalesky.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class TaskA2 {

    private static String[] w1 = {};
    private static int[] count = {};

    private static int pos(String word) {
        for (int i = 0; i < w1.length; i++) {
            if (w1[i].equals(word))
                return i;

        }

        return -1;

    }

    public static void main(String[] args) {

        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()) {
            String word = matcher.group();
            int p1 = pos(word);
            if (p1 >= 0) {
                count[p1]++;

            }

            else {
                int l = w1.length;
                w1 = Arrays.copyOf(w1, l+1);
                w1[l] = word;
                count = Arrays.copyOf(count, l+1);
                count[l]=1;
            }

            for (int i = 0; i < w1.length; i++) {
                System.out.println(w1[i]+"="+count[i]);
            }
        }

    }

}








