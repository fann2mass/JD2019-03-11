package by.it.eslaikouskaya.jd01_04;

import java.util.Scanner;

public class TaskA {

	private static void printMulTable(){

		for (int i = 2; i <10 ; i++) {
			for (int j = 2; j <10; j++) {
				System.out.printf("%1d*%1d=%-2d ",i,j,i*j);
			}
			System.out.println();
		}
	}


	private static void buildOneDimArray(String line) {
		String name = "V";
		int columnCount = 5;
		line = line.trim();
		String[] strArr = line.split(" ");
		double[] getArr = new double[strArr.length];
		for (int i = 0; i < strArr.length; i++) {
			getArr[i] = Double.parseDouble(strArr[i]);
			System.out.printf("%s[%1d]=%-10.4f ", name, i, getArr[i]);
			if ((i + 1) % columnCount == 0 || i + 1 == getArr.length) System.out.println();
		}
		double first = getArr[0];
		double last = getArr[getArr.length-1];
		double finish = getArr.length - 1;
		boolean swap;

		do {
			swap = false;
			for (int i = 0; i < finish; i++) {
				if (getArr[i] > getArr[i + 1]) {
					double tmp = getArr[i];
					getArr[i] = getArr[i + 1];
					getArr[i + 1] = tmp;
					swap = true;
				}
			}
			finish--;
		}
		while (swap);
		for (double element : getArr) {
			System.out.print(element + " ");
		}
		System.out.println();

		for (int i = 0; i < getArr.length; i++) {
			columnCount = 4;
			System.out.printf("%s[%1d]=%-10.4f ", name, i, getArr[i]);
			if ((i + 1) % columnCount == 0 || i + 1 == getArr.length) System.out.println();
		}

		for (int i = 0; i < getArr.length; i++) {
			if (getArr[i] == first) System.out.println("Index of first element="+i);
		}

		for (int i = 0; i < getArr.length; i++) {
			if (getArr[i] == last) System.out.println("Index of last element="+i);
		}

	}


	public static void main(String[] args) {
		printMulTable();
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
        buildOneDimArray(s);
	}


}
