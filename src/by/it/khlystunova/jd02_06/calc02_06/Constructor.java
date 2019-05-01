package by.it.khlystunova.jd02_06.calc02_06;

public class Constructor {

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
        reportBuilder.buildOperationsAndResults();
        reportBuilder.buildFinishTime();

    }
}
