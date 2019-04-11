package by.it.khlystunova.jd01_12;

import java.util.*;

/*Скопируйте предыдущую задачу и измерьте на размере задачи в 4096 элемент
 какой из двух методов работает быстрее. Объясните итог.
Подумайте, как можно было бы решить задачу в методе prоcess(LinkedList<String> peoples)
 без итератора и снижения быстродействия, используя интерфейсы очередей.
 Проверьте свою идею.*/

/*
 * Метод с параметром типа LinkedList, будет работать быстрее, потому что
 * при удалении элемента из LinkedList ,
 * временная сложность = О(1)(нужно поменять две ссылки и 2 удалить.),
 * а при удалении из ArrayList ,
 * временная сложность = О(n)(нужно подвинуть все последующие индексы на еденицу влево)
* */
public class TaskB3 {
    public static void main(String[] args) {
        List<String> base = new ArrayList<>();
        for (int i = 0; i < 1024; i++) {
            base.add("lisa");
            base.add("misha");
            base.add("olia");
            base.add("stas");
        }
        ArrayList<String> arrayList = new ArrayList<>(base);
        LinkedList<String> linkedList = new LinkedList<>(base);
        String people1 = TaskB3.process(arrayList);
        String people2 = TaskB3.process(linkedList);
        System.out.println(people1);
        System.out.println(people2);
    }

    private static String process(ArrayList<String> arrayList) {
        Iterator<String> iterator = arrayList.iterator();
        while(arrayList.size()!=1){
            if(!iterator.hasNext())
                iterator = arrayList.iterator();
            iterator.next();
            if (!iterator.hasNext())
                iterator = arrayList.iterator();
            iterator.next();
            iterator.remove();
        }
        return arrayList.get(0);

    }
    private static String process(LinkedList<String> linkedList) {
        while (linkedList.size()!=1) {
            String poll = linkedList.poll();
            linkedList.offer(poll);
            linkedList.remove();
        }
        return linkedList.get(0);
    }

}
