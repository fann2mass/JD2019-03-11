package by.it.zalesky.jd02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class TaskA_B {
    public static void main(String[] args) {

        ResourceManager manager = ResourceManager.INSTANCE;
        Scanner scanner = new Scanner(System.in);
        System.out.println("please,choose language:\n" +
                "en-English\n" +
                "be-беларуский\n" +
                "ru-русский");

        while (true) {
            String language = "";
            String country = "";
            String line = scanner.nextLine();
            switch (line) {
                case "en":
                    language = "en";
                    country = "EN";
                    break;
                case "be":
                    language = "be";
                    country = "BY";
                    break;
                case "ru":
                    language = "ru";
                    country = "RU";
                    break;
                default:
                    language = "en";
                    country = "EN";
                    break;

            }

            Locale locale = new Locale(language, country);
            manager.setLocale(locale);
            Date date = new Date();
            DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM, locale);
            String format = dateFormat.format(date);
            System.out.println(format);
            System.out.printf("%s\n%s\n%s %s\n",
                    manager.getString(Messages.WELCOME),
                    manager.getString(Messages.QUESTION),
                    manager.getString(Messages.FIRSTNAME),
                    manager.getString(Messages.LASTNAME)
            );
        }
    }
}