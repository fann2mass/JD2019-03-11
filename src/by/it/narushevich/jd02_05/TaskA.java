package by.it.narushevich.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public class TaskA {

    public static void main(String[] args) {
        Locale locale=new Locale("be","BY");
        ResourceBundle resourceBundle =
                ResourceBundle.getBundle("by.it.narushevich.jd02_05.message");
        System.out.printf("%s%n%s%n%s %s%n",
                resourceBundle.getString(Msg.WELCOME),
                resourceBundle.getString(Msg.QUESTION),
                resourceBundle.getString(Msg.FIRSTNAME),
                resourceBundle.getString(Msg.LASTNAME));
    }
}
