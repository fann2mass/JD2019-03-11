package by.it.vasiliuk.calc;

import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) {
        Parser parser = new Parser();//анализатор
        Printer printer = new Printer();
        Scanner scanner = new Scanner(System.in);
        while(true){
            String expression = scanner.nextLine().replace(" ","");
            if(expression.equals("end"))break;
            if(expression.equals("printVar"))
                Printer.printVar(Var.getVar());
            if(expression.equals("sortVar"))
                Var.sortVar();
            try {
                Var result = parser.calc(expression);
                printer.print(result);

            } catch (CalcException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}