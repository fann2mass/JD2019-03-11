package by.it.narushevich.jd01_04;

class InOut {

    /**
     * @param line строка символов, вводится с клавиатуры
     * @return результатом метода становится массив из чисел в формате double
     */
    static double[] getArray(String line){
        String[] strArr = line.split(" ");
        double [] result = new double[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            result[i]=Double.parseDouble(strArr[i]);
        }
        return result;
    }

    /** Метод обрабатывается следующие параметры:
     * @param arr - массив из чисел в формате double
     * @param name - символ, имя элемента
     * @param columnCount - число колонок в отформатированном массиве
     */
    static void printArray(double[] arr, String name, int columnCount){
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -3d]=%-6.2f ", name, i, arr[i]);
            if ((i+1)%columnCount==0 || i+1==arr.length)
                System.out.println();
        }
    }
}