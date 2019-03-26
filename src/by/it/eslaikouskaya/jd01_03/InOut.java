package by.it.eslaikouskaya.jd01_03;

class InOut {
    /**
     * Получение массива из строки
     * @param line Строка чисел (с плавающей точкой) разделенных пробелом
     * @return на выходе массив чисел
     */
    static double[] getArray(String line) {
        line = line.trim();
        String[] strArr = line.split(" ");
        double[] getArr = new double[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            getArr[i] = Double.parseDouble(strArr[i]);
        }
        return getArr;
    }

    /**
     * Вывод массива
     * @param arr входной массив
     */
    static void printArray(double[] arr) {
        for (double element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    /**
     *  Вывод массива в отформатированном виде
     * @param arr входной массив
     * @param name имя на экране
     * @param columnCount число столбцов для вывода
     */
    static void printArray(double[] arr, String name, int columnCount) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[%1d]=%-10.4f ", name, i, arr[i]);
            if ((i + 1) % columnCount == 0 || i + 1 == arr.length) System.out.println();

        }

    }
}
