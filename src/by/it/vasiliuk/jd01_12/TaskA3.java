package by.it.vasiliuk.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int post = 0;
        while (true){
            String ns = scanner.next();
            if(ns.equals("end"))break;
            Integer next = Integer.parseInt(ns);
            if(next<0)
                list.add(next);
            if(next==0)
                list.add(post,next);
            if(next>0)
                list.add(post++,next);

        }
        System.out.println(list);

    }

}