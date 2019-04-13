package by.it.bildziuh.jd01_14;

import java.io.*;

public class TaskC {
    private static int counter = 1;

    public static void main(String[] args) {
        String path = getPath(TaskC.class);
        File f = new File(path);

        try (PrintWriter printWriter = new PrintWriter(new FileWriter(path + File.separator + "resultTaskC.txt"))) {
            CheckFolder(f.getParent(), printWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void CheckFolder(String dirPath, PrintWriter printWriter) {
        String offSet = String.format("%" + counter + "s", " ");

        File file = new File(dirPath);
        File[] allFiles = file.listFiles();

        System.out.println(offSet + "dir:" + file.getName());
        printWriter.println(offSet + "dir:" + file.getName());
        counter++;
        for (File currentFile : allFiles) {
            if (currentFile.isDirectory()) {
                CheckFolder(currentFile.getPath(), printWriter); // вот она, родная — рекурсия!
            } else {
                printWriter.println(offSet + "file:" + currentFile.getName());
                System.out.println(offSet + "file:" + currentFile.getName());
            }
        }
        counter--;
    }

    private static String getPath(Class<?> cl) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String classDir = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        return path + classDir;
    }
}