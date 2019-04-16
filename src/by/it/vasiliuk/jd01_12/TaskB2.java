package by.it.vasiliuk.jd01_12;

import java.util.*;

public class TaskB2 {
    public static void main(String[] args) {
        String[] array ={"1","2","3","4","5","6"};
        List<String> base = Arrays.asList(array);
        ArrayList<String> arrayList = new ArrayList<>(base);
        LinkedList<String> linkedList = new LinkedList<>(base);
        String people1 = TaskB2.process(arrayList);
        String people2 = TaskB2.process(linkedList);
        System.out.println(people1);
        System.out.println(people2);
    }

    private static String process(ArrayList<String> arrayList) {
        Iterator<String> iter = arrayList.iterator();
        while(arrayList.size()!=1){
            if(!iter.hasNext())
                iter = arrayList.iterator();
            iter.next();
            if (!iter.hasNext())
                iter = arrayList.iterator();
            iter.next();
            iter.remove();
        }
        return arrayList.get(0);

    }
    private static String process(LinkedList<String> linkedList) {
        Iterator<String> iterator = linkedList.iterator();
        while(linkedList.size()!=1){
            if(!iterator.hasNext())
                iterator = linkedList.iterator();
            iterator.next();
            if (!iterator.hasNext())
                iterator = linkedList.iterator();
            iterator.next();
            iterator.remove();
        }
        return linkedList.get(0);
    }

}