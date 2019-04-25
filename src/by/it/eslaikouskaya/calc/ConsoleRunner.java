package by.it.eslaikouskaya.calc;

import java.util.Locale;
import java.util.Scanner;

public class ConsoleRunner {
    public static Locale locale;

    public static void main(String[] args) {
        try {
            Var.load();
        } catch (Exception e) {
            System.out.println("Невозможно загрузить данные");
        }
        Parser parser = new Parser();
        Printer printer = new Printer();
        Scanner scanner = new Scanner(System.in);
        ResourceManager manager = ResourceManager.INSTANCE;
        for (; ; ) {
            String expression = scanner.nextLine().replace(" ", "");
            if (expression.equals("end")) break;
            if (args.length == 2) {
                String language = args[0];
                String country = args[1];
                locale = new Locale(language, country);
            }
            if (expression.equals("ru")) {
                locale = new Locale("ru", "RU");
                manager.setLocale(locale);
                continue;
            }
            if (expression.equals("zh")) {
                locale = new Locale("zh", "CH");
                manager.setLocale(locale);
                continue;
            }
            if (expression.equals("en")) {
                locale = new Locale("en", "EN");
                manager.setLocale(locale);
                continue;
            }

            Var result = null;
            try{
                result = parser.calc(expression);
            }
            catch (CalcException e){
                System.out.println(e.getMessage());
            }
            printer.print(result);
            if (expression.equals("printvar")){
                printer.println(Var.getVars());
            }
        }
    }
}
