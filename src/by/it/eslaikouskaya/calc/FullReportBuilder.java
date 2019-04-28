package by.it.eslaikouskaya.calc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;

class FullReportBuilder extends ReportBuilder {

	private static DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);

	private static String getFileName() {
		String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
		String strPackage = Var.class.getPackage().getName();
		String relPath = strPackage.replace(".", File.separator);
		return src + relPath + File.separator + "operationsAndResults.txt";
	}


	public void buildName() {
		report.setName("=====Full report for calc=====");
	}

	public void buildTimeStart() {
		report.setTimeStart(ConsoleRunner.date1.toString());
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
		report.setTimeFinish(ConsoleRunner.date2.toString());
	}
}