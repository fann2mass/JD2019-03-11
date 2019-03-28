package by.it.bolotko.jd01_07;

public class Runner {

    public static void main(String[] args) {

        Var var1=new Scalar(3.1415);
        Var var2=new Scalar("3.1415");
        Scalar var3=(Scalar) var1;

        double[] array={1,2,4};
        Var var4=new Vector(array);
        Var var5=(Vector) var4;
        String str="{1.0, 2.0, 4.0}";
        Var var6=new Vector(str);

        Var var7 = new Matrix(new double[][]{{1.0, 2.0 },{ 3.0, 4.0 }});

        Matrix var8 = (Matrix)var7;
        //Var array3 = new Matrix(var8);

        String str2 = "{{1.0, 2.0}, {3.0, 4.0}}";
        Var var9 = new Matrix(str2);

        System.out.println(var1);
        System.out.println(var2);
        System.out.println(var3);
        System.out.println(var4);
        System.out.println(var5);
        System.out.println(var6);
        System.out.println(var7);
        System.out.println(var8);
        System.out.println(var9);
    }
}
