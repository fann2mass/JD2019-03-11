package by.it.khlystunova.jd02_05;



import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

 class TaskAB {

        public static void main(String[] args) {

            ResourceManager manager=ResourceManager.INSTANCE;
            Scanner scanner = new Scanner(System.in);
            System.out.println("please,choose language:\nen-English\nbe-беларуский\nru-русский");
            while (true) {
                String country = "";
                String language = "";
                String line = scanner.nextLine();
                if (line.equals("end")) {
                    break;
                }
                if(line.equals("en")) {
                    country = "EN";
                    language = "en";
                }

                if(line.equals("be")){
                    country = "BY";
                    language = "be";
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
