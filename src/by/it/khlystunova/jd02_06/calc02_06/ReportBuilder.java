package by.it.khlystunova.jd02_06.calc02_06;

abstract class ReportBuilder {

    Report report;

    Report getReport() {
        return report;
    }

    void createNewReport(){
        report = new Report();
    }

    public abstract void buildName();

    public abstract void buildStartTime();

    public abstract void buildOperationsAndResults();

    public abstract void buildFinishTime();

}
