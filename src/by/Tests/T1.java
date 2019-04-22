package by.Tests;

import java.util.ArrayList;

public class T1 {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int sum = 0;
        for (int i = 1; i < 1000; i++) {
            arrayList.add(i);
        }
        for (Integer element : arrayList) {
            if (element % 3 == 0 || element % 5 == 0) {
                System.out.print(element + " ");
                sum += element;
            }
        }
        System.out.println("\nThe sum of all numbers less than 1000, multiples of 3 or 5, is equal: " + sum);
    }
}
