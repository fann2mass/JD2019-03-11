package by.it.narushevich.jd01_02;

import java.util.*;

public class TaskC {
    public static void main(String[] args) {
        System.out.println("Введите n: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        step1(n);

    }

    private static int[][] step1(int n) {
        int[][] mas = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mas[i][j] = (int) ((Math.random() * (2 * n + 1)) - n);
                if ((mas[i][j] == n) || (mas[i][j] == -n))
                    continue;
                else System.out.printf("%2d ", mas[i][j]);
            }
            System.out.println();
        }
        return mas;
    }


}