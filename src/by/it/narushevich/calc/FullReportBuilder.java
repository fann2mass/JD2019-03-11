package by.it.narushevich.calc;

import java.text.SimpleDateFormat;
import java.util.HashMap;

class FullReportBuilder extends ReportBuilder {

    private static SimpleDateFormat sdf = new SimpleDateFormat("EEE dd MMM yyyy HH:mm:ss");

    private static HashMap<String, String> fullReport = new HashMap<>();

    public void fillReport(String task, String result){
        fullReport.put(task, result);
    }

    @Override
    public void buildHeadline() {
        report.setHeadline("Full report for Calculator");
    }

    @Override
    public void buildStartTime() {
        report.setStartTime(
                sdf.format(ConsoleRunner.start)
        );
    }

    @Override
    public void buildTaskAndResult() {
        report.setTaskAndResult(fullReport);
    }

    @Override
    public void buildEndTime() {
        report.setEndTime(sdf.format(ConsoleRunner.end));
    }
}
