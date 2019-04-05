package by.it.akhmelev.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        List<Integer> list=new ArrayList<>();
        int pos=0;
        for(;;){
            String s=scanner.next();
            if (s.equals("end")) break;
            Integer n=Integer.valueOf(s);
            if (n<0)
                list.add(n);
            else if (n==0)
                list.add(pos,n);
            else
                list.add(pos++,n);
        }
        System.out.println(list);


    }
}
