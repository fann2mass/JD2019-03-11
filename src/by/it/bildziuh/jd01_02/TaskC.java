package by.it.bildziuh.jd01_02;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();


        //step1(size);
        int[][] matrix = step1(size);
//        int sum = step2(matrix);
//        System.out.println(sum);
//        step3();
    }

    private static int[][] step1(int size) {
        int[][] matrix = new int[size][size];
        boolean a = false;
        boolean b = false;
        while (a == false || b == false) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = (int) (Math.random() * ((size * 2) + 1)) - size;
                    if (matrix[i][j] == size)
                        a = true;
                    if (matrix[i][j] == -size)
                        b = true;

                }
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.printf("%3d", matrix[i][j]);
            }
            System.out.println();
        }
        return matrix;
    }
}
/*
    private static int step2(int[][] matrix) {
        int sumElem = 0;
        int counter1 = 0;
        int counter2 = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] > 0)
                    counter1 = j;
                for (int k = j; k < matrix.length; k++) {
                    if (matrix[i][j] > 0)
                        counter2 = k;
                    for (int l = counter1; l <= counter2; l++) {
                        sumElem += matrix[i][l];
                    }
                    break;
                }

            }
        }
        return sumElem;
    }

    private static void step3() {
    }
}
*/

