package by.it.narushevich.jd01_07;

import java.util.Arrays;

public class Runner {

    public static void main(String[] args) {

        Var v1 = new Scalar(2.5);
        Var v2 = new Scalar("0.2587");
        Var v3 = v2;
        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);

        double[] array = {1.5, 2.6, 8.1, 6.7};
        Vector v4 = new Vector(array);
        Var v5 = new Vector(v4);
        Var v6 = new Vector("{1,2,4}");

        System.out.println(v4);
        System.out.println(v5);
        System.out.println(v6);
    }
}
