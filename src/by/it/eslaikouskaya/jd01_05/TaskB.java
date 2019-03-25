package by.it.eslaikouskaya.jd01_05;
import static java.lang.Math.*;

public class TaskB {
	public static void main(String[] args) {
		for (double a = 0; a <= 2; a += 0.2) {
			double y=0;
			for (int x = 1; x <= 6; x++) {
				double z=pow(7,a)-cos(x);
				y+=z;
			}
			System.out.printf("При a=%4.2f Сумма y=%g\n", a, y);
		}
		System.out.println();


        double b;
		for (double x=-5.5;x<2; x=x+0.5){
			if (((x/2)>-2)&&((x/2)<=-1)) {
				b=sin(x*x);
			double a=log10(abs(b+2.74));
			System.out.printf("При x/2=%6.2f a=%g\n", x/2, a);
			}

			else if (((x/2)>-1)&&((x/2)<0.2)) {
				b=cos(x*x);
			double a=log10(abs(b+2.74));
			System.out.printf("При x/2=%6.2f a=%g\n", x/2, a);
			}
			  else if ((x/2)==0.2) {
				b = 1 / (tan(x * x));
				double a = log10(abs(b + 2.74));
				System.out.printf("При x/2=%6.2f a=%g\n", x/2, a);
			}
			  else System.out.println("При x/2 ="+x/2+"вычисления не определены");
		}



	}
}
