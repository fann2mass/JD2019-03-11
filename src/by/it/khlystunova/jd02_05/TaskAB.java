package by.it.khlystunova.jd02_05;



import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

@SuppressWarnings("all")
 class TaskAB {

        public static void main(String[] args) {

            ResourceManager manager=ResourceManager.INSTANCE;
            Scanner scanner = new Scanner(System.in);
            System.out.println("please,choose language:\n" +
                               "en-English\n" +
                               "be-беларуский\n" +
                               "ru-русский");
            while (true) {
                String language = "";
                String country = "";
                String line = scanner.nextLine();
                switch (line){
                    case"en":
                        language="en";
                        country="EN";
                        break;
                    case"be":
                        language="be";
                        country="BY";
                        break;
                    case"ru":
                        language="ru";
                        country="RU";
                        break;
                    default:
                            language = "en";
                            country = "EN";
                            break;

                }

                Locale locale  = new Locale(language,country);
                manager.setLocale(locale);
                Date date = new Date();
                DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM,locale);
                String format = df.format(date);
                System.out.println(format);
                System.out.printf("%s\n%s\n%s %s\n",
                        manager.getString(Msg.WELCOME),
                        manager.getString(Msg.QUESTION),
                        manager.getString(Msg.FISRTNAME),
                        manager.getString(Msg.LASTNAME)
                );
            }
        }
}
