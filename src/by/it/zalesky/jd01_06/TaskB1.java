package by.it.zalesky.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {

    private static String[] fitWords = new String[0];
    private static String[] notFitWords = new String[0];

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(Poem.text);
        Pattern word2 = Pattern.compile("[а-яА-ЯёЁ]{2,}");
        Matcher match = word2.matcher(sb);
        while (match.find()) {
            String word = match.group();
            checkFirsLetter(word);
        }

        for (String word : fitWords) {
            System.out.println(word);
        }
    }

    private static void addFitWords(String word){
        fitWords = Arrays.copyOf(fitWords, fitWords.length+1);
        fitWords[fitWords.length-1] = word;
    }

    private static void wrongWords(String word){
        notFitWords = Arrays.copyOf(notFitWords, notFitWords.length+1);
        notFitWords[notFitWords.length-1] = word;
    }

    private static void checkFirsLetter(String word){
        if (word.startsWith("а")||word.startsWith("А")) wrongWords(word);
        else if (word.startsWith("е")||word.startsWith("Е")) wrongWords(word);
        else if (word.startsWith("ё")||word.startsWith("Ё")) wrongWords(word);
        else if (word.startsWith("и")||word.startsWith("И")) wrongWords(word);
        else if (word.startsWith("о")||word.startsWith("О")) wrongWords(word);
        else if (word.startsWith("у")||word.startsWith("У")) wrongWords(word);
        else if (word.startsWith("э")||word.startsWith("Э")) wrongWords(word);
        else if (word.startsWith("ю")||word.startsWith("Ю")) wrongWords(word);
        else if (word.startsWith("я")||word.startsWith("Я")) wrongWords(word);
        else checkLastLetter(word);
    }

    private static void checkLastLetter(String word){
        if (word.endsWith("а")) addFitWords(word);
        else if (word.endsWith("е")) addFitWords(word);
        else if (word.endsWith("ё")) addFitWords(word);
        else if (word.endsWith("и")) addFitWords(word);
        else if (word.endsWith("о")) addFitWords(word);
        else if (word.endsWith("у")) addFitWords(word);
        else if (word.endsWith("ы")) addFitWords(word);
        else if (word.endsWith("э")) addFitWords(word);
        else if (word.endsWith("ю")) addFitWords(word);
        else if (word.endsWith("я")) addFitWords(word);
        else wrongWords(word);
    }
}