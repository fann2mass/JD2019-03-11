package by.it.eslaikouskaya.jd01_12;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
	private static Map<String, Integer> wordsCount= new HashMap<>();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str;
		while ((!(str = scanner.next()).equals("end"))) {
			Pattern pattern = Pattern.compile("[a-zA-Z']+");
			Matcher matcher = pattern.matcher(str);
			while (matcher.find()) {
				String word = matcher.group();
				actions(word);
			}
		}
		print(wordsCount);
	}


	private static void actions (String currentWord) {
		int code = currentWord.hashCode();
		Set<Map.Entry<String, Integer>> entries = wordsCount.entrySet();
		for (Map.Entry<String, Integer> entry : entries) {
			if (entry.getKey().hashCode()==code) {
				Integer count = entry.getValue();
				count++;
				entry.setValue(count);
				return;
			}
		}
		wordsCount.put(currentWord, 1);
	}


	private static void print(Map<String, Integer> wordsCount) {
		Set<Map.Entry<String, Integer>> entries = wordsCount.entrySet();
		for (Map.Entry<String, Integer> entry : entries) {
			System.out.println(entry.getKey() + "=" + entry.getValue());
		}
	}
}
