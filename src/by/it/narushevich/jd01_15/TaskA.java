package by.it.narushevich.jd01_15;

import java.io.*;

public class TaskA {

    private static String createFile(Class<?> cl, String name) {
        String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String replacePath = cl.getPackage().getName().replace(".", File.separator);
        return src + replacePath + File.separator + name;
    }

    public static void main(String[] args) {
        int[][] array = create(6, 4, 15);
        String filename = createFile(TaskA.class, "matrix.txt");
        saveMatrix(array, filename);
        showFile(filename);

    }

    private static void showFile(String filename) {
        try (BufferedReader in = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void saveMatrix(int[][] array, String filename) {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(filename))) {
            for (int[] row : array) {
                for (int element : row) {
                    printWriter.printf("%3d ", element);
                }
                printWriter.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int[][] create(int rows, int cols, int max) {
        int[][] result = new int[rows][cols];
        boolean maxOk;
        boolean minOk;
        do {
            maxOk = false;
            minOk = false;
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    result[i][j] = (int) (Math.random() * 31) - 15;
                    if (result[i][j] == max) maxOk = true;
                    if (result[i][j] == -max) minOk = true;
                }
            }
        } while (!(maxOk && minOk));
        return result;
    }
}
