package by.it.bildziuh.calc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class ConsoleRunner {

    private static boolean logFull = true;

    static Date start;
    static Date finish;

    public static void main(String[] args) {

        ConsoleRunner.start = new Date();
        Logger logger = Logger.getInstance();

        try {
            VarFactory.load();
            logger.loadLog();
        } catch (Exception e) {

            e.printStackTrace();
        }
        Scanner scanner = new Scanner(System.in);
        String expression;
        Parser parser = new Parser();
        Printer printer = new Printer();

        try (BufferedWriter bw = new BufferedWriter
                (new FileWriter(ConsoleRunner.getFileName("operationsAndResults.txt")))) {
            while (!(expression = scanner.nextLine()).equals("end")) {
                expression = expression.replace(" ", "");
                bw.append('\n');
                bw.append(expression);
                bw.append('\n');
                if (expression.equals("ru") || expression.equals("be") || expression.equals("en")) {
                    Localization.switchTo(expression);
                    bw.append(Localization.manager.getString(Msg.LOCALE));
                    continue;
                }
                if (expression.equals("printvar")) {
                    printer.print(VarFactory.varList());
                    bw.append(VarFactory.varList().toString());
                    continue;
                }
                if (expression.equals("sortvar")) {
                    printer.print(VarFactory.sortVarList());
                    continue;
                }
                if (expression.equals("full")) {
                    logFull = true;
                    System.out.println("Full report");
                    continue;
                }
                if (expression.equals("short")) {
                    logFull = false;
                    System.out.println("Short report");
                    continue;
                }

                try {
                    Var result = parser.calc(expression);
                    bw.append(result.toString());
                    printer.print(result);
                    VarFactory.save();
                } catch (CalcException e) {
                    logger.log(e.getMessage());
                    bw.append(e.getMessage());
                    System.out.println(e.getMessage());
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        ConsoleRunner.finish = new Date();
        Reporter reporter = new Reporter();
        ReportBuilder reportBuilder = logFull ? new ReportBuilderFull() : new ReportBuilderShort();
        reporter.setReportBuilder(reportBuilder);
        reporter.constructReport();
        Report report = reporter.getReport();
        try (
                BufferedWriter bw = new BufferedWriter(new FileWriter(getFileName("report.txt")))) {
            bw.write(report.toString());
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        System.out.println(report);
    }

    private static String getFileName(String name) {
        String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String strPackage = ConsoleRunner.class.getPackage().getName();
        String relPath = strPackage.replace(".", File.separator);
        return src + relPath + File.separator + name;
    }

}
