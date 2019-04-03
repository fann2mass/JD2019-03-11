package by.it.akhmelev.calc_v3;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Parser parser = new Parser();
        Printer printer = new Printer();
        Scanner scanner = new Scanner(System.in);
        for (; ; ) {
            String expression = scanner.nextLine().replace(" ", "");
            if (expression.equals("end")) break;
            Var result = parser.calc(expression);
            printer.print(result);
        }
    }
}
