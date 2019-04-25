package by.it.bildziuh.jd02_04;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        try {
            Var.load();
        } catch (Exception e) {
        }
        Scanner scanner = new Scanner(System.in);
        String expression;
        Parser parser = new Parser();
        Printer printer = new Printer();

        while (!(expression = scanner.nextLine()).equals("end")) {
            expression = expression.replace(" ", "");
            if (expression.equals("printvar")) {
                printer.print(Var.varList());
                continue;
            }
            if (expression.equals("sortvar")) {
                printer.print(Var.sortVarList());
                continue;
            }
            try {
               // if (expression.contains("("))
               //     expression = parser.removeBrakets(expression);
                Var result = parser.calc(expression);
                printer.print(result);
                Var.save();
            } catch (CalcException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
