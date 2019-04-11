package by.it.eslaikouskaya.jd01_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskC {

	private static int counter = 0;
	private static List<Double> numbers = new ArrayList<>();
	private static String text;

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		for (; ; ) {
			text = scanner.nextLine();
			readData();
		}
	}


	private static void readData() throws Exception {
		try {
			double number = Double.parseDouble(text);
			numbers.add(0, number);
		} catch (NumberFormatException e) {
			counter++;
			if (counter == 5)
				throw new Exception("Недопустимое количество ошибок");
			Thread.sleep(100);
			for (Double number : numbers) {
				System.out.print(number + " ");
			}
			System.out.println();
		}
	}



}
