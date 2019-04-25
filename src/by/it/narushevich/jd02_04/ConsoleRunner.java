package by.it.narushevich.jd02_04;

import java.util.Locale;
import java.util.Scanner;

public class ConsoleRunner {

    public static ResourceManager manager = ResourceManager.INSTANCE;

    public static void main(String[] args) {

        System.out.println("Welcome! To select a language type: ru - Русский; be - Беларускі; en - English");
        Locale locale;
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        switch (text) {
            case "ru":
                locale = new Locale("ru", "RU");
                manager.changeLocale(locale);
                System.out.println(manager.getString(Msg.WELCOME));
                break;
            case "be":
                locale = new Locale("be", "BY");
                manager.changeLocale(locale);
                System.out.println(manager.getString(Msg.WELCOME));
                break;
            case "en":
                locale = new Locale("en", "US");
                manager.changeLocale(locale);
                System.out.println(manager.getString(Msg.WELCOME));
                break;
            default:
                System.out.println(manager.getString(Msg.ERROR1));
        }

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
