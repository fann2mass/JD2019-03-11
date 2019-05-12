package by.it.eslaikouskaya.jd01_02;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

	    int mas[][] = step1(n);
	    print(mas);
	    int sum = step2(mas);
	    System.out.println("sum: " + sum);
	    int arr[][] = step3(mas);
	    print(arr);
    }


	private static int[][] step1(int n) {
		boolean found1 = false;
		boolean found2 = false;
		int[][] mas = new int[n][n];
		for (int i = 0; i < mas.length; i++) {
			for (int j = 0; j < mas[i].length; j++) {
				mas[i][j] = (int) (Math.random() * (n * 2 + 1)) - n;
				if (mas[i][j] == n) found1 = true;
				if (mas[i][j] == -n) found2 = true;
			}
		}

		if ((found1) & (found2)) return mas;
		else step1(n);
		return mas;
	}

	private static int step2(int[][] mas) {
		int count;
		int sum = 0;
		for (int[] ma : mas) {
			count = 0;
			for (int j = 0; j < mas.length; j++) {
				int el = ma[j];
				if (el >= 0) {
					count++;
				}
				if (count == 1 && el < 0) {
					sum = +el;
				}
			}
		}
		System.out.println(sum);
		return sum;
	}

	private static int[][] step3(int[][] mas) {
		int max;
		int count = 0;
		if (mas.length == 0) max = Integer.MAX_VALUE;
		else {
			max = mas[0][0];
			for (int i = 0; i < mas.length; i++) {
				for (int j = 0; j < mas[i].length; j++) {
					if (max < mas[i][j]) {
						mas[i][j] = max;
						count++;
					}
				}
			}
		}
		System.out.println("max:" + max);
		return mas;
	}

	private static void print(int[][] mas) {
		for (int[] ma : mas) {
			for (int i : ma) {
				System.out.print(i + "\t");
			}
			System.out.println();
		}
	}
}
