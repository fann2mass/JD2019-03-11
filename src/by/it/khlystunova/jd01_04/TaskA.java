package by.it.khlystunova.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskA {
    static void printMulTable(){
        for (int i = 2; i < 10 ; i++) {
            for (int j = 2; j < 10 ; j++) {
                int result = j*i;
                System.out.printf("%-1d%-1s%-1d%-1s%-2d%s",i,"*",j,"=",result," ");
            }
            System.out.println();
        }
    }

     static void buildOneDimArray(String line){
        double[] array = InOut.getArray(line);
        InOut.printArray(array,"V",5);
        double first = array[0];
        double last = array[array.length-1];
        Helper.sort(array);
        InOut.printArray(array,"V",4);

        int iFirst= Arrays.binarySearch(array,first);
        System.out.printf("Index of first element=%d%n",iFirst);

        int iSecond= Arrays.binarySearch(array,last);
        System.out.printf("Index of last element=%d%n",iSecond);

    }

    public static void main(String[] args) {
        printMulTable();
        Scanner scanner = new Scanner(System.in);
        String i = scanner.nextLine();
        buildOneDimArray(i);
    }
}
