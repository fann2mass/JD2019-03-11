package by.it.bildziuh.calc;

class Reporter {

    private ReportBuilder reportBuilder;

    void setReportBuilder(ReportBuilder rb) {
        reportBuilder = rb;
    }

    Report getReport() {
        return reportBuilder.getReport();
    }

    void constructReport() {
        reportBuilder.createNewReport();
        reportBuilder.buildName();
        reportBuilder.buildStartTime();
        reportBuilder.buildOperations();
        reportBuilder.buildFinishTime();

    }
}