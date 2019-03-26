package by.it.khlystunova.jd01_04;

public class Helper {

    /**
     * Находит минимальный элемент в переданном массиве типа double
     * @author Liza Khlystunova
     * @param array входной массив
     * @return double
     * @version 2019-03-15
     *
     */
 public  static double findMin(double[] array) {
        if (array.length != 0) {
            double min = array[0];
            for (int i = 0; i < array.length; i++) {
                if (min > array[i]) {
                    min = array[i];
                }
            }
            return min;
        }
        else return 0;
    }

    public static double findMax(double[] array) {
        if (array.length != 0) {
            double max = array[0];
            for (int i = 0; i < array.length; i++) {
                if (max < array[i]) {
                    max = array[i];
                }
            }
            return max;
        }
        else return 0;
    }
    /**
     * Сортирует массив по возрастанию(сортировка выбором)
     * @author Liza Khlystunova
     * @param array входной массив
     * @version 2019-03-15
     *
     */
    public static void sort(double[] array) {
            for (int min = 0; min < array.length - 1; min++) {
                int least = min;
                for (int j = min + 1; j < array.length; j++) {
                    if (array[j] < array[least]) {
                        least = j;
                    }
                }
                double tmp = array[min];
                array[min] = array[least];
                array[least] = tmp;
            }
        }
    /**
     * Умножает матрицу(двухмерный массив) на вектор(одномерный массив)
     * @author Liza Khlystunova
     * @param matrix входной двухмерный массив
     *  @param vector входной одномерный массив
     * @return возвращает одномерный массив типа double[]
     * @version 2019-03-15
     *
     */
    public static double[] mul(double[][] matrix, double[] vector) {
        double[]result = new double[matrix.length];//размер двух мехмерной матрицы равен колличесву строк.
        for (int i = 0; i <matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                result[i]= result[i]+matrix[i][j]*vector[j];
            }
        }
        return result;
    }
    /**
     * Умножает матрицу(двухмерный массив)на матрицу
     * @author Liza Khlystunova
     * @param matrix входной двухмерный массив
     *  @param matrix2 входной двухмерный массив
     * @return возвращает двухмерный массив типа double[], при несогласованности матриц(кол-во строк 1-ой матрицы должно равняться кол-ву столбцов во 2-ой матрице)выбрасывает ArrayIndexOutOfBoundsException.
     * @version 2019-03-15
     *
     */
    public static double[][] mul(double[][] matrix, double[][]matrix2) {
        double[][] result = new double[matrix.length][matrix2[0].length];//matrix[0].length - кол-во элементов(столбцов) в первой строке массива.
       //выполнять только когда число столбцов 1 матрицы = числу строк 2 матрицы.
        if (matrix[0].length == matrix2.length) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix2[0].length; j++) {
                    for (int k = 0; k < matrix2.length; k++) {
                        result[i][j] = result[i][j] + matrix[i][k] * matrix2[k][j];
                    }

                }
            }

        }else throw  new ArrayIndexOutOfBoundsException();
        return result;
    }
}


