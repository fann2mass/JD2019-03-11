package by.it.Runtso.jd01_02;

import java.util.Scanner;

public class TaskA {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] mas=new int[10];
        for (int i = 0; i < mas.length; i++) {
            mas[i]=scanner.nextInt();
        }
        step1(mas);
        step2(mas);
        step3(mas);

    }

    private static void step1(int[] mas) {
        int min = mas[0];
        int max = mas[0];
        for (int i = 0; i < mas.length; i++) {
            if (min > mas[i]) min=mas[i] ;
            if (max < mas[i]) max=mas[i];
        }
        System.out.println(min+" "+max);
    }

    private static void step2(int[] mas){
        double srednee=0;
        for (int i = 0; i <mas.length ; i++) {
            srednee+=mas[i];
        }
        srednee=srednee/mas.length;

        for (int i = 0; i <mas.length ; i++) {
            if(mas[i]<srednee) System.out.print(mas[i]+" ");

        }
    }

    private static void step3(int[] mas){
        int min=mas[0];
        for (int i = 0; i <mas.length ; i++) {
            if (min > mas[i]) min=mas[i] ;
        }
        for (int i = mas.length-1; i >= 0 ; i--) {
            if(mas[i]==min)
                System.out.print(i+" ");
        }
        }


    }

