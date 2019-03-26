package by.it.sharko.jd01_05;

import static java.lang.Math.*;

public class TaskA {
    public static void main(String[] args) {

        step1();
        step2();
        step3();
    }

    private static void step1() {
        double a = 756.13;
        double x = 0.3;

        double one   = cos(pow (( pow( x,2 ) + PI/6 ),5));
        double two   = sqrt( x*pow ( a,3 ));
        double three = log( abs(( a - 1.12 * x) / 4 ));
        double z = one - two - three;

        double z2 = cos(pow((pow(x,2) + PI/6 ), 5)) - sqrt(x * pow(a, 3)) - log(abs((a - 1.12*x) / 4));

        System.out.println("Step 1: ");
        System.out.printf("z= %f", z);
        System.out.println();
        System.out.printf("z2= %f\n", z2);
    }

    private static void step2() {
        double a = 1.21;
        double b = 0.371;
        double y = tan(pow((a + b), 2)) - cbrt(a + 1.5) + a*pow( b,5 ) - b/ (log(pow(a, 2))) ;
        //System.out.println("Step 2: ");
        //System.out.printf("y= %f\n", y);
        System.out.println(y);
    }

    private static void step3() {
        double x = 12.1;
        double f;

        System.out.println("Step3: ");
        for (double a = -5; a <= 12 ; a+= 3.75) {
            
            f = exp ( a * x) - 3.45 * a;

            System.out.printf("При а=%6.2f f=%g\n", a, f);
        }

    }

}
