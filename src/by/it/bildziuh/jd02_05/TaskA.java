package by.it.bildziuh.jd02_05;

import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

public class TaskA {

    private static ResourceManager manager = ResourceManager.INSTANCE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression;
        Locale locale;

        while (!(expression = scanner.nextLine()).equals("end")) {
            if (expression.equals("ru")) {
                locale = new Locale("ru", "RU");
                print(locale);
            }
            if (expression.equals("by")) {
                locale = new Locale("be", "BY");
                print(locale);
            }
            if (expression.equals("en")) {
                locale = new Locale("en", "EN");
                print(locale);
            }

        }
        if (args.length == 2) {
            String language = args[0];
            String country = args[1];
            locale = new Locale(language, country);
        }
        // manager.setLocale(locale);

        System.out.printf("%s\n%s\n%s %s\n",
                manager.getString(Msg.WELCOME),
                manager.getString(Msg.QUESTION),
                manager.getString(Msg.FISRTNAME),
                manager.getString(Msg.LASTNAME)
        );
    }

    private static void print(Locale locale) {

    }
}
