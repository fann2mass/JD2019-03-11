package by.it.khlystunova.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskC {

    static void buildOneDimArray(String line){
        double[] array = InOut.getArray(line);
        InOut.printArray(array,"V",5);
        double first = array[0];
        double last = array[array.length-1];
        Arrays.sort(array);
        InOut.printArray(array,"V",4);

        int iFirst= TaskC.binarySearch(array,first);
        System.out.printf("Index of first element=%d%n",iFirst);

        int iSecond= TaskC.binarySearch(array,last);
        System.out.printf("Index of last element=%d%n",iSecond);

    }

    private static void mergeSort(double[]array){
        int left =0;
        int right = array.length;
        array = TaskC.mergeSort(array,left,right);
    }

    private static double[]  mergeSort(double[] array,int left,int right) {
      int middle = array.length/2;
      return merge(mergeSort(array,left,middle),mergeSort(array,middle,array.length));
    }
    private static double[] merge(double[] part1, double[] part2){
      double[] result = new double[part1.length+part2.length];
      int a =0;
      int b = 0;
        for (int i = 0; i < result.length; i++) {
            if(a<part1.length && b<part2.length){
               if(part1[a]<part2[b]) {
                   result[i] = part1[a++];
               }else result[i]= part2[b++];

            }else if (a<part1.length){
                result[i] = part1[a++];

            }else result[i] = part2[b++];
        }
      return result;
    }
    //бинарный поиск индекса элемента в отсортированном массиве по значению
    static int binarySearch(double[ ] array, double value) {
       int leftIndex = 0;
       int rightIndex = array.length-1;
       while(leftIndex<=rightIndex){
           int middleIndex = (leftIndex+rightIndex)/2;
           if(value == array[middleIndex]){
               return middleIndex;
           }else if(value>array[middleIndex]){
                  leftIndex=middleIndex+1;
           }else if(value<array[middleIndex]){
               rightIndex=middleIndex-1;
           }
       }
       return -1;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        TaskC.buildOneDimArray(line);
    }
}
