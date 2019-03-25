package by.it.bildziuh.jd01_04;

/**
 * Класс математических операций
 */

public class Helper {
    /**
     * Находит минимальное число в массиве
     *
     * @param arr массив чисел
     * @return минимальное значение в массиве
     */

    static double findMin(double[] arr) {
        double min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i])
                min = arr[i];
        }
        return min;
    }

    /**
     * @param arr массив чисел
     * @return максимальное значение в массиве
     */
    static double findMax(double[] arr) {
        double max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i])
                max = arr[i];
        }
        return max;
    }

    /**
     * @param arr сортировка массива пузырьковым методом по возрастанию
     */

    static void sort(double[] arr) {
        for (int j = arr.length - 1; j > 0; j--) {
            for (int i = 0; i < j; i++) {
                if (arr[i] > arr[i + 1]) {
                    double temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
    }

    /**
     * @param matrix матрица
     * @param vector вектор
     * @return result результат умножения матрицы на вектор
     */
    static double[] mul(double[][] matrix, double[] vector) {
        double[] result = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                result[i] = result[i] + matrix[i][j] * vector[j];
            }
        }
        return result;
    }

    /**
     * @param matrixLeft  матрица номер 1
     * @param matrixRight матрица номер 2
     * @return result результат умножения двух матриц
     */
    static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {
        double[][] result = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++)
            for (int j = 0; j < matrixRight[0].length; j++)
                for (int k = 0; k < matrixRight.length; k++)
                    result[i][j] = result[i][j] + matrixLeft[i][k] * matrixRight[k][j];
        return result;
    }
}



