package by.it.bolotko.jd02_04;

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
            if (expr.equals("end"))
                break;
            if (expr.equals("printVar")){
                printer.println(Var.getVars());
                continue;
            }
            if (expr.equals("sortVar")){
                printer.sortPrint(Var.getVars());
                continue;
            }
            Var result = null;
                try {
                    result = parser.calc(expr);
                }
                catch (CalcException e){
                    System.out.println(e.getMessage());
                    logger.fillReport(e.getMessage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            printer.print(result);


        }
    }
}
