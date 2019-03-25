package by.it.narushevich.jd01_04;

class Helper {

    /**
     * @param arr - массив для сортировки
     */
    static void sort(double[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    double buffer = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = buffer;
                }
            }
        }
        for (double element : arr) {
            System.out.print(element + " ");
        }
    }

}



