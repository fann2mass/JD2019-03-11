package by.it.bildziuh.jd01_12;

import java.util.Scanner;

public class TaskC3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;
        boolean ok = true;
        boolean ok2 = true;

        while (!(line = scanner.nextLine()).equals("end")) {
            line = line.replaceAll("[^{}\\[\\]()]", "");

            if (line.length() % 2 == 1) {
                System.out.println("Некорректное количество символов");
                System.exit(0);
            }

            char[] start = new char[line.length() / 2];
            char[] finish = new char[line.length() / 2];
            char[] symbols = new char[line.length()];

            line.getChars(0, line.length() / 2, start, 0);
            line.getChars(line.length() / 2, line.length(), finish, 0);
            line.getChars(line.length(), line.length(), symbols, 0);

            finish = reverse(finish);
            reverseCheck(finish);

            for (int i = 0; i < symbols.length; i += 2) {
                char compare = symbols[i + 1];
                compare = reverseCheck(compare);
                if (symbols[i] != compare)
                    ok = false;
            }

            for (int i = 0; i < start.length; i++) {
                if (start[i] != finish[i])
                    ok2 = false;
            }
            result(ok, ok2);
        }
    }

    private static void result(boolean ok, boolean ok2) {
        if (ok||ok2)
            System.out.println("Всё в порядке");
        else
            System.out.println("Где-то ошибка");
    }

    private static char[] reverse(char[] symbols) {
        int i = symbols.length - 1;
        int j = 0;
        char[] result = new char[symbols.length];
        while (i >= 0) {
            result[j] = symbols[i];
            i--;
            j++;
        }
        return result;
    }

    private static void reverseCheck(char[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == ')')
                array[i] = '(';
            else if (array[i] == ']')
                array[i] = '[';
            else if (array[i] == '}')
                array[i] = '{';
        }
    }

    private static char reverseCheck(char ch) {
        if (ch == ')')
            ch = '(';
        else if (ch == ']')
            ch = '[';
        else if (ch == '}')
            ch = '{';
        return ch;
    }
}
