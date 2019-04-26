package by.it.narushevich.jd02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        ResourceManager manager = ResourceManager.INSTANCE;
        Locale locale;

        switch (text) {
            case "ru":
                locale = new Locale("ru", "RU");
                changeLang(manager, locale);
                break;
            case "be":
                locale = new Locale("be", "BY");
                changeLang(manager, locale);
                break;
            case "en":
                locale = new Locale("en", "US");
                changeLang(manager, locale);
                break;
            default:
                System.out.println(manager.getString(Msg.ERROR));
        }
    }

    private static void changeLang(ResourceManager manager, Locale locale) {
        manager.changeLocale(locale);
        Date currentDate = new Date();
        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, locale);
        String data = df.format(currentDate);

        System.out.printf("%s%n%s%n%s%n%s %s%n",
                data,manager.getString(Msg.WELCOME),
                manager.getString(Msg.QUESTION),
                manager.getString(Msg.FIRSTNAME),
                manager.getString(Msg.LASTNAME)
        );
    }
}
