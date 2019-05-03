package by.it.narushevich.calc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class RunnerBuilder {

   static String fileReport = getPath("report.txt");

    private static String getPath(String name) {
            String userDir = System.getProperty("user.dir") + File.separator + "src" + File.separator;
            String pathPack = RunnerBuilder.class.getPackage().getName().replace(".", File.separator);
            return userDir + pathPack+ File.separator + name;
        }

    static void createReport() {
        String text = ConsoleRunner.scanner.nextLine();
        Reporter reporter = new Reporter();
        ReportBuilder reportBuilder = null;
        if (text.equals("short")) {
            reportBuilder = new ShortReportBuilder();
        }
        if (text.equals("full")) {
            reportBuilder = new FullReportBuilder();
        }
        reporter.setReportBuilder(reportBuilder);
        reporter.constructReport();
        Report report = reporter.getReport();
        try (FileWriter fileWriter = new FileWriter(fileReport)) {
            fileWriter.write(report.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
