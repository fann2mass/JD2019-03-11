package by.it.vasiliuk.jd01_14;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class TaskA {

    private static String getFileName(String name) {
        String source = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String strPackage = TaskA.class.getPackage().getName();
        String relPath = strPackage.replace(".", File.separator);
        return source + relPath + File.separator + name;
    }

    public static void main(String[] args) {
        String filename = getFileName("dataTaskA.bin");
        System.out.println(filename);
        String filetxt = getFileName("resultTaskA.txt");

        writeInt(filename);
        List<Integer> list = readListInteger(filename);
        printListInteger(list);
        saveListIntegerToTxt(filetxt, list);
    }

    private static void writeInt(String filename) {
        try (DataOutputStream dos = new DataOutputStream(
                new BufferedOutputStream(new FileOutputStream(filename)))
        ) {
            for (int i = 0; i < 20; i++) {
                int value = (int) (Math.random() * 101 - 50);
                dos.writeInt(value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Integer> readListInteger(String filename) {
        List<Integer> list = new ArrayList<>();
        try (DataInputStream dis = new DataInputStream(
                new BufferedInputStream(new FileInputStream(filename)))
        ) {
            while (dis.available() > 0) list.add(dis.readInt());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    private static void printListInteger(List<Integer> list) {
        double sum_1 = 0;
        for (Integer integer : list) {
            System.out.print(integer + " ");
            sum_1 += integer;
        }
        System.out.println("\navg=" + sum_1 / list.size());
    }

    private static void saveListIntegerToTxt(String filetxt, List<Integer> list) {
        try (PrintWriter out = new PrintWriter(new FileWriter(filetxt))) {
            double sum_2 = 0;
            for (Integer integer : list) {
                out.print(integer + " ");
                sum_2 += integer;
            }
            out.println("\navg=" + sum_2 / list.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}