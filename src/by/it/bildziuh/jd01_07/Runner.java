package by.it.bildziuh.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Var v1 = new Scalar(3.14);
    //    Var v2 = v1;
        Var v3 = new Scalar("3.1415");
        System.out.println(v1);
    //    System.out.println(v2);
        System.out.println(v3);

        double[] vector = {1.0, 2.0, 4.0};
        Var v4 = new Vector(vector);
    //    Var v5 = v4;
        Var v6 = new Vector("{1.0, 2.0, 4.0 }");
        System.out.println(v4);
    //    System.out.println(v5);
        System.out.println(v6);

        double[][] matrix1 = {{1.0, 2.0},{3.0, 4.0}};
        Var v7 = new Matrix(matrix1);
    //    Var v8 = v7;
        Var v9 = new Matrix("{{1.0, 2.0}, {3.0, 4.0}}");
        System.out.println(v7);
    //    System.out.println(v8);
        System.out.println(v9);


    }
}
