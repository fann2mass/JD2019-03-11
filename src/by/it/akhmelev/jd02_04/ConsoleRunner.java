package by.it.akhmelev.jd02_04;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        try {
            Var.load();
        } catch (Exception e) {
        }
        Parser parser = new Parser();
        Printer printer = new Printer();
        Scanner scanner = new Scanner(System.in);
        for (; ; ) {
            String expression = scanner.nextLine().replace(" ", "");
            if (expression.equals("end")) break;
            Var result = null;
            try {
                result = parser.calc(expression);
            } catch (CalcException e) {
                System.out.println(e.getMessage());
            }
            printer.print(result);
        }
    }


}
