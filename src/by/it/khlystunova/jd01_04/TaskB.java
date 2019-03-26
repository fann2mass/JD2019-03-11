package by.it.khlystunova.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] namesArray = new String[n];
        for (int i = 0; i <namesArray.length ; i++) {
            namesArray[i] = scanner.next();
        }
        int[][] salaryArray = new int[n][4];
        double allElement = n*4;
        for (int i = 0; i < n; i++) {
            System.out.println("Введите зарплату для "+namesArray[i]);
            for (int j= 0; j < 4; j++) {
                salaryArray[i][j] = scanner.nextInt();
            }
        }
        System.out.println("---------------------------------------------------");
        System.out.printf("%-9s%-9s%-9s%-9s%-9s%-9s\n","Фамилия","Квартал1","Квартал2","Квартал3","Квартал4","Итого");
        double totalSum = 0;
        for (int i = 0; i < namesArray.length; i++) {
            int sum = 0;
            System.out.println("---------------------------------------------------");
            System.out.printf("%7s: ",namesArray[i]);
            for (int j = 0; j < 5; j++) {
                if(j<4) {
                    sum+=salaryArray[i][j];
                    System.out.printf("%-9d", salaryArray[i][j]);
                }else if(j==4){
                    totalSum+=sum;
                    System.out.printf("%-9d", sum);
                }
            }
            System.out.println();
        }
        System.out.println("---------------------------------------------------");
        System.out.printf("%-9s%-9f\n","Итого",totalSum);
        System.out.printf("%-9s%-9f","Средняя",totalSum/allElement);
    }


}
