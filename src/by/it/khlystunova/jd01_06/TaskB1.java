package by.it.khlystunova.jd01_06;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Вывести в консоль все слова текста,
начинающихся согласной и заканчивающихся гласной буквой
(нужно сделать для проверки этого условия приватный метод без regex).*/
public class TaskB1 {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]{2,}");//создали шаблон со ссылкой pattern
        Matcher matcher = pattern.matcher(Poem.text);//т.к у класса Matcher нет своего конструктора,создаем его через pattern.matcher(Последовательность символов для сопоставления).
        while (matcher.find()) {//find находим начало слова удв. шаблону
           String word = matcher.group();//group возвращает всю посдедовательность(слово целиком) удв. шаблону.
            process(word);
        }
    }
    //самая тривиальная реализация
    private static void process(String word) {
        String newWord = word.toLowerCase();
    char first = newWord.charAt(0);
    char last = newWord.charAt(newWord.length()-1);
    if(first!='а'&&first!='о'&&first!='и'&&first!='е'&&first!='ё'&&first!='э'&&first!='ы'&&first!='у'&&first!='ю'&&first!='я'){
     if(last=='а'||last=='о'||last=='и'||last=='е'||last=='ё'||last=='э'||last=='ы'||last=='у'||last=='ю'||last=='я'){
         System.out.println(word);
      }
     }
    }
}
