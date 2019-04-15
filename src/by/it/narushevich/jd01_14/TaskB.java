package by.it.narushevich.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {

    public static void main(String[] args) throws IOException {
        String filename = getPathFile(TaskB.class, "text.txt");
        String fileResultToTxt = getPathFile(TaskB.class, "resultTaskB.txt");

        Pattern words = Pattern.compile("[а-яА-ЯЁё]+");
        Pattern punctuation = Pattern.compile("[,.!?:;-]+");

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));
             PrintWriter printWriter = new PrintWriter(new FileWriter(fileResultToTxt))
            ) {
            int counterWords = 0;
            int counterPunct = 0;
            while (bufferedReader.ready()) {
                String str = bufferedReader.readLine();
                Matcher matcherWord = words.matcher(str);
                while (matcherWord.find()){
                    counterWords++;
                }

                Matcher matcherPunct = punctuation.matcher(str);
                while (matcherPunct.find()){
                    counterPunct++;
                }
            }
            System.out.printf("words=%d, punctuation marks=%d",counterWords,counterPunct);
            printWriter.printf("words=%d, punctuation marks=%d",counterWords,counterPunct);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static String getPathFile(Class<?> cl, String name) throws IOException {
        String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String replacePath = cl.getPackage().getName().replace(".", File.separator);
        return src + replacePath + File.separator + name;

    }
}
