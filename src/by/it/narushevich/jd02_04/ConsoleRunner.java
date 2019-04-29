package by.it.narushevich.jd02_04;

import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) {

        System.out.println(SwitchLanguage.manager.getString(Msg.WELCOME));

        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        SwitchLanguage.switchLang(text);

        try {
            Var.load();
            Logger.loadLog();
        } catch (CalcException e) {
            e.printStackTrace();
        }
        Parser parser = new Parser();
        Printer printer = new Printer();
        Logger logger = new Logger();
        String expr;
        for (; ; ) {
            expr = scanner.nextLine();
            if (expr.equals("end"))
                break;
            if (expr.equals("printvar")){
                printer.println(Var.getVars());
                continue;
            }
            if (expr.equals("sortvar")){
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
                }
                printer.print(result);
        }
    }
}
