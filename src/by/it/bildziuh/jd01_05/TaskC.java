package by.it.bildziuh.jd01_05;

import static java.lang.Math.cbrt;
import static java.lang.Math.pow;
import static java.lang.StrictMath.log10;

public class TaskC {
    public static void main(String[] args) {
        int arrayIndex = 0;
        int count = 0;
        char arrayName = 'A';
        int arrayLengh = 20 + (int) (Math.random() * 21);
        double step = (9 - 5.3) / arrayLengh;
        double[] arrayA = new double[arrayLengh];

        for (double x = 5.33; x <= 9; x += step) {
            double z = cbrt(x * x + 4.5);
            arrayA[arrayIndex] = z;
            arrayIndex++;
        }
        print(arrayA, arrayName++);

        for (int i = 0; i < arrayA.length; i++) {
            if (arrayA[i] > 3.5) {
                count = i;
                break;
            }
        }
        double[] arrayB = new double[arrayA.length - count];

        for (int i = 0; i < arrayB.length; i++) {
            arrayB[i] = arrayA[count];
            count++;
        }
        print(arrayB, arrayName);
        double result = 0;

        for (int i = 0; i < arrayB.length; i++) {
            result = result + log10(arrayB[i]);
        }
        result = result / arrayB.length;
        result = pow(10, result);
 /*     for (int i = 0; i < arrayB.length; i++) {
        result = result * arrayB[i];}
        result = pow(result, 1.0 / arrayB.length);*/
        System.out.println(result);
    }

    private static void print(double[] array, char arrayName) {
        for (int i = 0; i < array.length; i++) {
            if (i == 0)
                System.out.printf("Массив %c[]\n", arrayName);
            System.out.printf("%c[% -2d ] = %-6.5f\t", arrayName, i, array[i]);
            if ((i + 1) % 5 == 0 && i - 1 != 0)
                System.out.println();
        }
        System.out.println();
    }
}