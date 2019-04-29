package by.it.eslaikouskaya.calc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

class ShortReportBuilder extends ReportBuilder {
	private static String getFileName() {
		String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
		String strPackage = Var.class.getPackage().getName();
		String relPath = strPackage.replace(".", File.separator);
		return src + relPath + File.separator + "operationsAndResults.txt";
	}


	public void buildName() {
		report.setName("=====Short report for calc=====");
	}

	public void buildTimeStart() {
		report.setTimeStart(ConsoleRunner.date1.toString().replace("MSK 2019", ""));
	}

	public void buildOperationsAndResults() {
		File file = new File(getFileName());
		StringBuilder operations = new StringBuilder();
		if (file.exists()) {
			try (BufferedReader in = new BufferedReader(new FileReader(file))) {
				String line;
				while ((line = in.readLine()) != null) {
					operations.append(line).append("\n");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		report.setOperationsAndResults(operations.toString());
		file.deleteOnExit();
	}

	public void buildTimeFinish() {
		report.setTimeFinish(ConsoleRunner.date2.toString().replace("MSK 2019", ""));
	}
}
