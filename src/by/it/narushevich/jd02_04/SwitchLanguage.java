package by.it.narushevich.jd02_04;

import java.util.Locale;

public class SwitchLanguage {

    public static ResourceManager manager = ResourceManager.INSTANCE;

    public static void switchLang(String text) {
        Locale locale;
        switch (text) {
            case "ru":
                locale = new Locale("ru", "RU");
                manager.changeLocale(locale);
                System.out.println(manager.getString(Msg.WELCOME2));
                break;
            case "be":
                locale = new Locale("be", "BY");
                manager.changeLocale(locale);
                System.out.println(manager.getString(Msg.WELCOME2));
                break;
            case "en":
                locale = new Locale("en", "US");
                manager.changeLocale(locale);
                System.out.println(manager.getString(Msg.WELCOME2));
                break;
            default:
                System.out.println(manager.getString(Msg.ERROR1));
        }
    }
}
