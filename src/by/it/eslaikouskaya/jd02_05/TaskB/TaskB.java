package by.it.eslaikouskaya.jd02_05.TaskB;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.*;

public class TaskB {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		for (; ; ) {
			String s = scanner.nextLine().replace(" ", "");
			if (s.equals("end")) break;
			ResourceManager manager = ResourceManager.INSTANCE;
			Locale locale = Locale.ENGLISH;
			if (args.length == 2) {
				String language = args[0];
				String country = args[1];
				locale = new Locale(language, country);
			}
			if (s.equals("ru"))
				locale = new Locale("ru", "RU");
			else if (s.equals("zh"))
				locale = new Locale("zh", "CH");
			manager.setLocale(locale);

			System.out.printf("%s\n%s\n%s %s\n",
					manager.getString(Msg.WELCOME),
					manager.getString(Msg.QUESTION),
					manager.getString(Msg.FISRTNAME),
					manager.getString(Msg.LASTNAME)
			);
			DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.US);
			Date d = null;
			String str = "April 25, 2019";
			try {
				d = df.parse(str);
			} catch (ParseException e) {
				System.out.println("Error position: " + e.getErrorOffset());
			}
			df = DateFormat.getDateInstance(DateFormat.LONG, locale);
			System.out.println(df.format(d));
		}
	}
}
