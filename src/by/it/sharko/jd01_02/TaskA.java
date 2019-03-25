package by.it.sharko.jd01_02;

import java.util.Scanner;

public class TaskA {

    public static void main(String[] args) {

        System.out.println("Put 10 numbers: ");

        Scanner scan = new Scanner(System.in);
        int [] mas = new int[10];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = scan.nextInt();
        }

        step1(mas);
        step2(mas);
        step3(mas);

    }

    private static void step1(int[] mas) {

        int max = mas[0];
        int min = mas[0];
        for (int ma : mas) { // for ( int i = 0; i < mas.length; i++) {
            if (ma < min) {
                min = ma;
            }
            if (ma > max) {
                max = ma;
            }
        }
        //System.out.println("Min: " + min + " Max: " + max);
        System.out.println(min + " " + max);
    }

    private static void step2 (int[] mas) {

        double middle = 0;

        for (int ma : mas) { //(int i = 0; i< mas.length; i++) {
            middle = middle + ma;
        }
        middle = middle / mas.length;
        for (int ma : mas) { //(int i = 0; i < mas.length; i++) {
            if (ma < middle) {
                System.out.println("Меньше ср. арифметического: " + ma);

            }
        }
        //System.out.println(middle);
    }

    private static void step3 (int[] mas) {
        int min = mas[0];
        for (int ma : mas) { //  for ( int i = 0; i < mas.length; i++) {
            if (ma < min) {
                min = ma;
            }
        }
        for (int i = mas.length-1; i >=0 ; i--) {
            if (mas[i] == min)
                System.out.print(i+" ");

        }





    }
}

