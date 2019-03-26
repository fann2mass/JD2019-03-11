package by.it.eslaikouskaya.jd01_07;

public class Runner {


	public static void main(String[] args) {
		Var v1=new Scalar(3.14);
		double [] vecArr={1, 4, 7, 9};
		Var v2=new Vector("1.0, 4.0, 7.0, 9.0");
		double [][] matrArr={{1, 2, 5},{1, 6, 9},{6, 10, 5}};
		Var v3=new Matrix(matrArr);
		System.out.println(v1);
		System.out.println(v2);
		System.out.println(v3);
	}


}
