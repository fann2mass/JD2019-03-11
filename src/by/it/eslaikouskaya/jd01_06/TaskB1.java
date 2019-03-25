package by.it.eslaikouskaya.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {

	private static Character[] vowel = {'И', 'о', 'и', 'е', 'ё', 'э',
			'ы', 'у', 'ю', 'я', 'а'};


	public static void main(String[] args) {
		Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
		Matcher matcher = pattern.matcher(Poem.text);
		while (matcher.find()) {
			String word = matcher.group();
			for (Character character : vowel) {
				if ((word.charAt(0) != 'И') && (character == (word.charAt(word.length() - 1)))) {
					System.out.println(word);
				}
			}
		}
	}
}

