package by.it.bildziuh.jd01_04;


import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String doubleLine = scanner.nextLine();
        buildOneDimArray(doubleLine);
    }

       static void buildOneDimArray(String line) {
           double[] array = InOut.getArray(line);
           InOut.printArray(array, "V", 5);
           double iFirst = array[0];
           double iLast = array[array.length - 1];
           TaskC.mergeSort(array);
           int newFirst = TaskC.binarySearch(array,iFirst);
           int newLast = TaskC.binarySearch(array,iLast);
           InOut.printArray(array, "V", 4);
           System.out.println("Index of first element=" + newFirst);
           System.out.println("Index of last element=" + newLast);

       }

    static void mergeSort(double[] array) {
        if (array.length > 1) {
            int mid = array.length / 2;
            double[] leftArray = new double[mid];
            System.arraycopy(array, 0, leftArray, 0, leftArray.length);
            double[] rightArray = new double[array.length - mid];
            System.arraycopy(array, mid, rightArray, 0,rightArray.length );

                mergeSort(leftArray);
                mergeSort(rightArray);
                merge(leftArray, rightArray);

                double[] result = merge(leftArray, rightArray);
                System.arraycopy(result,0,array,0,array.length);
            }
        }

    private static double[] merge(double[] left, double[] right) {
        int size = left.length + right.length;
        double[] merged = new double[size];
        int indexLeft = 0;
        int indexRight = 0;
        int indexMerged = 0;
        while (indexLeft < left.length && indexRight < right.length) {
            if (left[indexLeft] <= right[indexRight]) {
                merged[indexMerged] = left[indexLeft];
                indexLeft++;
                indexMerged++;
            } else {
                merged[indexMerged] = right[indexRight];
                indexRight++;
                indexMerged++;
            }
        }
        while (indexLeft < left.length) {
            merged[indexMerged] = left[indexLeft];
            indexLeft++;
            indexMerged++;
        }
        while (indexRight < right.length) {
            merged[indexMerged] = right[indexRight];
            indexRight++;
            indexMerged++;
        }
        return merged;
    }
    private static int binarySearch(double[] array, double value) {
        int index = Integer.MAX_VALUE;

        int low = 0;
        int high = array.length-1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] < value) {
                low = mid + 1;
            } else if (array[mid] > value) {
                high = mid - 1;
            } else if (array[mid] == value) {
                index = mid;
                break;
            }
        }
        return index;
    }


}

