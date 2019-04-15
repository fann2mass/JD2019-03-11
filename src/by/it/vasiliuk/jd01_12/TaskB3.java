package by.it.vasiliuk.jd01_12;

import java.util.*;

public class TaskB3 {
    public static void main(String[] args) {
        List<String> base = new ArrayList<>();
        for (int i = 0; i < 1024; i++) {
            base.add("name_1");
            base.add("name_2");
            base.add("name_3");
            base.add("name_4");
        }
        ArrayList<String> arrayList = new ArrayList<>(base);
        LinkedList<String> linkedList = new LinkedList<>(base);
        String ppl1 = TaskB3.process(arrayList);
        String ppl2 = TaskB3.process(linkedList);
        System.out.println(ppl1);
        System.out.println(ppl2);
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