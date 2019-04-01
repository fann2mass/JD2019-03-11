package by.it.bildziuh.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Var v1 = new Scalar(3.14);
        Var v2 = new Scalar("3.1415");
        System.out.println(v1);
        System.out.println(v2);

        double[] vector = {1.0, 2.0, 4.0};
        Var v3 = new Vector(vector);
        Var v4 = new Vector("{1.0, 2.0, 4.0}");
        System.out.println(v3);
        System.out.println(v4);

        double[][] matrix1 = {{1.0, 2.0}, {3.0, 4.0}};
        Var v5 = new Matrix(matrix1);
        Var v6 = new Matrix("{{1.0, 2.0, 3.0},{4.0, 5.0, 6.0}}");
        System.out.println(v5);
        System.out.println(v6);

    }
}
