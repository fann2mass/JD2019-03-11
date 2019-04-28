package by.Tests;

public class T3 {
    public static void main(String[] args) {
        double maxDel = 3;
        double element = 600851475143.0;

        while (element % 2 == 0) {
            element /= 2;
        }

        while (element > 1) {
            maxDel = result(element, maxDel);
            element /= maxDel;
        }
        System.out.println("The largest divisor of the number " + maxDel);
    }

    private static double result(double element, double maxDel) {
        for (double i = maxDel; i * i <= element; i += 2) {
            if (element % i == 0) return i;
        }
        return element;
    }
}
