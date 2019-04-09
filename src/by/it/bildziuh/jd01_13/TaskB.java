package by.it.bildziuh.jd01_13;


import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String line;
        double number = 0;
        double result;

        try {
            while (!(line = scanner.nextLine()).equals("END")) {

                number += Double.parseDouble(line);
                System.out.println(number);

                result = Math.sqrt(number);
                if (number < 0)
                    throw new ArithmeticException();
                System.out.println(result);
            }

        } catch (NumberFormatException | ArithmeticException e) {

            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement element : stackTrace) {
                if (TaskB.class.getName().equals(element.getClassName())) {
                    String name = e.getClass().getName();
                    String className = element.getClassName();
                    int lineNum = element.getLineNumber();
                    System.err.printf("name:%s\nclass:%s\nline:%s\n", name, className, lineNum);
                }

            }
        }
    }
}
