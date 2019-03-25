package by.it.khlystunova.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();

    }

    private static void step2() {
        System.out.println("step2");
        double y;
        double result;
        for (double x = -5.5; x < 2 ; x+=0.5 ) {
            if((x/2)<=-1 && (x/2)>-2){
             y = sin(x*x);
            }else if((x/2)>-1 && (x/2)<0.2){
                y = cos(x*x);
            }else if(x/2==0) {
                y = cos(x * x) / sin(x * x);
            }else y = 0;
            result = log10(abs(y +2.74));
            System.out.printf("%-5.2f  %-3e",x/2,result);
            System.out.println();

        }
    }
    private static void step1() {
        double y = 0;
        for (double a = 0; a <= 2 ;) {
            for (int x = 1; x <= 6; x++) {
                y = y + pow(7,a) - cos(x);
            }
            System.out.printf("%-5.2f  %-3g",a,y);
            System.out.println();
            a+=0.2;
        }
    }
}

