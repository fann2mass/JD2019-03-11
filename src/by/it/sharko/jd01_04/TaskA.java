package by.it.sharko.jd01_04;

class TaskA {

    public static void main(String[] args) {



        for (int i = 2; i < 10; i++) {
            for (int j = 2; j < 10; j++) {

                System.out.printf("%d" + "*" + "%d" + "=" + "%-3d ", i, j, i * j);
            }
            System.out.println();
        }

        //static void buildOneDimArray(String line) {
          //  double[] array = InOut.getArray(line);
            //InOut.printArray(array, "V", 5);
        }

    }
