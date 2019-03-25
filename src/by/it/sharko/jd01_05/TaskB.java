package by.it.sharko.jd01_05;

import static java.lang.Math.*;

public class TaskB {

    public static void main(String[] args) {
        step4();
       // step5();
    }

    private static void step4() {
        double y= pow(7, 0.2) - cos(1);
        int x = 2;

        for (double a = 0.2; a <= 2 ; a+=0.2) {

            while ( x < 7) {
            //for (int x = 1; x < 7 ; x++) {
               //double y = 0;
                y = y + pow(7, a) - cos(x);// СУММА
                x++;
                //System.out.printf("Step 4, y=%10,3f\n", y);
            }
            System.out.println(y);
        }
    }

/*    private static void step5() { //распечатать результат вычисления и величину от которой зависит выбор условия

        for (double x = -5 ; x < 2 ; x+=0.5) {
            double b;
            if (x / 2 > -2 && x <= -1) {
                b = sin(pow(x, 2));
                System.out.println("b1 =" + b);
                System.out.println();
                double a = log(abs(b + 2.74));
                System.out.println("a= " + a);
            }
            if (x / 2 < 0.2 && x > -1) {
                b = cos(pow(x, 2));
                System.out.println("b2 =" + b);
                System.out.println();
                double a = log(abs(b + 2.74));
                System.out.println("a= " + a);
            }
            if (x / 2 == 0.2) {
                b = 1 / tan(pow(x, 2));
                System.out.println("b3 =" + b);
                System.out.println();
                double a = log(abs(b + 2.74));
                System.out.println("a= " + a);
            }

            //double a = log(abs(b + 2.74));

        } */




    }

