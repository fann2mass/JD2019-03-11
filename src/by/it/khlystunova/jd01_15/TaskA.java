package by.it.khlystunova.jd01_15;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*Класс TaskB
Создайте матрицу 6 строк на 4 столбца из целых случайных чисел от -15 до 15 включительно.
Выведите матрицу в текстовый файл matrix.txt, расположенный в папке задания jd01_15.
 При выводе для каждого числа нужно предусмотреть для него три знакоместа,
 после чисел –один пробел.
Прочитайте файл и покажите его в консоли. Класс Scanner использовать нельзя.*/

public class TaskA {

    private static String getFileName() {
        String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String strPackage = TaskA.class.getPackage().getName();
        String relPath = strPackage.replace(".", File.separator);
        return src + relPath + File.separator + "matrix.txt";
    }

    public static void main(String[] args) {
        int[][] array = create();
        String filename=getFileName();
        saveMatrix(array, filename);
        showFile(filename);
    }

    private static int[][] create() {
        int[][] result = new int[6][4];
        boolean maxOk;
        boolean minOk;
        do {
            maxOk=false;
            minOk=false;
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    result[i][j] = (int) (Math.random() * (15 *2+1)) - 15;
                    if (result[i][j]== 15) maxOk=true;
                    if (result[i][j]==-15) minOk=true;
                }
            }
        } while (!(maxOk && minOk));
        return result;
    }

    private static void saveMatrix(int[][] array, String filename) {
        try (PrintWriter out=new PrintWriter(new FileWriter(filename))){
            for (int[] row : array) {
                for (int element : row) {
                    out.printf("%3d ",element);
                }
                out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void showFile(String filename) {
        try (BufferedReader in=new BufferedReader(new FileReader(filename))){
            String line;
            while ((line=in.readLine())!=null){
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}