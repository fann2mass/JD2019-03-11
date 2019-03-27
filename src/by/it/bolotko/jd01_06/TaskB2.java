package by.it.bolotko.jd01_06;

//import java.util.regex.Matcher;
//import java.util.regex.Pattern;


public class TaskB2 {
    public static void main(String[] args) {
        String result=Poem.text.replaceAll("\n"," ");
        result=result.replaceAll("[^а-яА-ЯёЁ!. ]","");
        result=result.replaceAll("[\\s]+"," ");
        System.out.println(result);
        result=result.replace("...","");
        String[] wordArray = result.split("[.!]+");
        for (int i = 0; i < wordArray.length; i++) {
            wordArray[i] = wordArray[i].trim();
        }

        for (int i = 0; i < wordArray.length; i++) {
            for (int j = 0; j < wordArray.length-i-1; j++) {
                if (wordArray[j].length()>wordArray[j+1].length()){
                    String temp=wordArray[j];
                    wordArray[j]=wordArray[j+1];
                    wordArray[j+1]=temp;
                }
            }
        }
        for (int i = 0; i < wordArray.length; i++) {
            System.out.print(wordArray[i]+"\n");
        }
    }
}
