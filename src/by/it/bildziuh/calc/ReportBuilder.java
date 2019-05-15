package by.it.bildziuh.calc;

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

    public abstract void buildOperations();

    public abstract void buildFinishTime();

}