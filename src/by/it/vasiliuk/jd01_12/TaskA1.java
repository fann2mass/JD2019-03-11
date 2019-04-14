package by.it.vasiliuk.jd01_12;

import java.util.ArrayList;
import java.util.List;

public class TaskA1 {

    private List<Integer> grades = new ArrayList<>();

    private void clearBad(List<Integer> grades){
        grades.removeIf(next -> next < 4);
    }

    public static void main(String[] args) {
        TaskA1 instance = new TaskA1();
        for (int i = 0; i < 30; i++) {
            int gr =  (int)(Math.random()*10)+1;
            instance.grades.add(gr);
        }
        System.out.println("before "+ instance.grades);
        instance.clearBad(instance.grades);
        System.out.println("after "+ instance.grades);

    }
}