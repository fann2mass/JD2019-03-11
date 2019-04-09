package by.it.bildziuh.jd01_13;


import java.util.ArrayList;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        readData(scanner);

    }

    static void readData(Scanner scanner) throws InterruptedException {
        ArrayList<Double> numbers = new ArrayList<>();
        String line;
        double number;
        try {
            while (!(line = scanner.nextLine()).equals("END")) {
                number = Double.parseDouble(line);
          /*      if (number < 0)
                    throw new NumberFormatException();*/
                numbers.add(number);
            }
        } catch (NumberFormatException e) {
            Thread.sleep(100);
            for (int i = numbers.size() - 1; i >= 0; i--) {
                Double num = numbers.get(i);
                System.out.println(num);
            }
        }
    }
}


