package by.it.narushevich.calc;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Parser parser = new Parser();
        Printer printer = new Printer();
        Scanner scanner = new Scanner(System.in);
        String expr;
        for (; ; ) {
            expr = scanner.nextLine();
            if (expr.equals("end")) break;
            Var result = null;
            try {
                result = parser.calc(expr);
            } catch (CalcException e) {
                e.printStackTrace();
            }
            printer.print(result);
            if (expr.equals("printvar")){
                printer.println(Var.getVars());
            }
            if (expr.equals("sortvar")){
                printer.sortPrint(Var.getVars());
            }
        }
    }
}
