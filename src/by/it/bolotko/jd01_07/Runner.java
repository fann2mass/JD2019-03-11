package by.it.bolotko.jd01_07;

public class Runner {

    public static void main(String[] args) {

        Var var1=new Scalar(3.1415);
        Var var2=new Scalar("3.1415");
        Scalar var3=(Scalar) var1;
        double[] array={1,2,4};
        Var var4=new Vector(array);
        String str="{1.0, 2.0, 4.0}";
        Var var6=new Vector(str);
        Var var5=new Matrix();

        System.out.println(var1);
        System.out.println(var2);
        System.out.println(var3);
        System.out.println(var4);
        System.out.println(var6);
    }
}
