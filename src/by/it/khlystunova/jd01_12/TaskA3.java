package by.it.khlystunova.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int post = 0;
        while (true){
            String n = scanner.next();
            if(n.equals("end"))break;
            Integer next = Integer.parseInt(n);
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
