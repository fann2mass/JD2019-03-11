package by.it.narushevich.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskA {

    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        String filename = createFile(TaskA.class, "dataTaskA.bin");
        String fileResultToTxt = createFile(TaskA.class, "resultTaskA.txt");

        writeFile(filename);

        readAndPrintToFile(filename, fileResultToTxt);
    }

    private static String createFile(Class<?> cl, String name) {
        String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String replacePath = cl.getPackage().getName().replace(".", File.separator);
        return src + replacePath + File.separator + name;
    }

    private static void writeFile(String filename) {
        try (DataOutputStream dataOutputStream =
                     new DataOutputStream(
                             new BufferedOutputStream(
                                     new FileOutputStream(filename)))
        ) {
            for (int i = 0; i < 20; i++) {
                int value = (int) (Math.random() * 40);
                dataOutputStream.writeInt(value);
                list.add(value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readAndPrintToFile(String filename, String fileResultToTxt) {
        try (DataInputStream dataInputStream =
                     new DataInputStream(
                             new BufferedInputStream(
                                     new FileInputStream(filename)));
             PrintWriter printWriter = new PrintWriter(new FileWriter(fileResultToTxt))
        ) {
            double sum = 0;
            double avg;
            while (dataInputStream.available() > 0) {
                int number = dataInputStream.readInt();
                sum += number;
                System.out.print(number + " ");
                printWriter.print(number + " ");
            }
            avg = sum / list.size();
            System.out.print("\navg=" + avg);
            printWriter.print("\navg=" + avg);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
