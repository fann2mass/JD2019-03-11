package by.it.vasiliuk.jd01_07;

public class Runner {
    public static void main(String[] args) {

        Var var_1 = new Scalar(3.1415);
        System.out.println(var_1);
        Scalar var_2 = (Scalar)var_1;
        Var var_3 = new Scalar(var_2);
        System.out.println(var_3);
        Var var_4 = new Scalar("3.1415");
        System.out.println(var_4);

        Var v_1 = new Vector(new double[]{1.0, 2.0, 4.0});
        System.out.println(v_1);

        Vector v_2 = (Vector)v_1;
        Var v_3 = new Vector(v_2);
        System.out.println(v_3);

        Var v_4 = new Vector("{1.0, 2.0, 4.0}");
        System.out.println(v_4);

        Var arr_1 = new Matrix(new double[][]{{1.0, 2.0 },{ 3.0, 4.0 }});
        System.out.println(arr_1);

        Matrix arr_2 = (Matrix)arr_1;
        Var arr_3 = new Matrix(arr_2);
        System.out.println(arr_3);

        Var arr_4 = new Matrix("{{1.0, 2.0}, {3.0, 4.0}}");
        System.out.println(arr_4);
    }

}
