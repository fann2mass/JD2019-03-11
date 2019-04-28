package by.it.eslaikouskaya.calc;

class Report {
	private String name = "";
	private String timeStart = "";
	private String operationsAndResults = "";
	private String timeFinish = "";


	void setName(String name) {
		this.name = name;
	}

	void setTimeStart(String timeStart) {
		this.timeStart = timeStart;
	}

	void setOperationsAndResults(String operationsAndResults) {
		this.operationsAndResults = operationsAndResults;
	}

	void setTimeFinish(String timeFinish) {
		this.timeFinish = timeFinish;
	}

	@Override
	public String toString() {
		return name + '\n' +
				"Start time: " + timeStart + '\n' +
				"-----------\n" + operationsAndResults + "-----------\n" +
				"Finish time: " + timeFinish;
	}
}
