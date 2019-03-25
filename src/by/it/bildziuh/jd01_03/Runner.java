package by.it.bildziuh.jd01_03;
/** Основной метод программы
 * @author Бильдюг Евгений Борисович
 * @verion 1.00 от 2019.03.17
 */

import java.util.Scanner;

public class Runner {
    /**
     * @param args просто мейн
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        double[] array = InOut.getArray(string);
        InOut.printArray(array);
        InOut.printArray(array, "i", 5);
        Helper.findMin(array);
        Helper.findMax(array);
        Helper.sort(array);
        InOut.printArray(array);

        double[][] matrix1 = {{1, 2, 3},
                              {4, 5, 6}};
        double[][] matrix2 = {{1, 2},
                              {3, 4},
                              {5, 6}};
        double[] vector = {1, 2, 3};
        Helper.mul(matrix1, vector);
        Helper.mul(matrix1, matrix2);
        InOut.printArray1D(Helper.mul(matrix1, vector));
        InOut.printArray2D(Helper.mul(matrix1, matrix2));
    }
}


