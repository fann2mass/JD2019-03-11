package by.it.bolotko.jd01_05;

import static java.lang.Math.*;

public class TaskC {
    public static void main(String[] args) {
        double[]mas1=new double[25];
        double[]mas2=new double[25];
        step6(mas1);

        int j=0;
        for (double element : mas1) {
            if (element > 3.5) {
                double z = mas2[j] = element;
                System.out.printf("mas1[%2d]=%g ", j, z);
                if ((j + 1) % 5 == 0) System.out.printf("%n");
                j++;
            }
        }

        double sredgeom=1;
        for (double element : mas2) {
            if (element == 0) break;
            sredgeom = sredgeom * element;
        }
        System.out.println("\n\nСреднее геометрическое всех чисел mas2= " + sqrt(sredgeom));
    }


    private static double[] step6(double[]mas1){
        int i=0;
        for (double x = 5.33; x <= 9; x+=0.1468) {
                double z=pow(((x*x)+4.5),(1/3.0));
                System.out.printf("mas1[%2d]=%g ",i,z);
                if ((i+1)%5==0) System.out.printf("%n");
                mas1[i]=z;
                i++;
        }
        System.out.println();
        return mas1;
    }
}
