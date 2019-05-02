package by.it.bildziuh.jd02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class TaskB {

    private static ResourceManager manager = ResourceManager.INSTANCE;
    private static Locale locale;
    private static String date;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression;
        while (!(expression = scanner.nextLine()).equals("end")) {
            if (expression.equals("ru")) {
                locale = new Locale("ru", "RU");
                manager.setLocale(locale);
                setDateFormat();
                print();
            }
            if (expression.equals("by")) {
                locale = new Locale("be", "BY");
                manager.setLocale(locale);
                setDateFormat();
                print();
            }
            if (expression.equals("en")) {
                locale = new Locale("en", "EN");
                manager.setLocale(locale);
                setDateFormat();
                print();
            }
        }
    }

    private static void setDateFormat(){
        Date dateTemp = new Date();
        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, locale);
        date = df.format(dateTemp);
    }

    private static void print() {
        System.out.printf("%s\n%s\n%s %s\n%s\n",
                manager.getString(Msg.WELCOME),
                manager.getString(Msg.QUESTION),
                manager.getString(Msg.FISRTNAME),
                manager.getString(Msg.LASTNAME),
                date
        );
    }
}
