package by.it.narushevich.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {

    private static String[] writeWords = new String[0];
    private static String[] wrongWords = new String[0];

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(Poem.text);
        Pattern word2 = Pattern.compile("[а-яА-ЯёЁ]{2,}");
        Matcher match = word2.matcher(sb);
        while (match.find()) {
            String word = match.group();
            checkFirstVowal(word);
        }

        for (String word : writeWords) System.out.println(word);
    }

    private static void addToWrite(String word){
        writeWords = Arrays.copyOf(writeWords, writeWords.length+1);
        writeWords[writeWords.length-1] = word;
    }

    private static void addToWrong(String word){
        wrongWords = Arrays.copyOf(wrongWords, wrongWords.length+1);
        wrongWords[wrongWords.length-1] = word;
    }

    private static void checkFirstVowal(String word){
        if (word.startsWith("а")||word.startsWith("А")) addToWrong(word);
        else if (word.startsWith("е")||word.startsWith("Е")) addToWrong(word);
        else if (word.startsWith("ё")||word.startsWith("Ё")) addToWrong(word);
        else if (word.startsWith("и")||word.startsWith("И")) addToWrong(word);
        else if (word.startsWith("о")||word.startsWith("О")) addToWrong(word);
        else if (word.startsWith("у")||word.startsWith("У")) addToWrong(word);
        else if (word.startsWith("э")||word.startsWith("Э")) addToWrong(word);
        else if (word.startsWith("ю")||word.startsWith("Ю")) addToWrong(word);
        else if (word.startsWith("я")||word.startsWith("Я")) addToWrong(word);
        else checkLastVowal(word);
    }

    private static void checkLastVowal(String word){
        if (word.endsWith("а")) addToWrite(word);
        else if (word.endsWith("е")) addToWrite(word);
        else if (word.endsWith("ё")) addToWrite(word);
        else if (word.endsWith("и")) addToWrite(word);
        else if (word.endsWith("о")) addToWrite(word);
        else if (word.endsWith("у")) addToWrite(word);
        else if (word.endsWith("ы")) addToWrite(word);
        else if (word.endsWith("э")) addToWrite(word);
        else if (word.endsWith("ю")) addToWrite(word);
        else if (word.endsWith("я")) addToWrite(word);
        else addToWrong(word);
    }
}