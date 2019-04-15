package by.it.zalesky.jd01_12;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TaskB3 {

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<String>(){{
            add("1");
            add("2");
            add("3");
            add("4");
            add("5");
        }};
        process(list);
    }

    public static String process(ArrayList<String> peoples){
        return TaskB2.process(peoples);
    }
    public static String process(LinkedList<String> peoples){
        int count = 1;
        Queue<String> queue = peoples;
        while (queue.size() != 1){

            if (count % 2 != 0){
                queue.offer(queue.poll());
            }else {
                queue.poll();
            }

            count ++;
        }
        return queue.element();
    }
}
