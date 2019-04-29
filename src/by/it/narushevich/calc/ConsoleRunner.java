package by.it.narushevich.calc;

import java.util.Locale;
import java.util.Scanner;

public class ConsoleRunner {

    public static ResourceManager manager = ResourceManager.INSTANCE;

    public static void main(String[] args) {

        System.out.println(manager.getString(Msg.WELCOME));
        Logger logger = Logger.getInstance();

        try {
            FactoryVar.load();
            logger.loadLog();
        } catch (CalcException e) {
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(System.in);

        Parser parser = new Parser();
        Printer printer = new Printer();
        String expr;
        Locale locale;
        for (; ; ) {
            expr = scanner.nextLine();
            if (expr.equals("end"))
                break;
            if (expr.equals("ru")){
                locale = new Locale("ru", "RU");
                manager.changeLocale(locale);
                System.out.println(manager.getString(Msg.WELCOME2));
                continue;
                }
            if (expr.equals("be")){
                locale = new Locale("be", "BY");
                manager.changeLocale(locale);
                System.out.println(manager.getString(Msg.WELCOME2));
                continue;
            }
            if (expr.equals("en")){
                locale = new Locale("en", "US");
                manager.changeLocale(locale);
                System.out.println(manager.getString(Msg.WELCOME2));
                continue;
            }
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
