package by.it.vasiliuk.jd01_04;

class Helper {
    /**
     * @author статический метод для поиска минимального значения
     * @param arr входной массив
     * @return возвращаемый тип double
     */
    static double findMin(double[ ] arr){
        double min=arr[0];
        for (double element : arr) {
            if (min > element) min = element;
        }
        System.out.println(min);
        return min;
    }

    /**
     * @author статический метод для поиска максимального значения
     * @param arr входной массив
     * @return возвращаемый тип double
     */
    static double findMax(double[ ] arr){
        double max=arr[0];
        for (double element : arr) {
            if (max < element) max = element;
        }
        System.out.println(max);
        return max;
    }

    /**
     * @author статический метод для сортировки по возрастанию одномерных массивов
     * @param arr входной массив
     */
    static void sort(double[ ] arr){ //метод сортировки "bubble"
        boolean swap;
        double last=arr.length-1;
        do {
            swap=false;
            for (int i = 0; i < last; i++) {
                if (arr[i]>arr[i+1]) {
                    double buffer = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = buffer;
                    swap = true;
                }
            }
            last--;
        }
        while (swap);
        for (double element : arr) {
            System.out.print(element+" ");
        }
        System.out.println();
    }

    /**
     * @author статический метод умножения матрицы на вектор
     * @param matrix входной двухмерный массив
     * @param vector входной одномерный массив
     * @return возвращаемый тип double
     */
    static double[ ] mul(double[][] matrix, double[] vector){
        System.out.println("\nРезультат умножения матрицы на вектор: ");
        double[] result=new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                result[i]=result[i]+matrix[i][j]*vector[j];
            }
            System.out.print(result[i]+" ");
        }
        System.out.println();
        return result;
    }

    /**
     * @author статический метод умножения матрицы на матрицу
     * @param matrixLeft входной двумерный массив
     * @param matrixRight входной двумерный массив
     * @return возвращаемый тип double
     */
    static double[ ][ ] mul(double[ ][ ] matrixLeft, double[ ][ ] matrixRight){
        System.out.println("\nРезультат умножения матрицы на матрицу: ");
        double[][] result=new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    result[i][j] = result[i][j] + matrixLeft[i][k] * matrixRight[k][j];
                }
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
        return result;
    }
}
