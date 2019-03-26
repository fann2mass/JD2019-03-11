package by.it.khlystunova.jd01_02;


import java.util.Scanner;

public class TaskC {
   private static boolean element1 = false;
   private static  boolean element2 = false;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] mas = step1(n);
        int sum = step2(mas);
        int [][]arrayStep3 = step3(mas);
     }

    private static int[][] step3(int[][] mas) {
        int max = mas[0][0];
        int indexi = 0;
        int indexj = 0;
        //находим максимальный элемент в массиве
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {
                if(mas[i][j]>max){
                    max = mas[i][j];
                    indexi = i ;
                    indexj = j;
                }
            }
        }
        int[][] masRes = new int[mas.length-1][mas.length-1];
        //System.arraycopy(mas,0,masRes,0,mas.length-1);

        //удаляем строку содержащую элемент мах

        System.arraycopy(mas[indexi], 1, mas[indexi], 0, mas.length);
            for (int i = 0; i < mas.length; i++) {
                mas[i][indexj] =mas[i+1][indexj];
            }

        //выводим матрицу на консоль
        for (int[] masRe : masRes) {
            for (int j = 0; j < masRes.length; j++) {
                System.out.print(masRe[j] + "\t");
            }
            System.out.println();
        }
        return masRes;
    }

    private static int step2(int [][]mas) {
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
        while (true){
            if(element1==false && element2 == false)
            mas = fillMas(n);
            else if(element1==false && element2==true)
                mas = fillMas(n);
            else if(element1==true && element2==false)
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
        int [][] mas = new int[n][n];
        int minusN = n*(-1);
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {
                int random = (int)((Math.random()*(2*n+2))-n-1);//генерируем псевдослучайное число от -n до n
                mas[i][j] = random;
                if(random == minusN){
                   element1=true;
                }else if(random == n){
                  element2=true;
                }
            }
        }
        return mas;
    }
}
