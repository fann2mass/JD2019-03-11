package by.it.bildziuh.jd01_12;

import java.util.*;

public class TaskB3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<String> names = new ArrayList<>();
        String name;

        while (!(name = scanner.next()).equals("end")) {
            names.add(name);
            System.out.println(names);
        }

        ArrayList<String> resultArray = new ArrayList<>(names);
        LinkedList<String> resultLinked = new LinkedList<>(names);
        Timer t = new Timer();
        System.out.println(t+process(resultArray));
        Timer t2 = new Timer();
        System.out.println(t2+process(resultLinked));

    }


    static String process(ArrayList<String> peoples) {
        int pos = 0;

        while (peoples.size() > 1) {
            pos = ++pos % peoples.size();
            peoples.remove(pos);
        }

        return peoples.get(0);

    }


    static String process(LinkedList<String> peoples) {
        Iterator<String> iterator = peoples.iterator();
        while (peoples.size() != 1) {
            if (!iterator.hasNext())
                iterator = peoples.iterator();
            iterator.next();
            if (!iterator.hasNext())
                iterator = peoples.iterator();
            iterator.next();
            iterator.remove();
        }
        return peoples.get(0);
    }

    public static class Timer {
        private long iniTime;
        private Double Delta;

        Timer() {
            iniTime = System.nanoTime();
        }

        public String toString() {
            Delta = (double) (System.nanoTime() - iniTime) / 1000;
            iniTime = System.nanoTime();

            return " остался. Прошло " + Delta.toString() + " микросекунд.";
        }

    }

}
