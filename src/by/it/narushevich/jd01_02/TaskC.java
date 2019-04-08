package by.it.narushevich.jd01_02;

import java.util.*;

public class TaskC {

    private static int[][] mas;
    private static int summary = 0;

    public static void main(String[] args) {
        System.out.println("Введите n: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        mas = step1(n);
        summary = step2(mas);

    }

    private static int step2(int[][] mas) {
        int index = 0;
        int sum = 0;
        for (int[] elements : mas) {
            for (int i : elements) {
                if (i > 0) {
                    sum += i;
                    index++;
                }
                if (index == 2) break;
            }
            summary += sum;
        }
        return summary;
    }

    private static int[][] step1(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mas[i][j] = (int) ((Math.random() * (2 * n + 1)) - n);
                if (mas[i][j] == -n) break;
                if (mas[i][j] == n) break;
            }
        }
        for (int[] elements : mas) {
            for (int element : elements) {
                System.out.printf("%2d ", element);
            }
            System.out.println();
        }
        return mas;
    }
}