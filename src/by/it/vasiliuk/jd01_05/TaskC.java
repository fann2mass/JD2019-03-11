package by.it.vasiliuk.jd01_05;

import static java.lang.Math.*;
public class TaskC {
    public static void main(String[] args) {
        step1();
    }
    private static void step1() {
        double[] array = new double[25];
        double res;
        int i = -1;
        for (double x = 5.33; x <= 9 ;x += 0.1835) {
            res = pow((x*x)+4.5,1/3d);
            array[i+=1] = res;
        }
        for (int j = 0; j < array.length; j++) {
            System.out.printf("%-1s[%-2d] = %-3e","v",j,array[j]);
            System.out.println();
        }
        double [] formed_mas = new double[15];
        int k=0;
        double sum =0;
        for (double v : array) {
            if (v > 3.5) {
                formed_mas[k] = v;
                sum = formed_mas[k] + sum;
                k++;
            }
        }
        double avg_geom_val = sum/formed_mas.length;
        System.out.println("New array of elements above 3.5");
        for (int i1 = 0; i1 < formed_mas.length; i1++) {
            System.out.printf("%-1s[%-2d] = %-3e","v",i1,formed_mas[i1]);
            System.out.println();
        }
        System.out.println("Average geometric value"+avg_geom_val);
    }
}