package by.it.eslaikouskaya.jd01_10;

public class Bean {


	double sum(int a, int b){
		return a+b;
	}

	@Param(a = 2, b = 5)
	static double max(int a, int b){
		if (a==b) System.out.println("a=b");
		else if (a>b) return a;
		return b;
	}

	@Param(a = 2, b = 5)
	static double min(int a, int b){
		if (a==b) System.out.println("a=b");
		else if (a>b) return b;
		return a;
	}

	@Param(a = 2, b = 5)
	double avg(int a, int b){
		return (a+b)/2.0;
	}
}
