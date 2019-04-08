package by.it.bolotko.jd01_12;

import java.util.*;

public class TaskB1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String string;
        StringBuilder str= new StringBuilder();
        while (!(string=scan.nextLine()).equals("end")){
            str.append(string);
        }

        str = new StringBuilder(str.toString().replaceAll("[—\\s,.:!?;]+", " "));

        Map<String, Integer> map = new HashMap<>();
        for(String s: str.toString().split(" ")) {
            if(map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            }
            else {
                map.put(s, 1);
            }
        }
        map.remove("");
        System.out.println(map);
    }
}
