package by.it.bildziuh.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {

    private static String getPath(Class<?> cl, String name) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String classDir = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        return path + classDir + File.separator + name;
    }

    public static void main(String[] args){
        String inpTxt = getPath(TaskB.class, "text.txt");
        String outTxt = getPath(TaskB.class, "resultTaskB.txt");
        process(inpTxt, outTxt);
    }

    private static void process(String input, String output) {
        Pattern wordsPattern = Pattern.compile("[а-яА-ЯЁё]+");
        Pattern symbolsPattern = Pattern.compile("[^ а-яА-ЯЁё]+");

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(input));
             PrintWriter printWriter = new PrintWriter(new FileWriter(output))
        ) {
            int countWords = 0;
            int countSymbols = 0;

            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                Matcher words = wordsPattern.matcher(line);
                Matcher symbols = symbolsPattern.matcher(line);

                while (words.find())
                    countWords++;
                while (symbols.find())
                    countSymbols++;
            }

            printWriter.printf("words=%d, punctuation marks=%d", countWords, countSymbols);
            System.out.printf("words=%d, punctuation marks=%d", countWords, countSymbols);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}