package by.it.khlystunova.jd01_15;

import java.io.File;

/*Класс TaskA
Создайте матрицу 6 строк на 4 столбца из целых случайных чисел от -15 до 15 включительно.
Выведите матрицу в текстовый файл matrix.txt, расположенный в папке задания jd01_15.
 При выводе для каждого числа нужно предусмотреть для него три знакоместа,
 после чисел –один пробел.
Прочитайте файл и покажите его в консоли. Класс Scanner использовать нельзя.*/
public class TaskA {

    private static String getFileName(String name) {
        String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String strPackage = by.it.khlystunova.jd01_14.TaskA.class.getPackage().getName();
        String relPath = strPackage.replace(".", File.separator);
        return src + relPath + File.separator + name;
    }

    public static void main(String[] args) {
        int[][] array = create(6,4,15);

        for (int[] row : array) {
            for (int element : row) {
                System.out.printf("%3d ",element);
            }
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
                }
            }
        }while (!maxOk && minOk);
            return result;

    }
}
