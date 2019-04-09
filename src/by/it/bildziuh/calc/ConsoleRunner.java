package by.it.bildziuh.calc;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;

        Parser parser = new Parser();
        Printer printer = new Printer();

        while (!(line = scanner.nextLine()).equals("end")) {
            if (line.equals("printvar"))
                printer.print(Var.varList());
            if (line.equals("sortvar"))
                printer.print(Var.sortVarList());
            Var result = parser.calc(line);
            printer.print(result);
        }
    }
}
