package by.it.bildziuh.jd01_13;


import java.util.ArrayList;
import java.util.Scanner;

public class TaskC {

    private static ArrayList<Double> numbers = new ArrayList<>();
    private static String line;
    private static int count = 0;

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        while (!(line = scanner.nextLine()).equals("END"))
            readData();
    }

    static void readData() throws Exception {

        try {
            numbers.add(Double.parseDouble(line));

        } catch (NumberFormatException e) {
            if (++count < 5) {
                Thread.sleep(100);
                for (int i = numbers.size() - 1; i >= 0; i--)
                    System.out.print(numbers.get(i) + " ");
                System.out.println();
            } else throw new Exception("Достигнут лимит в 5 допущенных ошибок");
        }
    }
}


