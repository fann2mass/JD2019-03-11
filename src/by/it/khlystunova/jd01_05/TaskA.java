package by.it.khlystunova.jd01_05;

import static java.lang.Math.*;

public class TaskA {
    public static void main(String[] args) {
        step1();
        step2();
        step3();
    }

    private static void step1() {
        double a =756.13;
        double x = 0.3;
        double part1 = cos(pow(x*x +PI/6,5));
        double part2 = sqrt(x*(pow(a,3)));
        double part3 = log(a-1.12*x/4);
        System.out.println(part1-part2-part3);
        System.out.println(part1 - part2 -log((a-1.12*x)/4));

    }

    private static void step2() {
        double a =1.21;
        double b = 0.371;
        double part1 = tan(pow(a+b,2));
        double part2 = pow(a+1.5,1/3d);
        double part3 =a*pow(b,5);
        double part4 = b/log(a*a);
        System.out.println(part1-part2+part3-part4);
    }

    private static void step3() {
        double x = 12.1;
        for (double a = -5; a <= 12 ;) {
          double y = pow(E,a*x)-3.45*a;
            System.out.printf("%-5.2f  %-3g",a,y);
            System.out.println();
             a+=3.75;
        }
    }
}
