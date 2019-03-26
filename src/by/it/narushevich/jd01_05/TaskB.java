package by.it.narushevich.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {

        step1();
        step2();
    }

    private static void step1() {
        double y = 0;
        for (double a = 0; a <= 2; a += 0.2) {
            for (double x = 1; x <= 6; x++) {
                double sum = pow(7, a) - cos(x);
                y += sum;
            }
            System.out.printf("При a = %-3.1f Сумма y = %-6.4e", a, y);
            System.out.println();
        }
    }

    private static void step2() {

        for (double x = -5.5; x < 2; x += 0.5) {
            if ((x / 2 > -2) && (x / 2 <= -1)) {
                double a = log10(abs(sin(pow(x, 2.0)) + 2.74));
                System.out.printf("При х/2 = % 5.2f  a = %-8.6e", x / 2, a);
                System.out.println();
            }
            if ((x / 2 > -1) && (x / 2 < 0.2)) {
                double a = log10(abs(cos(pow(x, 2.0)) + 2.74));
                System.out.printf("При х/2 = % 5.2f  a = %-8.6e", x / 2, a);
                System.out.println();
            }
            if (x / 2 == 0.2) {
                double a = log10(abs(1 / (tan(pow(x, 2.0))) + 2.74));
                System.out.printf("При х/2 = % 5.2f  a = %-8.6e", x / 2, a);
                System.out.println();
            }
            if ((x / 2 > -3) && (x / 2 <= -2)) {
                System.out.printf("При х/2 = % 5.2f  вычисления не определены", x / 2);
                System.out.println();
            }
            if ((x / 2 > 0.2) && (x / 2 < 1)) {
                System.out.printf("При х/2 = % 5.2f  вычисления не определены", x / 2);
                System.out.println();
            }
        }
    }
}
