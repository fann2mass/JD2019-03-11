package by.it.bolotko.jd01_03;



class InOut {
    /**
     * @author статический метод ввода одномерного массива
     * @param line входной одномерный массив
     * @return возвращаемый тип double
     */
    static double[ ] getArray(String line){
        String[] strArr = line.split(" ");
        double[] res=new double[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            res[i]=Double.parseDouble(strArr[i]);
        }
        return res;
    }

    /**
     * @author статический метод простого вывода одномерного массива
     * @param arr входной массив
     */
    static void printArray(double[ ] arr){
        for (double element : arr) {
            System.out.print(element+ " ");
        }
        System.out.println();
    }

    /**
     * @author статический метод форматного вывода одномерного массива
     * @param arr входной массив
     * @param name имя на экране
     * @param columnCount число столбцов
     */
    static void printArray(double[ ] arr, String name, int columnCount){
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -3d]=%-10.4f ",name,i,arr[i]);
            if ((i+1)%columnCount==0 || i+1==arr.length)
                System.out.println();
        }
    }
}
