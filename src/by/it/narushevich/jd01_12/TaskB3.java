package by.it.narushevich.jd01_12;

import java.util.*;

public class TaskB3 {

    public static void main(String[] args) {
        System.out.println("Введите число человек: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] peoples = new String[n];
        for (int i = 0; i < peoples.length; i++) {
            peoples[i] = "name" + (i + 1);
        }

        List<String> arr = Arrays.asList(peoples);
        ArrayList<String> resA = new ArrayList<>(arr);
        LinkedList<String> resL = new LinkedList<>(arr);
        Timer t = new Timer();
        String resultA = process(resA);
        String resultL = process(resL);
        System.out.println("ArrayList " + resultA + t);
        System.out.println("LinkedList " + resultL + t);

    }

    static String process(ArrayList<String> peoples) {
        Iterator<String> it = peoples.iterator();
        while (peoples.size()!=1){
            if (!it.hasNext())
                it = peoples.iterator();
            it.next();
            if (!it.hasNext())
                it = peoples.iterator();
            it.next();
            it.remove();
        }
        return peoples.get(0);
    }

    static String process(LinkedList<String> peoples) {
        Iterator<String> it = peoples.iterator();
        while (peoples.size()!=1){
            if (!it.hasNext())
                it = peoples.iterator();
            it.next();
            if (!it.hasNext())
                it = peoples.iterator();
            it.next();
            it.remove();
        }
        return peoples.get(0);
    }

    public static class Timer {
        private long iniTime;
        Timer() {
            iniTime = System.nanoTime();
        }

        public String toString() {
            double delta = (double) (System.nanoTime() - iniTime) / 1000;
            iniTime = System.nanoTime();

            return " Прошло " + delta + " микросекунд.";
        }

    }
}
