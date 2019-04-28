package by.it.bildziuh.jd02_05;

import java.time.LocalDateTime;
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
                manager.setLocale(locale);
                print();
            }
            if (expression.equals("by")) {
                locale = new Locale("be", "BY");
                manager.setLocale(locale);
                print();
            }
            if (expression.equals("en")) {
                locale = new Locale("en", "EN");
                manager.setLocale(locale);
                print();
            }
        }
    }

    private static void print() {
        System.out.printf("%s\n%s\n%s %s\n%s\n",
                manager.getString(Msg.WELCOME),
                manager.getString(Msg.QUESTION),
                manager.getString(Msg.FISRTNAME),
                manager.getString(Msg.LASTNAME),
                Calendar.getInstance().getTime()
        );
    }
}
