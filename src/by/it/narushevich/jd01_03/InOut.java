package by.it.narushevich.jd01_03;

public class InOut {

    /**
     * @param line вводится с клавиатуры
     * @return результатом метода становится массив из чисел в формате double
     */
    static double[] getArray(String line) {
        String[] strArr = line.split(" ");
        double[] result = new double[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            result[i] = Double.parseDouble(strArr[i]);
        }
        return result;
    }

    /**
     * @param arr метод на вход получает массив из чисел в формате double
     */
    static void printArray(double[] arr) {
        for (double element : arr) {
            System.out.print(element + " ");
        }
        System.out.println("\n");
    }

    /**
     * Метод обрабатывается следующие параметры:
     *
     * @param arr         - массив из чисел в формате double
     * @param name        - символ, имя элемента
     * @param columnCount - число колонок в отформатированном массиве
     */
    static void printArray(double[] arr, String name, int columnCount) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -3d]=%-6.2f ", name, i, arr[i]);
            if ((i + 1) % columnCount == 0 || i + 1 == arr.length)
                System.out.println();
        }
    }

    static double[][] createMatrix(int rows, int columns) {
        double[][] matrix = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = Math.round(Math.random() * 9);
                System.out.print(matrix[i][j] + "\t\t");
            }
            System.out.println();
        }
        return matrix;
    }

    static double[] createArray(int rows) {
        double[] vector = new double[rows];
        for (int i = 0; i < rows; i++) {
            vector[i] = Math.round(Math.random() * 9);
            System.out.print(vector[i] + " ");
        }
        System.out.println();
        return vector;
    }
}