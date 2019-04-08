package by.it.eslaikouskaya.jd01_12;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {
	private static Map<String, Integer> wordsCount= new HashMap<>();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str;
		while ((!(str = scanner.next()).equals("end"))) {
			Pattern pattern = Pattern.compile("[А-Яа-яЁё]+");
			Matcher matcher = pattern.matcher(str);
			while (matcher.find()) {
				String word = matcher.group();
				actions1(word);
			}
		}
		print(wordsCount);
		//actions2(wordsCount);
	}


	private static void actions1 (String currentWord) {
		Integer count = 1;
		Set<Map.Entry<String, Integer>> entries = wordsCount.entrySet();
		for (Map.Entry<String, Integer> entry : entries) {
				count++;
				entry.setValue(count);
		}
		wordsCount.put(currentWord, 1);
	}

	/*private static void actions2(Map<String, Integer> wordsCount) {

	}*/


	private static void print(Map<String, Integer> wordsCount) {
		Set<Map.Entry<String, Integer>> entries = wordsCount.entrySet();
		for (Map.Entry<String, Integer> entry : entries) {
			System.out.println(entry.getKey() + "=" + entry.getValue());
		}
	}
}