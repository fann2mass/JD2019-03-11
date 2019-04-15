package by.it.zalesky.jd01_12;

import java.util.*;

public class TaskB2 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>(){{
            add("1");
            add("2");
            add("3");
            add("4");
            add("5");
        }};
        processList(list);
    }

    public static String process(ArrayList<String> peoples){
        return processList(peoples);
    }
    public static String process(LinkedList<String> peoples){
        return processList(peoples);
    }

    private static String processList(List<String> peoples) {
        int count = 1;
        Iterator iterator = peoples.iterator();
        while (peoples.size() != 1) {
            if (iterator.hasNext()){
                iterator.next();
                if(count % 2 == 0){
                    iterator.remove();
                }
                count++;
            }else {
                iterator = peoples.iterator();
            }
        }
        return peoples.get(0);
    }
}
