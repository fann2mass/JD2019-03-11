package by.it.bildziuh.jd01_04;

/** Класс ввода-вывода информации
 */
public class InOut {
    /**
     *
     * @param line строка чисел
     * @return возвращает массив чисел
     */
    static double[] getArray(String line) {
        String[] stringArray = line.split(" ");
        double[] result = new double[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            result[i] = Double.parseDouble(stringArray[i]);
        }
        return result;
    }

    /**
     *
     * @param arr вывод на печать массива
     */
    static void printArray(double[] arr) {
        for (double element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
        System.out.println();
    }

    /**
     *
     * @param arr массив чисел
     * @param name наименование ячейки в матрице
     * @param columnCount количество столбцов в одной строке
     */

    static void printArray(double[] arr, String name, int columnCount) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -3d]=%-7.3f" ,name,i,arr[i]);
            if ((i+1)%columnCount==0 || i+1 ==arr.length)
                System.out.println();
        }
        System.out.println();
    }

    /**
     *
     * @param matrix матрица с двумя и более строками
     */
    static void printArray2D(double[][]matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length ; j++)
                System.out.printf("[%1d,%1d]=%-6.1f ",i,j,matrix[i][j]);
                System.out.println();
        }
        System.out.println();
    }

    /**
     *
     * @param matrix матрица с одной строкой
     */
    static void printArray1D(double[]matrix){
        for (int i = 0; i < matrix.length; i++) {
            int j = 0;
                System.out.printf("[%1d,%1d]=%-6.1f ",i,j,matrix[i]);
                System.out.println();
        }
        System.out.println();
    }

}
