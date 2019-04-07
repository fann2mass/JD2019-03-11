package by.it.khlystunova.jd01_12;

import java.util.*;

/*TaskC1.Нужно ввести с консоли текст до строки end.
Во входном тексте хранятся наименования некоторых объектов, по одному в строке.
Строки иногда повторяются.
Построить список C1, элементы которого содержат наименования и
уникальные шифры данных объектов, причем элементы списка должны быть
упорядочены по возрастанию шифров (шифр – некоторое случайное,
 но гарантированно уникальное число).
Затем нужно «сжать» список C1, удаляя дублирующийся наименования объектов.
Выведите полученный ассоциативный массив в консоль*/

public class TaskC1 {
    private static Map<Integer,String> map = new TreeMap<>();

    public static void main(String[] args) {

        fillMap();
        printMap();

    }

    private static void printMap() {
        Set<Map.Entry<Integer, String>> entries = TaskC1.map.entrySet();
        for (Map.Entry<Integer, String> entry : entries) {
            System.out.println(entry.getKey()+"="+entry.getValue());
        }
    }
    private static void fillMap(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            String line = scanner.next();
            if(line.equals("end"))break;
            map.put(line.hashCode(),line);
        }
    }

}
