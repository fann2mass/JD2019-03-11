package by.it.vasiliuk.jd01_02;

import java.util.Scanner;

class TaskC {

    static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int n = scanner.nextInt();

        step1(n);
        //step2(int[][] mas);
        //step3(int[][] mas);
    }

    private static int[][] step1(int n) {
        int [][] mas = new int[n][n];
        for (int i = 0; i <n; i++) {
            for (int j = 0; j <n; j++) {
                mas[i][j]=(int) (Math.random()*(n*2)) - n;
                System.out.print(mas[i][j]+" ");
                if ((j+1)%n==0) System.out.println();
            }
        }
        return mas;
    }

   /* private static int step2(int[ ][ ] mas){
        for (int i = 0; i < mas.length; i++) {

        }
    }*/
}
