package by.it.eslaikouskaya.jd01_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskB {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str;
		double sum = 0;
		List<Double> numbers = new ArrayList<>();
		while ((!(str = scanner.next()).equals("END"))) {
			try {
				Double value = Double.valueOf(str);
				numbers.add(value);
				System.out.println(value);
				for (Double number : numbers) {
					sum += number;
				}
				double radix = Math.sqrt(sum);
				if (Double.isNaN(radix)){ throw new ArithmeticException();}
				System.out.println(radix);
				sum = 0;
			} catch (ArithmeticException | NumberFormatException e){
				String name = e.getClass().getName();
				System.out.println("name: "+name);
				StackTraceElement[] stackTrace = e.getStackTrace();
				for (StackTraceElement element : stackTrace) {
					if (element.getClassName().equals(TaskB.class.getName())){
						System.out.println("class: "+element.getClassName()+
								"\nline: "+element.getLineNumber()); return;
					}
				}
			}
		}
	}
}
