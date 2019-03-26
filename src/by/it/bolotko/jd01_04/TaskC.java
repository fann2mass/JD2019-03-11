package by.it.bolotko.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String line = scanner.nextLine();
        buildOneDimArray(line);

    }
    private static void buildOneDimArray(String line){
        double[] array = InOut.getArray(line);
        InOut.printArray(array,"V",5);
        double first=array[0];
        double last=array[array.length-1];
        mergeSort(array);
        InOut.printArray(array,"V",5);
        int iFirst = Arrays.binarySearch(array, first);
        System.out.printf("Index of first element=%d%n",iFirst);

        for (int i = 0; i < array.length; i++) {
            if (last==array[i]){
                System.out.printf("Index of last element=%d%n",i);
                break;
            }
        }
    }
    public static void mergeSort(double[]array){

    }

    /*public static double[] mergeSort(double[] array) {
        if (array.length <= 1)  return array;

        int mid = array.length / 2;
        double[] left = new double[mid];
        double[] right = new double[mid + array.length%2];

        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (i < array.length / 2) {
                left[i] = array[i];
            } else {
                right[j++] = array[i];
            }
        }
        return Merge(mergeSort(left), mergeSort(right));
    }

    public static double[] Merge(double[] left, double[] right) {
        int a = 0, b = 0;
        double[] merged = new double[left.length + right.length];
        //забиваем отсортированный массив из левой и правой частей
        for (int i = 0; i < left.length + right.length; i++) {
            //поочередно берем меньший член из крайних левого и правого
            if (b < right.length && a < left.length)
                if (left[a] > right[b] && b < right.length)
                    merged[i] = right[b++];
                else
                    merged[i] = left[a++];
            else
            if (b < right.length)
                merged[i] = right[b++];
            else
                merged[i] = left[a++];
        }
        return merged;
    }*/

    /*static double[] mergeSort(double[] array){
        if(array.length < 2) return array;
        double m = array.length / 2;
        double[] array1 = Arrays.copyOfRange(array, 0, (int) m);
        double[] array2 = Arrays.copyOfRange(array, (int) m, array.length);
        return merge(mergeSort(array1), mergeSort(array2));
    }
    //слияние двух массивов в один отсортированный
    public static double[] merge(double[] array1,double array2[]){
        double n = array1.length + array2.length;
        double[] array = new double[(int) n];
        int i1=0;
        int i2=0;
        for(int i=0;i<n;i++){
            if(i1 == array1.length){
                array[i] = array2[i2++];
            }else if(i2 == array2.length){
                array[i] = array1[i1++];
            }else{
                if(array1[i1] < array2[i2]){
                    array[i] = array1[i1++];
                }else{
                    array[i] = array2[i2++];
                }
            }
        }
        return array;
    }*/
}
