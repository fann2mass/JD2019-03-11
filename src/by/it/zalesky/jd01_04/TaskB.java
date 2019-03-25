package by.it.zalesky.jd01_04;

public class TaskB {
    public  static double findMin(double[] array) {
    if (array.length != 0) {
        double min = array[0];
        for (double v : array) {
            if (min > v) {
                min = v;
            }
        }
        return min;
    }
        else return 0;
}
    public static double findMax(double[] array) {
        if (array.length != 0) {
            double max = array[0];
            for (double v : array) {
                if (max < v) {
                    max = v;
                }
            }
            return max;
        }
        else return 0;
    }
    public static void sort(double[] array) {
        for (int min = 0; min < array.length - 1; min++) {
            int least = min;
            for (int j = min + 1; j < array.length; j++) {
                if (array[j] < array[least]) {
                    least = j;
                }
            }
            double tmp = array[min];
            array[min] = array[least];
            array[least] = tmp;
        }
    }
}
