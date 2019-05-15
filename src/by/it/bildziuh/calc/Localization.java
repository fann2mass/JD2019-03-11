package by.it.bildziuh.calc;

import java.util.Locale;

public class Localization {

    static ResourceManager manager = ResourceManager.INSTANCE;

    static void switchTo(String lang) {
        Locale locale;
        String arg = "";
        if (lang.equals("ru"))
            arg = "RU";
        if (lang.equals("be"))
            arg = "BY";
        if (lang.equals("en"))
            arg = "EN";
        locale = new Locale(lang, arg);
        manager.setLocale(locale);

        System.out.println(manager.getString(Msg.LOCALE));
    }
}
