package by.it.eslaikouskaya.jd01_03;

import java.util.Scanner;

public class Runner {
    /**
     * @author Слайковская Е.А.
     * Реализация всех заданий
     * @param args - одномерный массив double
     */
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        double[] array = InOut.getArray(str);
        InOut.printArray(array);
        InOut.printArray(array, "V", 3);
        double min = Helper.findMin(array);
        System.out.println("min=" + min);
        double max = Helper.findMax(array);
        System.out.println("max=" + max);
        Helper.sort(array);
        double[][] mass1 = {{2, 30, 5, 7}, {10, 4, 2, 8}, {4, 8, 11, 53}};
        double[][] mass2 = {{15, 44, 23}, {8, 9, 10}, {4, 8, 11}};
        double[] res1 = Helper.mul(mass1, array);
        for (double element : res1)
            System.out.print(element + " ");
        System.out.println();
        double[][] res2 = Helper.mul(mass1, mass2);
        for (int i = 0; array.length > i; i++) {
            for (int j = 0; j < res2[i].length; j++) {
                System.out.print(res2[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
