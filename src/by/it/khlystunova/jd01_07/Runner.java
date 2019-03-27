package by.it.khlystunova.jd01_07;

import java.util.regex.Matcher;

public class Runner {
    public static void main(String[] args) {
        //Task A
        Var var1 = new Scalar(3.1415);//конструктор из вещесвенного числа
        System.out.println(var1);
        Scalar var2 = (Scalar)var1;
        Var var3 = new Scalar(var2);//конструктор из переменной Scalar
        System.out.println(var3);
        Var var4 = new Scalar("3.1415");
        System.out.println(var4);
        //Task B
        Var v1 = new Vector(new double[]{1.0, 2.0, 4.0});
        System.out.println(v1);

        Vector v2 = (Vector)v1;
        Var v3 = new Vector(v2);//конструктор из переменной Vector
        System.out.println(v3);

        Var v4 = new Vector("{1.0, 2.0, 4.0}");
        System.out.println(v4);
        //TaskB
        Var array1 = new Matrix(new double[][]{{1.0, 2.0 },{ 3.0, 4.0 }});
        System.out.println(array1);

        Matrix array2 = (Matrix)array1;
        Var array3 = new Matrix(array2);
        System.out.println(array3);

        Var array4 = new Matrix("{{1.0, 2.0}, {3.0, 4.0}}");
        System.out.println(array4);
    }

}
