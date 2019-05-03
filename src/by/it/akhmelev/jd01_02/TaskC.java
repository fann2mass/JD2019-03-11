package by.it.akhmelev.jd01_02;


import java.util.Scanner;

public class TaskC {
    private static boolean element1 = false;
    private static boolean element2 = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] mas = step1(n);
        int sum = step2(mas);
        int[][] arrayStep3 = step3(mas);
    }

    private static int[][] step3(int[][] mas) {
        int max = Integer.MIN_VALUE;
        //находим максимальный элемент в массиве
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {
                if (mas[i][j] > max) {
                    max = mas[i][j];
                }
            }
        }

        int rowCount = mas.length;
        int colCount = mas[0].length;
        boolean[] delRow = new boolean[rowCount];
        boolean[] delCol = new boolean[colCount];
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                if (max == mas[i][j]) {
                    if (!delCol[j]) {
                        delCol[j] = true;
                        colCount--;
                    }
                    if (!delRow[i]) {
                        delRow[i] = true;
                        rowCount--;
                    }
                }
            }
        }
        int[][] res = new int[rowCount][colCount];
        int ii = 0;
        int jj = 0;
        for (int i = 0; i < mas.length; i++) {
            if (!delRow[i]) {
                for (int j = 0; j < mas[i].length; j++) {
                    if (!delCol[j]) {
                        res[ii][jj] = mas[i][j];
                        jj++;
                    }
                }
                ii++;
            }
            jj=0;
        }

        for (int[] row : res) {
            for (int v : row) {
                System.out.print(v+" ");
            }
            System.out.println();
        }

        return res;
    }

    private static int step2(int[][] mas) {
        int count;
        int sum = 0;
        for (int[] ma : mas) {
            count = 0;
            for (int j = 0; j < mas.length; j++) {
                int num = ma[j];
                if (num >= 0) {
                    count++;
                }
                if (count == 1 && num < 0) {
                    sum = sum + num;
                }
            }
        }
        System.out.println(sum);
        return sum;
    }

    private static int[][] step1(int n) {
        int[][] mas = fillMas(n);
        while (true) {
            if (element1 == false && element2 == false)
                mas = fillMas(n);
            else if (element1 == false && element2 == true)
                mas = fillMas(n);
            else if (element1 == true && element2 == false)
                mas = fillMas(n);
            else break;
        }
        //выводим матрицу на консоль
        for (int[] ma : mas) {
            for (int j = 0; j < mas.length; j++) {
                System.out.print(ma[j] + "\t");
            }
            System.out.println();
        }

        return mas;
    }

    private static int[][] fillMas(int n) {
        element1 = false;
        element2 = false;
        int[][] mas = new int[n][n];
        int minusN = n * (-1);
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {
                int random = (int) ((Math.random() * (2 * n + 2)) - n - 1);//генерируем псевдослучайное число от -n до n
                mas[i][j] = random;
                if (random == minusN) {
                    element1 = true;
                } else if (random == n) {
                    element2 = true;
                }
            }
        }
        return mas;
    }
}
