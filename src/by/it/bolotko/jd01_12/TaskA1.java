package by.it.bolotko.jd01_12;

import java.util.ArrayList;
import java.util.List;

public class TaskA1 {

    private List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        TaskA1 task = new TaskA1();
        for (int i = 0; i < 30; i++) {
            task.list.add((int) (Math.random() * 10)+1);
        }
        System.out.println(task.list);
    }
}
