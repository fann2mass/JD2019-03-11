package by.it.bildziuh.jd01_04;


public class TaskC {
    public static void main(String[] args) {

        //Scanner scanner = new Scanner(System.in);
        //String doubleLine = scanner.nextLine();
        double[] array = {1, 9, 7, 2, 6, 4, 3, 11};
        TaskC.mergeSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
    /*   static void buildOneDimArray(String line) {
           double[] array = InOut.getArray(line);
           InOut.printArray(array, "V", 5);
           double iFirst = array[0];
           double iLast = array[array.length - 1];

           InOut.printArray(array, "V", 4);
           for (int i = 0; i < array.length; i++) {
               if (iFirst == array[i]) {
                   System.out.println("Index of first element=" + i);
                   break;
               }
           }
           for (int i = 0; i < array.length; i++) {
               if (iLast == array[i]) {
                   System.out.println("Index of last element=" + i);
                   break;
               }
           }
       }   */
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
}



