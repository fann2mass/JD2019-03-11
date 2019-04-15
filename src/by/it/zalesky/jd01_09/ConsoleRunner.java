package by.it.zalesky.jd01_09;

import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String line;

        Parser  parser = new Parser();
        Printer printer = new Printer();

        while (!(line = scan.nextLine()).equals("end")){
            Var res = parser.calc(line);
            Printer.print(res);
        }
    }
}
