package by.it.narushevich.jd01_14;

import java.io.*;

public class TaskA {
    public static void main(String[] args) throws FileNotFoundException {
        //Записать в двоичный файл dataTaskA.bin 20 случайных чисел типа Integer.
        // Файл должен быть в том же каталоге, что и исходный код для класса
        //TaskA.java.
        // Затем нужно прочитать записанный файл в коллекцию ArrayList.
        // Вывести в консоль прочитанные числа через пробел
        // Вывести с новой строки их среднее арифметическое avg=20.123.
        // Продублировать вывод в консоль в файл resultTaskA.txt
        String filename = getFileName(TaskA.class, "dataTaskA.bin");

        try (
                FileOutputStream fileOutputStream = new FileOutputStream(filename);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                DataOutputStream dataOutputStream = new DataOutputStream(bufferedOutputStream)
        ) {
            for (int i = 0; i < 20; i++) {
                Integer value = (int) (Math.random() * 101 - 50);
                dataOutputStream.writeInt(value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (DataInputStream dataInputStream = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(filename)))) {
            while (dataInputStream.available()>0){
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static String getFileName(Class<?> cl, String name) {
        String src = System.getProperty("user.dir");
        String strPackage = cl.getPackage().getName();
        String relPath = strPackage.replace(".", File.separator);
        return src + relPath + File.separator + name;
    }
}
