package by.it.bildziuh.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {
        StringBuilder sbuilder = new StringBuilder(Poem.text);

        Pattern pattern = Pattern.compile("[^.!?]+[.!?]+");
       // Pattern replace = Pattern.compile("[.,!?:-]+");
        Matcher matcher1 = pattern.matcher(Poem.text);
      //  Matcher matcher = replace.matcher(Poem.text);

        while (matcher1.find()) {

            //String string = matcher1.replaceAll(" ");

            String string = matcher1.group();
            string = string.replaceAll("[.,!?:-]+","");
            //string = string.trim();


            System.out.printf("%s",string);


        }

    }
}
