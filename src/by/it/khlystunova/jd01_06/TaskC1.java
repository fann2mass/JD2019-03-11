package by.it.khlystunova.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*TaskC1. Отформатировать исходный текст с выравниванием по обоим краям.
 Для этого добавить дополнительные пробелы между словами, так чтобы ширина строк стала равной,
 а число пробелов между словами отличалось не более чем на единицу внутри каждой строки,
 причем на единицу большие последовательности пробелов должны идти с начала строки.*/
public class TaskC1 {
    public static void main(String[] args) {
        String[] array = Poem.text.split("\n");
        int max = 0;
        //находим максимальное число символов в строке.
        for (String s : array) {
            if (max < s.length())
                max = s.length();
        }
        //вызываем метод для добавления нужного кол-ва пробелов в строке и записываем результат в новый массив sb
        StringBuilder[] sb1 = new StringBuilder[array.length];
        for (int i = 0; i < array.length; i++) {
            sb1[i] = process(array[i], max);
        }
       //просто выход из ситуации...с пробелами не получалось,так что заменем вконце звездочки на пробелы.
        Pattern star = Pattern.compile("[*]");
        for (StringBuilder stringBuilder1 : sb1) {
            Matcher matcher = star.matcher(stringBuilder1);
            while (matcher.find()) {
                stringBuilder1.setCharAt(matcher.start(), ' ');
            }
        }
           //вывод отформатированного массива строк.
        for (StringBuilder stringBuilder : sb1) {
            System.out.println(stringBuilder);
        }

    }
        private static StringBuilder process(String s, int max) {
            StringBuilder sb = new StringBuilder(s);
            //Форматируем строку.
            for (int i = 0; i < sb.length();i++ ) {

                if (sb.length() == max) {
                    break;
                }
                if (sb.charAt(i) == ' ') {
                    sb.insert(i, '*');
                    i +=2;
                }else  if ((i == sb.length()-1)&&(sb.length() != max)) {
                    i = 0;
                }
            }
            return sb;
        }

}


