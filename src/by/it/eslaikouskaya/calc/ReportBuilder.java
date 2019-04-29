package by.it.eslaikouskaya.calc;

abstract class ReportBuilder {
	Report report;

	Report getReport() {
		return report;
	}

	void createNewReport() {
		report = new Report();
	}

	public abstract void buildName();

	public abstract void buildTimeStart();

	public abstract void buildTimeFinish();

	public abstract void buildOperationsAndResults();
}
