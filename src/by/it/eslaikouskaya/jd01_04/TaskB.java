package by.it.eslaikouskaya.jd01_04;

import java.util.Scanner;

public class TaskB {
	public static void main(String[] args) {
		Scanner s1 = new Scanner(System.in);
		int n = Integer.parseInt(s1.next());


		String[]names = new String[n];
		for (int i = 0; i < n; i++) {
			names[i]=s1.next();
		}


		int[][] salary = new int[n][4];
		for (int i = 0; i < salary.length; i++) {
			System.out.println("Введите зарплату для "+names[i]);
			for (int j = 0; j < salary[i].length; j++) {
				salary[i][j] = s1.nextInt();
			}
		}

		System.out.println("Фамилия    Квартал1   Квартал2   Квартал3   Квартал4   Итого");
		int sum1=0;
		double sum=0;
		for (int i = 0; i < salary.length; i++) {
			System.out.printf("%7s:   ", names[i]);
			for (int j = 0; j < salary[i].length; j++) {
				System.out.printf("%-11d",salary[i][j]);
				sum1+=salary[i][j];
				sum+=salary[i][j];
			}
			System.out.print(sum1);
			sum1=0;
			System.out.println();
		}
		int sum2=(int)sum;
		System.out.println("Итого      "+sum2);
		System.out.println("Средняя    "+sum/(n*4));


	}
}

