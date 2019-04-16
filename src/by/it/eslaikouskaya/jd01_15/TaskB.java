package by.it.eslaikouskaya.jd01_15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class TaskB {
	//all the actions
	public static void main(String[] args) {
		String txt = getFileName(TaskB.class, "TaskB.txt");
		String java = getFileName(TaskB.class, "TaskB.java");
		getDeleteAndPut(txt, java);
	}
	/*
	* for creating files:
	* output and input
	 */
	private static String getFileName(Class<?> cl, String name) {
		String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
		String strPackage = cl.getPackage().getName().replace(".", File.separator);
		return src + strPackage + File.separator + name;
	}
	/**
	 * Took text from TaskB.java; delete all comments; put corrected text in TaskB.txt
	 * @param putIn way to file with corrected text
	 * @param getFrom way to original file
	 */
	private static void getDeleteAndPut (String putIn, String getFrom) {
		try (BufferedReader in = new BufferedReader(new FileReader(getFrom));
		     BufferedWriter out = new BufferedWriter(new PrintWriter(putIn))) {
			String line; // String for reading from file
			while ((line = in.readLine())!= null){
				StringBuilder sb = new StringBuilder(line).append("\n");
				if (line.contains("*/")&&!line.contains("contains"))
					sb.delete(line.indexOf("*"), line.length());
				if (line.contains("/")&&!line.contains("contains")&&!line.contains("indexOf"))
					sb.delete(line.indexOf("/"), line.length());
				else if (line.contains("*")&&!line.contains("contains")&&!line.contains("indexOf"))
					sb.delete(line.indexOf("*"), line.length());
				System.out.print(sb.toString());
				out.write(sb.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

