package by.it.khlystunova.jd02_06.calc02_06;

import java.io.*;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class ConsoleRunner {

    static Date start;
    static Date finish;

    private static String getFileName(String name) {
        String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String strPackage = ConsoleRunner.class.getPackage().getName();
        String relPath = strPackage.replace(".", File.separator);
        return src + relPath + File.separator + name;
    }

    public static void main(String[] args) {
        ConsoleRunner.start = new Date();
        Logger logger = Logger.getInstance();
        try {
            VarFactory.load();
            logger.loadLogs();
        } catch (Exception e) {
            e.printStackTrace();
        }

        ResourceManager manager = ResourceManager.INSTANCE;
        System.out.println("You can select language:\nen-English\nbe-беларуский\nru-русский");
        Scanner scanner1 = new Scanner(System.in);
        String text = scanner1.nextLine();
        Locale locale;
        switch (text) {
            case "ru":
                locale = new Locale("ru", "RU");
                manager.setLocale(locale);
                break;
            case "en":
                locale = new Locale("en", "EN");
                manager.setLocale(locale);
                break;
            case "be":
                locale = new Locale("be", "BY");
                manager.setLocale(locale);
                break;
            default:
                System.out.println("Неправильный ввод");
        }
        System.out.println(ResourceManager.INSTANCE.getString(Msg.WELCOME));
        Parser parser = new Parser();
        Printer printer = new Printer();
        Scanner scanner = new Scanner(System.in);

       try (BufferedWriter bw = new BufferedWriter
                (new FileWriter(ConsoleRunner.getFileName("operationsAndResults.txt")))) {
            while (true) {
                String expression = scanner.nextLine().replace(" ", "");
                bw.append('\n');
                bw.append(expression);
                bw.append('\n');
                if (expression.equals("end")) break;
                if (expression.equals("printVar"))
                    Printer.printVar(VarFactory.getVar());
                if (expression.equals("sortVar"))
                    VarFactory.sortVar();
                try {
                    Var result = parser.calc(expression);
                    bw.append(result.toString());
                    printer.print(result);
                } catch (CalcException e) {
                    logger.saveLogs(e.getMessage());
                    bw.append(e.toString());
                    System.out.println(e.getMessage());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

       ConsoleRunner.finish = new Date();
       Constructor constructor = new Constructor();
       ReportBuilder reportBuilder = Math.random() > 0.5 ? new ShortReportBuilder() : new FullReportBuilder();
       constructor.setReportBuilder(reportBuilder);
       constructor.constructReport();
        Report report = constructor.getReport();
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(ConsoleRunner.getFileName("report.txt")))){
            bw.write(report.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(report);


    }
}
