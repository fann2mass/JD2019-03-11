package by.it.Runtso.jd01_05;

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
                y = y + (pow(7, a) - cos(x));
            }
            System.out.printf("При a=%1.2f Сумма y = %2.6e\n", a, y);
        }
    }

    public static void step2() {
        double b=0,a=0;
        for(double x=-5.5;x<2;x+=0.5){
            if(x/2>-2 && x/2<=-1) {
                b=sin(x*x);
                a=log10(b+2.74);
                System.out.printf("При x/2=%1.2f a=%2.10e", x / 2, a);
                System.out.println();}
            else if(x/2>-1 && x/2<0.2){
                b=cos(x*x);
                a=log10(b+2.74);
                System.out.printf("При x/2=%1.2f a=%2.10e", x / 2, a);
                System.out.println();}
            else if(x/2==0.2){
                b=atan(x*x);
                a=log10(b+2.74);
                System.out.printf("При x/2=%1.2f a=%2.10e", x / 2, a);
                System.out.println();}
            else {System.out.printf("При x/2=%1.2f вычисления не определены", x / 2);
                System.out.println();}
            }
        }


    }
