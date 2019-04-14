package by.it.bildziuh.jd01_15;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TaskC {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;
        String path = getPath(TaskC.class);

        while (!(line = scanner.nextLine()).equals("end")) {
            if (line.contains("cd")) {
                path = cd(path, line);
            }
            if (line.contains("dir")) {
                dir(path);
            }
            if (!(line.contains("cd") || line.contains("dir")))
                System.out.println("Неверная команда!");
        }
    }

    private static void dir(String dirPath) {

        System.out.println("dir: " + getFile(dirPath).getName());

        for (File currentFile : getFile(dirPath).listFiles()) {
            System.out.println("\tfile: " + currentFile.getName());
        }
    }

    private static String getPath(Class<?> cl) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String classDir = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        return path + classDir;
    }

    private static String cd(String oldPath, String command) {
        StringBuilder newFolder = new StringBuilder(command);
        newFolder.delete(0, 3);

        StringBuilder newPath = new StringBuilder(oldPath);

        if (command.contains("..")) {
            newPath.delete(newPath.lastIndexOf("\\"), newPath.length()).delete(newPath.lastIndexOf("\\") + 1, newPath.length());
            return newPath.toString();
        }

        for (File currentFile : getFile(oldPath).listFiles()) {
            if (newFolder.toString().equals(currentFile.getName())) {
                newPath.append(currentFile.getName()).append(File.separator);
                return newPath.toString();
            }
        }

        System.out.println("Неверно указан путь!");
        return newPath.toString();
    }

    private static File getFile(String path) {
        return new File(path);
    }
}