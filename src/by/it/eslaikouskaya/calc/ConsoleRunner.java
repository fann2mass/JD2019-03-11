package by.it.eslaikouskaya.calc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class ConsoleRunner {
	public static Locale locale;

	static Date date1;
	static Date date2;

	private static String getFileName(String name) {
		String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
		String strPackage = Singleton.class.getPackage().getName();
		String relPath = strPackage.replace(".", File.separator);
		return src + relPath + File.separator + name;
	}

	public static void main(String[] args) {
		try {
			VarFactory.load();
		} catch (Exception e) {
			Singleton logger = Singleton.getInstance();
			logger.log("Невозможно загрузить данные");
			System.out.println("Невозможно загрузить данные");
		}
		date1 = new Date();
		Parser parser = new Parser();
		Printer printer = new Printer();
		Scanner scanner = new Scanner(System.in);
		ResourceManager manager = ResourceManager.INSTANCE;
		for (; ; ) {
			String expression = scanner.nextLine().replace(" ", "");
			try (BufferedWriter out = new BufferedWriter(new FileWriter(getFileName("operationsAndResults.txt"),
					true))) {
				out.append(expression);
				out.newLine();
				out.flush();
			} catch (IOException e) {
				Singleton logger = Singleton.getInstance();
				logger.log("У нас проблемы...");
				System.out.println("У нас проблемы...");
			}
			if (expression.equals("end")) {
				Reporter reporter = new Reporter();
				ReportBuilder reportBuilder = Math.random() > 0.5 ? new ShortReportBuilder() : new FullReportBuilder();
				reporter.setReportBuilder(reportBuilder);
				reporter.constructReport();
				Report report = reporter.getReport();
				System.out.print(report);
				try (BufferedWriter out = new BufferedWriter(new FileWriter(getFileName("report.txt"),
						true))) {
					out.append(report.toString()).append("\n").append("\n").append("\n");
				} catch (IOException e) {
					Singleton logger = Singleton.getInstance();
					logger.log("У нас проблемы...");
					System.out.println("У нас проблемы...");
				}
				break;
			}

			if (args.length == 2) {
				String language = args[0];
				String country = args[1];
				locale = new Locale(language, country);
			}
			if (expression.equals("ru")) {
				locale = new Locale("ru", "RU");
				manager.setLocale(locale);
				continue;
			}
			if (expression.equals("zh")) {
				locale = new Locale("zh", "CH");
				manager.setLocale(locale);
				continue;
			}
			if (expression.equals("en")) {
				locale = new Locale("en", "EN");
				manager.setLocale(locale);
				continue;
			}
			Var result = null;
			try {
				result = parser.calc(expression);
			} catch (CalcException e) {
				System.out.println(e.getMessage());
			}
			printer.print(result);
			date2 = new Date();
			if (expression.equals("printvar")) {
				printer.println(VarFactory.getVars());
			}
			if (expression.equals("sortvar")) {
				printer.sortPrint(VarFactory.getVars());
			}
		}
	}
}
