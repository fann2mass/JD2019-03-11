package by.it.zalesky.Calc;

import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String line;

        Parser parser = new Parser();
        Printer printer = new Printer();

        while (!(line = scan.nextLine()).equals("end")){
            Var res = null;
            try {
                res = parser.calc(line);
                Printer.print(res);
            } catch (CalcException e) {
                System.out.println(e.getMessage());
            }

        }
    }
}
