package by.it.narushevich.calc;

class RunnerBuilder {

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
        System.out.println(report);
    }
}
