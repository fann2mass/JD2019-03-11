package by.it.bildziuh.calc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReportBuilderShort extends ReportBuilder {

    private static String getFileName() {
        String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String strPackage = Var.class.getPackage().getName();
        String relPath = strPackage.replace(".", File.separator);
        return src + relPath + File.separator + "operationsAndResults.txt";
    }

    @Override
    public void buildName() {
        report.setName("------------ Report ------------");
    }

    @Override
    public void buildStartTime() {
        report.setStartTime(ConsoleRunner.start.toString().replace("MSK 2019", ""));
    }

    @Override
    public void buildOperations() {
        File file = new File(getFileName());
        StringBuilder operations = new StringBuilder();
        if (file.exists()) {
            try (BufferedReader in = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = in.readLine()) != null) {
                    operations.append(line).append("\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        report.setOperations(operations.toString());
        file.deleteOnExit();
    }

    @Override
    public void buildFinishTime() {
        report.setFinishTime(ConsoleRunner.finish.toString().replace("MSK 2019", ""));
    }

}