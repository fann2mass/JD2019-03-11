package by.it.zalesky.jd01_12;

import java.util.*;

public class TaskB1 {

    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        List<String> stringList = new ArrayList<>();
        System.out.println("Type 'end' for exit");
        for(;;){
            String s = scanner.next();
            if (s.equals("end")) break;
            s = s.replaceAll("[^A-z']","").trim();
            if (!s.equals("")) stringList.add(s);
        }
        System.out.println(Counter.count(stringList));
    }

    public static class Counter{

        public static Map<String, Integer> count(List<String> list){
            Map<String, Integer> map = new HashMap<>();
            list.forEach(element -> {
                if (!map.containsKey(element)){
                    map.put(element, 1);
                }else {
                    map.put(element, map.get(element) + 1);
                }
            });
            return map;
        }
    }
}
