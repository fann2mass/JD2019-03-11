package by.it.akhmelev.jd01_07;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        Var var1=new Scalar(6.0);
        Var var2=new Scalar("123.456");
        Scalar var4=(Scalar) var1;
        Var var3=new Scalar(var4);
        double[] array={6,2,3,4,5,1};
        Var var5=new Vector(array);

        Arrays.sort(array);

        System.out.println(var1);
        System.out.println(var2);
        System.out.println(var3);
        System.out.println(var5);
    }
}
