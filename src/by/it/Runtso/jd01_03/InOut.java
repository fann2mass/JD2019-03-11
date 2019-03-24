package by.it.Runtso.jd01_03;

public class InOut {

    static double[]  getArray(String line){
        line.trim();
        String[] strArray = line.split(" ");
        double[] mas=new double[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            mas[i]=Double.parseDouble(strArray[i]);
        }
        return mas;
    }

    static void printArray(double[] arr ){
        for (double v : arr) {
            System.out.print(v + " ");
        }
        System.out.println();

    }

    static void printArray(double[] arr, String name, int columnCount){
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -3d]=%10.4f",name,i,arr[i]);
            if((i+1)%columnCount==0 || i+1==arr.length)
                System.out.println();

        }


    }

}
