package by.it.narushevich.calc;

import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) {

        System.out.println(SwitchLanguage.manager.getString(Msg.WELCOME));

        Scanner scanner = new Scanner(System.in);
        Logger logger = Logger.getInstance();
        String text = scanner.nextLine();
        SwitchLanguage.switchLang(text);

        try {
            FactoryVar.load();
            logger.loadLog();
        } catch (CalcException e) {
            e.printStackTrace();
        }
        Parser parser = new Parser();
        Printer printer = new Printer();
        String expr;
        for (; ; ) {
            expr = scanner.nextLine();
            if (expr.equals("end"))
                break;
            if (expr.equals("printvar")){
                printer.println(FactoryVar.getVars());
                continue;
            }
            if (expr.equals("sortvar")){
                printer.sortPrint(FactoryVar.getVars());
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
