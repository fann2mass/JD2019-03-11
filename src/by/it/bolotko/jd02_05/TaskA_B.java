package by.it.bolotko.jd02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class TaskA_B {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        ResourceManager manager=ResourceManager.INSTANCE;

        String language= "";
        String country= "";

        System.out.print("Selected region (ru, be, en): ");
        String region = scanner.nextLine();
        switch (region){
            case "ru": language="ru"; country="RU";
                break;
            case "be": language="be"; country="BY";
                break;
            case "en": language="en"; country="US";
                break;
            default:
                System.err.println("ERROR: Unknown region!\n");
        }
        Locale locale=new Locale(language,country);

        Date d= new Date();
        DateFormat df=DateFormat.getDateInstance(DateFormat.FULL, new  Locale(language,country));
        String date = df.format(d);

        manager.setLocale(locale);
        System.out.printf("%s\n%s\n%s\n%s %s\n",
                date,
                manager.getString(Text.WELCOME),
                manager.getString(Text.QUESTION),
                manager.getString(Text.FISRTNAME),
                manager.getString(Text.LASTNAME)
        );
    }
}
