package by.it.akhmelev.jd01_04;


class InOut {

    static double[] getArray(String line){
        String[] strArray = line.trim().split(" ");
        int size = strArray.length;
        double[] result=new double[size];
        for (int i = 0; i < strArray.length; i++) {
            result[i] = Integer.parseInt(strArray[i]);
        }
        return result;
    }


    static void printArray(double[] array) {
        for (double element : array) {
            System.out.print(element+" ");
        }
        System.out.println();
    }


    static void printArray(double[] array, String name, int cols) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s[% -3d]=%-8.3f ",name,i,array[i]);
            if ((i+1)%cols==0)
                System.out.println();
        }
        System.out.println();
    }
}
