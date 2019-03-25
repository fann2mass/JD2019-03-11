package by.it.bildziuh.jd01_02;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        step1(array);
        step2(array);
        step3(array);
    }


    private static void step1(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min)
                min = arr[i];
            if (arr[i] > max)
                max = arr[i];
        }
        System.out.println(min + " " + max);
    }

    private static void step2(int[] arr) {
        double sum = arr[0];
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }
        double average = sum / arr.length;
        for (int i = 0; i < arr.length; i++) {
            if (average > arr[i])
                System.out.println(arr[i]);
        }
    }

    private static void step3(int[] arr) {
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min)
                min = arr[i];
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == min)
                System.out.print(i + " ");
        }
    }
}
