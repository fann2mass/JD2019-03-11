package by.it.khlystunova.jd01_03;

import java.util.Arrays;

class InOut {
    /**
     *  Преобразует строку в double[] массив
     * @author Liza Khlystunova
     * @param line переданная строка
     * @return возвращает массив типа double[]
     * @version 2019-03-15
     *
     */
    static double[] getArray(String line){

        String[] strArrays = line.trim().split(" ");
        double[] result = new double[strArrays.length];
        for (int i = 0; i < strArrays.length; i++) {
          result[i] = Double.parseDouble(strArrays[i]);
        }


        return result;
    }
    /**
     * выводит массив типа double[] array
     * @author Liza Khlystunova
     * @param array входной массив
     * @version 2019-03-15
     *
     */
    static void printArray(double[]array){
        System.out.println(Arrays.toString(array));

    }
    /**
     * Отформатировано выводит массива типа double[] array
     * @author Liza Khlystunova
     * @param array входной массив
     * @param cols число столбцов для вывода
     * @version 2019-03-15
     *
     */
    static void printArray(double[] array, int cols){

        for (int i = 0; i < array.length; i++) {
            System.out.print("arr");
            System.out.printf("[% -3d]=%-6.2f ",i,array[i]);
            if((0==(i+1)%cols)||(array.length-1==i)){

                System.out.println();
            }
        }
    }
}
