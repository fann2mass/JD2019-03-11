package by.Tests;

public class T5 {
    public static void main(String[] args) {
        for (int i = 1; i < 1000000000; i++) {
            if (i % 7 == 0 && i % 8 == 0 && i % 9 == 0 && i % 11 == 0 && i % 13 == 0 && i % 15 == 0
                    && i % 16 == 0 && i % 17 == 0 && i % 18 == 0 && i % 19 == 0 && i % 20 == 0) {
                System.out.println("Smallest number: " + i);
                break;
            }
        }
    }
}
