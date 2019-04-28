package by.it.eslaikouskaya.calc;

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
		reportBuilder.buildTimeStart();
		reportBuilder.buildOperationsAndResults();
		reportBuilder.buildTimeFinish();
	}
}
