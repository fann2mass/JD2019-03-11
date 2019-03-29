package by.it.narushevich.jd01_09;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Parser parser = new Parser();
        Printer printer = new Printer();
        Scanner scanner = new Scanner(System.in);
        String expr;
        while (!(expr=scanner.nextLine()).equals("end")){
            Var result = parser.calc(expr);
            printer.print(result);
        }
    }
}
