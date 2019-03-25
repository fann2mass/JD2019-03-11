package by.it.khlystunova.jd01_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Runner {

    public static void main(String[] args) throws Exception{

        //String line = getLine();
        String line = "1.5 1.4 1.0 -1.3 -1.2";
        //задание A
        double[] array = InOut.getArray(line);
        InOut.printArray(array);
        InOut.printArray(array, array.length);
        //задание B
        System.out.println("Min = "+Helper.findMin(array));
        System.out.println("Max = "+Helper.findMax(array));
        //сортировка массива по возрастанию
        Helper.sort(array);
        InOut.printArray(array);
        //задание С
        double[][] matrix ={{1.2,1.3,1.4},{1.3,2.3,2.4}};
        double[] vector = {1.2 ,1.3 ,1.4};
        System.out.println(Arrays.toString(Helper.mul(matrix,vector)));

        double[][]matrix2 = {{1.4,1.3},{2.3,2.3}};
        System.out.println(Arrays.toString(Helper.mul(matrix,matrix2)));
    }

    private static String getLine() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        System.out.println(line);
        return line;
    }
}
