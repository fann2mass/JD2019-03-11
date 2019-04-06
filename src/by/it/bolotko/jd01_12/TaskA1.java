package by.it.bolotko.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TaskA1 {

    private List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        TaskA1 task = new TaskA1();
        for (int i = 0; i < 30; i++) {
            task.list.add((int) (Math.random() * 10) + 1);
        }
        System.out.println("Before clearBad: " + task.list);
        task.clearBad(task.list);
        System.out.println("After clearBad: " + task.list);
    }

    private void clearBad(List<Integer> grades) {
        Iterator<Integer> iterator = grades.iterator();
        while (iterator.hasNext()) {
            int grade = iterator.next();
            if (grade < 4) iterator.remove();
        }
        //или можно ещё решить таким способом:
        //grades.removeIf(i->(i<4));
    }
}
