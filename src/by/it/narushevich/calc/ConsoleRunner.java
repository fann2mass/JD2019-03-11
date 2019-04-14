package by.it.narushevich.calc;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        try {
            Var.load();
            Logger.loadLog();
        } catch (CalcException e) {
            e.printStackTrace();
        }
        Parser parser = new Parser();
        Printer printer = new Printer();
        Logger logger = new Logger();
        Scanner scanner = new Scanner(System.in);
        String expr;
        for (; ; ) {
            expr = scanner.nextLine();
            logger.fillReport(expr);
            if (expr.equals("end"))
                break;
            if (expr.equals("printvar")){
                printer.println(Var.getVars());
                logger.fillReport(Var.getVars().toString());
            }
            if (expr.equals("sortvar")){
                printer.sortPrint(Var.getVars());
                logger.fillReport(Var.getVars().toString());
            }
            Var result = null;
                try {
                    result = parser.calc(expr);
                }
                catch (CalcException e){
                    System.out.println(e.getMessage());
                    logger.fillReport(e.getMessage());
                }
                printer.print(result);


        }
    }
}
