package by.it.bolotko.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String[] args) {
        StringBuilder sb=new StringBuilder(Poem.text);   //создадим КлассБилдер в котором будем размещать текст при обработке
        Pattern word4=Pattern.compile("[а-яА-ЯёЁ]{4,}");  //регулярное выражение [все слова от а-я, от А-Я, ё, Ё] {от 4 букв до бесконечности}
        Matcher matcher = word4.matcher(sb); //чтобы переберать слова используем матчер, он на основе выше указонного выражения будет пробегать по всем словам
        while (matcher.find()){  //до тех пор пока Матчер что-либо находит {.......
            sb.setCharAt(matcher.start()+3,'#'); // СетЧарЭт (в нужную позицию (от начала строки +3 индекса= 4 буква, устанавливает символ #)
            if (matcher.end()-matcher.start()>6)     // если (индекс последней буквы в строке - индекс первой буквы = колличество элементов в строке) больше 7 элементов, то......
            sb.setCharAt(matcher.start()+6,'#'); // СетЧарЭт (в нужную позицию (от начала строки +6 индекса= 7 буква, устанавливает символ #)
        }
        System.out.println(sb);
    }
}
