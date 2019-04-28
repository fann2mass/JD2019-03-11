package by.it.zalesky.jd02_05;

import java.util.Locale;

public class TaskA {
    public static void main(String[] args) {

        ResourceManager manager = ResourceManager.INSTANCE;

        Locale locale = Locale.ENGLISH;

        if (args.length == 2) {
            String language = args[0];
            String country = args[1];
            locale = new Locale(language, country);
        }
        manager.setLocale(locale);

        System.out.printf("%s\n%s\n%s %s\n",
                manager.getString(Messages.WELCOME),
                manager.getString(Messages.QUESTION),
                manager.getString(Messages.FIRSTNAME),
                manager.getString(Messages.LASTNAME)
                );
    }
}
