package by.it.narushevich.jd01_15;

import java.io.File;

public class TaskA {

    private static String createFile(Class<?> cl, String name) {
        String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String replacePath = cl.getPackage().getName().replace(".", File.separator);
        return src + replacePath + File.separator + name;
    }

    public static void main(String[] args) {
        int[][] array = create(6, 4, 15);
        String filename = createFile(TaskA.class, "matrix.txt");

    }

    private static int[][] create(int rows, int cols, int max) {
        int [] [] result = new int[rows][cols];
        boolean maxOk;
        boolean minOk;
        do {
            maxOk = false;
            minOk = false;
            for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = (int) (Math.random() * 31) - 15;
                if(result[i][j]==max) maxOk=true;
                if(result[i][j]==-max) minOk=true;

            }
        }



        } while (!(maxOk && minOk));
        return result;
    }
}
