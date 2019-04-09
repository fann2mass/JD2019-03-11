package by.it.bildziuh.jd01_13;


import java.util.ArrayList;
import java.util.Scanner;

public class TaskC {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        readData(scanner);
    }

    static void readData(Scanner scanner) throws Exception {
        ArrayList<Double> numbers = new ArrayList<>();
        String line;
        double number;
        int count = 0;

        while (!(line = scanner.nextLine()).equals("END")) {
            try {
                number = Double.parseDouble(line);
                numbers.add(number);

            } catch (NumberFormatException e) {
                if (++count < 5) {
                    Thread.sleep(100);
                    for (int i = numbers.size() - 1; i >= 0; i--) {
                        System.out.print(numbers.get(i) + " ");
                    }
                    System.out.println();
                } else throw new Exception("Достигнут лимит в 5 допущенных ошибок");
            }
        }
    }
}


