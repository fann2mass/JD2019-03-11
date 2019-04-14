package by.it.narushevich.jd01_14;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TaskC {

    public static void main(String[] args) {
        String path = getPath(TaskC.class);
        String fileResultToTxt = getPathFile("resultTaskC.txt");

        try (PrintWriter printWriter = new PrintWriter(new FileWriter(fileResultToTxt)))
        {
            File f = new File(path);
            String parent = f.getParent();
            System.out.println("dir:" + parent);
            printWriter.println("dir:" + parent);

            File f2 = new File(parent);
            File[] directories = f2.listFiles();

            for (File directory : directories) {
                String name = directory.getName();
                System.out.println("    dir:" + name);
                printWriter.println("    dir:" + name);
                String[] list = directory.list();
                for (String file : list) {
                    System.out.println("        file:" + file);
                    printWriter.println("        file:" + file);
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getPathFile(String name) {
        return getPath(TaskC.class) + File.separator + name;
    }

    private static String getPath(Class<?> cl) {
        String userDir = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String pathPack = cl.getPackage().getName().replace(".", File.separator);
        return userDir + pathPack;
    }
}

