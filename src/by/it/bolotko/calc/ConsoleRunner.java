package by.it.bolotko.calc;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        try {
            Var.load();
        } catch (Exception ignored) {
        }
        Scanner scan = new Scanner(System.in);
        String line;

        Parser parser = new Parser();
        Printer printer = new Printer();

        while (!(line = scan.nextLine()).equals("end")) {
            try {
                Var result = parser.calc(line);
                printer.print(result);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
