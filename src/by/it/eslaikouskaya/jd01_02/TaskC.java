package by.it.eslaikouskaya.jd01_02;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int mas[][]=step1(n);
    }


    private static int[][] step1(int n) {
        boolean found1 = false;
        boolean found2 = false;
        int[][] mas = new int[n][n];
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {
                mas[i][j] = (int)(Math.random() * ((n*2)+1))-n;
                if (mas[i][j] == n) found1 = true;
                if (mas[i][j] == -n) found2 = true;
            }
        }


        if ((found1)&(found2)) {
            for (int[] ma : mas) {
                for (int i : ma) {
                    System.out.print(i + "\t");
                }
                System.out.println();
            }
        }
        else step1(n);
        return mas;
    }



}
