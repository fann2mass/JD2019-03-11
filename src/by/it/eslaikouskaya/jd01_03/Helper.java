package by.it.eslaikouskaya.jd01_03;

class Helper {
    /**
     * Поиск минимума для массива DOUBLE
     * @param arr - одномерный массив
     * @return минимум или Integer.MIN_VALUE если массив пустой
     */
    static double findMin(double[] arr) {
        if (arr.length == 0) return Integer.MIN_VALUE;
        else {
            double min = arr[0];
            for (double v : arr) {
                if (v < min)
                    min = v;
            }
            return min;
        }
    }

    /**
     * Поиск максимума для массива DOUBLE
     * @param arr - одномерный массив
     * @return максимум или Integer.MAX_VALUE если массив пустой
     */
    static double findMax(double[] arr) {
        if (arr.length == 0) return Integer.MAX_VALUE;
        else {
            double max = arr[0];
            for (double m : arr) {
                if (max < m) max = m;
            }
            return max;
        }
    }

    /**
     * Сортировка Bubble
     * @param arr Исходный массив
     */
    static void sort(double[] arr) {
        double last = arr.length - 1;
        boolean swap;
        do {
            swap = false;
            for (int i = 0; i < last; i++) {
                if (arr[i] > arr[i + 1]) {
                    double tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                    swap = true;
                }
            }
            last--;
        }
        while (swap);
        for (double element : arr) {
            System.out.print(element + " ");
        }
    }

    /**
     * Умножение массива на вектор
     * @param matrix исходный массив
     * @param vector исходныц вектор
     * @return одномерный массив double
     */
    static double[] mul(double[][] matrix, double[] vector) {
        double[] z = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < vector.length; j++)
                z[i] = z[i] + matrix[i][j] * vector[j];
        return z;
    }

    /**
     * Умножение массива на массив
     * @param matrixLeft исходный массив 1
     * @param matrixRight исходный массив 2
     * @return двумерный массив double
     */
    static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {
        double[][] z = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++)
            for (int j = 0; j < matrixRight[0].length; j++)
                for (int k = 0; k < matrixRight.length; k++) {
                    z[i][j]=z[i][j]+matrixLeft[i][k]*matrixRight[k][j];
                }
        return z;
    }




}


