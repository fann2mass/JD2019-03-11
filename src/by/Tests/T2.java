package by.Tests;

import java.util.ArrayList;

public class T2 {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int sum = 0;
        int element1 = 1;
        int element2 = 2;
        arrayList.add(element1);
        arrayList.add(element2);
        while (element1 <= 4000000 || element2 <= 4000000) {
            if (element1 < element2) {
                element1 = element1 + element2;
                arrayList.add(element1);
            }
            else {
                element2 = element2 + element1;
                arrayList.add(element2);
            }
        }
        for (Integer result : arrayList) {
            if (result%2==0)
            sum += result;
        }
        System.out.println("Sum of all even elements of the Fibonacci series " + sum);
    }
}
