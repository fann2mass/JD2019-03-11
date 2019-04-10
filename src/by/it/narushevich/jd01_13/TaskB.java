package by.it.narushevich.jd01_13;

import java.util.Arrays;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text;
        Double[] result = new Double[0];
        double sum = 0;
        for (; ; ) {
            text = scanner.nextLine();
            if (text.equals("END")) break;
            try {
                double number = Double.parseDouble(text);
                System.out.println(number);

                result = Arrays.copyOf(result, result.length+1);
                result[result.length-1]=number;

                sum += number;

                double sqrt = Math.sqrt(sum);
                System.out.println(sqrt);
                if (sum<0) {
                    throw new ArithmeticException();
                }

            } catch (ArithmeticException | NumberFormatException e) {
                String name = e.getClass().getName();
                StackTraceElement[] stackTrace = e.getStackTrace();
                for (StackTraceElement element : stackTrace) {
                    String className = element.getClassName();
                    int lineNumber = element.getLineNumber();
                    if (className.contains("TaskB")) {
                        System.out.printf("name:  %s%n" +
                                "class: %s%n" +
                                "line:  %s%n", name, className, lineNumber);
                    }
                }
            }

        }
    }

}
