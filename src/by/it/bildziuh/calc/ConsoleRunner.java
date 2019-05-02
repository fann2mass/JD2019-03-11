package by.it.bildziuh.calc;

import java.util.Locale;
import java.util.Scanner;

public class ConsoleRunner {

    static ResourceManager manager = ResourceManager.INSTANCE;
    //   private static Locale locale;

    public static void main(String[] args) {
        try {
            Var.load();
        } catch (Exception e) {
        }
        Scanner scanner = new Scanner(System.in);
        Locale locale;
        String expression;
        Parser parser = new Parser();
        Printer printer = new Printer();

        while (!(expression = scanner.nextLine()).equals("end")) {
            expression = expression.replace(" ", "");
            if (expression.equals("ru")) {
                locale = new Locale("ru", "RU");
                manager.setLocale(locale);
                System.out.println("Язык — русский");
                continue;
            }
            if (expression.equals("en")) {
                locale = new Locale("en", "EN");
                manager.setLocale(locale);
                System.out.println("Language - english");
                continue;
            }
            if (expression.equals("by")) {
                locale = new Locale("be", "BY");
                manager.setLocale(locale);
                System.out.println("Мова — беларуская");
                continue;
            }
            if (expression.equals("printvar")) {
                printer.print(Var.varList());
                continue;
            }
            if (expression.equals("sortvar")) {
                printer.print(Var.sortVarList());
                continue;
            }
            try {
                Var result = parser.calc(expression);
                printer.print(result);
                Var.save();
            } catch (CalcException e) {
                System.out.println(e.getMessage());
            }

        }
    }
}
