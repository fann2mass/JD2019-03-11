package by.it.bolotko.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Введите количество фамилий: ");
        int n = scanner.nextInt();
        System.out.println("Введите фамилии: ");
        String[] fam = new String[n];
        for (int i = 0; i < n; i++) {
            fam[i] = scanner.next();
        }
        int[][] zrp=new int[n][4];
        for (int i = 0; i < n; i++) {
            System.out.println("Введите зарплату за 4 квартала для " + fam[i]);
            for (int j = 0; j <4; j++) {
                zrp[i][j]=scanner.nextInt();
            }
        }
        int[] itog=new int[n];
        int itogv=0;
        double sred=0;
        System.out.printf("------------------------------------------------------------%n");
        System.out.printf(" Фамилия   Квартал1   Квартал2   Квартал3   Квартал4   Итого%n");
        System.out.printf("------------------------------------------------------------%n");
        for (int i = 0; i < n; i++) {
            System.out.printf("%8s",fam[i]);
            for (int j = 0; j <4; j++) {
                System.out.printf("   %-8d",zrp[i][j]);
                itog[i]=itog[i]+zrp[i][j];
            }
            System.out.printf("   %-8d%n",itog[i]);
            sred=sred+itog[i];
            itogv=itogv+itog[i];
        }
        System.out.printf("------------------------------------------------------------%n");
        System.out.printf("Итого      %-8d%nСредняя    %-3.5f%n",itogv,sred/(n*4));
    }
}
