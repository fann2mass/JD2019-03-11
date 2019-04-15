package by.it.vasiliuk.jd01_08;

public class Runner {
    private static void print(Var var) {
        if (var!=null)
            System.out.println(var);
    }

    public static void main(String[] args) {
        Var sc = new Scalar(3.0);
        Var vec = new Vector(new double[]{1, 2, 3});
        Var matr = new Matrix("{{1,2,3},{4,5,6},{7,8,9}}");

        print(sc.add(sc));
        print(sc.sub(sc));
        print(sc.mul(sc));
        print(sc.div(sc));

        print(vec.add(vec));
        print(vec.sub(vec));
        print(vec.mul(vec));
        print(vec.div(vec));

        print(matr.add(matr));
        print(matr.sub(matr));
        print(matr.mul(matr));
        print(matr.mul(vec));
        print(matr.mul(sc));
    }

}
