package by.it.bolotko.jd01_02;

import java.util.Scanner;

class TaskC {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        step1(n);

        int[][] mas = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mas[i][j] = scanner.nextInt();
            }
            System.out.println();
        }
        step2(mas);
        //step3(int[][] mas);
    }

    private static int[][] step1(int n) {
        int[][] mas1 = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mas1[i][j] = (int) (Math.random() * (n * 2 + 1)) - n;
                System.out.print(mas1[i][j] + " ");
                if ((j + 1) % n == 0) System.out.println();
            }
        }
        return mas1;
    }

    private static int step2(int[][] mas) {
        int res = 0;
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length-1; j++) {
                if (mas[i][j]>0 && mas[i+1][j+1]>0) res=res+mas[i+1][j+1];
                else System.out.println(res);
            }
        }
        return res;
    }
}

