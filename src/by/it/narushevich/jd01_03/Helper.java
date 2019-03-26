package by.it.narushevich.jd01_03;

class Helper {

    /**
     * @param arr - массив, в котором нужно найти минимальное значение
     * @return результат минимальное значение элемента в массиве
     */
    static double findMin(double[] arr) {
        double min = Double.MAX_VALUE;
        for (double element : arr) {
            if (min > element) min = element;
        }
        System.out.println(min);
        return min;
    }

    /**
     * @param arr - массив, в котором нужно найти максимальное значение
     * @return результат максимальное значение элемента в массиве
     */
    static double findMax(double[] arr) {
        double max = Double.MIN_VALUE;
        for (double element : arr) {
            if (max < element) max = element;
        }
        System.out.println(max);
        return max;
    }

    /**
     * @param arr - массив для сортировки
     */
    static void sort(double[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    double buffer = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = buffer;
                }
            }
        }
        for (double element : arr) {
            System.out.print(element + " ");
        }
    }


    /**
     * @param matrix - матрица, генерируемая через метод, получающий на вход число строк и столбцов
     * @param vector - вектор, генерируемый через метод, получающий на вход число элементов равное числу строк матрицы
     * @return - итоговый вектор, полученный произведением матрицы на вектор
     */
    static double[] mul(double[][] matrix, double[] vector) {
        double[] resultVector = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                resultVector[i] = resultVector[i] + matrix[i][j] * vector[j];
                System.out.print(resultVector[i] + " ");
            }
            System.out.println();
        }
        return resultVector;
    }


    /**
     * @param matrixLeft  - матрица 1, генерируемая через метод, получающий на вход число строк и столбцов
     * @param matrixRight - матрица 2, генерируемая через метод, получающий на вход число строк и столбцов
     * @return - итоговая матрица, полученная произведением матрицы 1 на матрицу 2
     */
    static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {
        double[][] mulMatrix = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++)
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    mulMatrix[i][j] = mulMatrix[i][j] + matrixLeft[i][k] * matrixRight[k][j];
                    System.out.print(mulMatrix[i][j] + "\t\t");
                }
                System.out.println();
            }
        return mulMatrix;
    }
}



