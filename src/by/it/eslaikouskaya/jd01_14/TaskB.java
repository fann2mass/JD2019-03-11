package by.it.eslaikouskaya.jd01_14;


import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {

	private static String getFileName(String name) {
		String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
		String strPackage = TaskB.class.getPackage().getName();
		String relPath = strPackage.replace(".", File.separator);
		return src + relPath + File.separator + name;
	}


	public static void main(String[] args) {
		String fileName = getFileName("text.txt");
		String counts = getCounts(fileName);
		System.out.print(counts);
		String result = getFileName("resultTaskB.txt");
		outputToTxt(counts, result);
	}

	private static String getCounts (String filename) {
		String counts="";
		try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
			Pattern pw = Pattern.compile("[а-яА-ЯёЁ]+");
			Pattern ps = Pattern.compile("[,.!?;:-]+");
			int words = 0;
			int signs = 0;
			while (reader.ready()) {
				String s = reader.readLine();
				Matcher matcher1 = pw.matcher(s);
				while (matcher1.find()) words++;

				Matcher matcher2 = ps.matcher(s);
				while (matcher2.find()) signs++;
			}
			counts = "words="+words+", punctuation marks="+signs;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return counts;
	}



	private static void outputToTxt(String counts, String result) {
		try (PrintWriter printWriter = new PrintWriter((new FileWriter(result)))){
			printWriter.write(counts);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
