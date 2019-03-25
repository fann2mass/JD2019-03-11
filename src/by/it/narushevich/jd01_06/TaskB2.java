package by.it.narushevich.jd01_06;

import java.util.Arrays;
import java.util.Comparator;

public class TaskB2 {

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder(Poem.text);
        for (int index = 0; index < sb.length(); index++) {
            if (sb.charAt(index) == ',') sb.setCharAt(index, ' ');
            else if (sb.charAt(index) == ':') sb.setCharAt(index, ' ');
            else if (sb.charAt(index) == ';') sb.setCharAt(index, ' ');
            else if (sb.charAt(index) == '-') sb.setCharAt(index, ' ');
            else if (sb.charAt(index) == '\n') sb.setCharAt(index, ' ');
        }
        String stringWithoutComma = sb.toString().replace("...", " ");

        String[] sentences = stringWithoutComma.split("[.!?]+");

        String[] sortSentences = {};

        for (String sentence : sentences) {
            String trimSentence = sentence.trim();
            String sentenceWithoutSpace = trimSentence.replaceAll("[\\s]+", " ");
            sortSentences = Arrays.copyOf(sortSentences, sortSentences.length+1);
            sortSentences[sortSentences.length-1] = sentenceWithoutSpace;
        }

        Comparator<String> stringLengthComparator = new StringLengthSort();

        Arrays.sort(sortSentences,stringLengthComparator);
        for (String sortSentence : sortSentences) {
            System.out.println(sortSentence);
        }
    }

}
