package by.it.bildziuh.jd01_14;

import java.io.*;

public class TaskC {

    public static void main(String[] args) {
        String path = getPath(TaskC.class);
        String outTxt = path + File.separator + "resultTaskC.txt";
        File f = new File(path);

        CheckFolder(f.getParent(), outTxt);
    }

    private static void CheckFolder(String dirPath, String outTxt) {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(outTxt))) {

            File file = new File(dirPath);
            File[] allFiles = file.listFiles();

            System.out.println("dir:" + file.getName());
            printWriter.println("dir:" + file.getName());

            for (File currentFile : allFiles) {
                if (currentFile.isDirectory()) {
                    CheckFolder(currentFile.getAbsolutePath(), outTxt);
                } else {
                    printWriter.println("\tfile:" + currentFile.getName());
                    System.out.println("\tfile:" + currentFile.getName());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getPath(Class<?> cl) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String classDir = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        return path + classDir;

    }
}