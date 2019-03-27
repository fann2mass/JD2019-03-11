package by.it.Runtso.jd01_03;

public class Helper {
    static double findMin(double[] arr){
        double min=0;
        for (double v : arr) {
            if(min>v) min=v;
        }
        return min;

    }

    static  double findMax(double[] arr){
        double max=0;
        for (double v : arr) {
            if(max<v) max=v;
        }
        return max;
    }

    static void sort(double[] arr) {
        int last = arr.length - 1;
        boolean swap;
        do {
            swap = false;
            for (int i = 0; i < last; i++) {
                if (arr[i] > arr[i + 1]) {
                    double temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swap=true;
                }
            }

        }while(swap);
    }
    }

