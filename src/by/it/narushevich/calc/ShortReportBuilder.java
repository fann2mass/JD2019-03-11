package by.it.narushevich.calc;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class ShortReportBuilder extends ReportBuilder {

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yy hh:mm");

    @Override
    public void buildHeadline() {
        report.setHeadline("Short report for Calculator");
    }

    @Override
    public void buildStartTime() {
        report.setStartTime(
                sdf.format(ConsoleRunner.start)
        );
    }

    private static HashMap<String, String> shortReport = new HashMap<>();

    public void fillReport(String task, String result){
        shortReport.put(task, result);
    }

    @Override
    public void buildTaskAndResult() {
        report.setTaskAndResult(shortReport);
    }

    @Override
    public void buildEndTime() {
        report.setEndTime(sdf.format(ConsoleRunner.end));
    }
}
