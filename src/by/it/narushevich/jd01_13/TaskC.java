package by.it.narushevich.jd01_13;

import java.util.*;

public class TaskC {

    private static int counter = 0;
    private static List<Double> list = new ArrayList<>();
    private static String text;

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        for (; ; ) {
            text = scanner.nextLine();
            readData();
        }
    }

    static void readData() throws Exception {
        try {
            double number = Double.parseDouble(text);
            list.add(0, number);
            if (counter == 5)
                throw new Exception("Недопустимое количество ошибок ввода");

        } catch (NumberFormatException e) {
            counter++;
            Thread.sleep(100);
            for (Double element : list) {
                System.out.print(element+" ");
            }
            System.out.println();
        }
    }
}
