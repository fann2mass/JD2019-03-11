package by.it.bildziuh.jd01_15;

import java.io.File;
import java.util.Scanner;

public class TaskC {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;

        while (!(line = scanner.nextLine()).equals("end")) {
            if (line.contains("cd")) {
                cd(path, line);
            } else if (line.contains("dir")) {
                dir(path);
            } else
                System.out.println("Неверная команда!");
        }
    }

    private static String path = getPath(TaskC.class);

    private static String getPath(Class<?> cl) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String classDir = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        return path + classDir;
    }

    private static void dir(String dirPath) {

        System.out.println("dir: " + getFile(dirPath).getName());

        for (File currentFile : getFile(dirPath).listFiles()) {
            System.out.println("\tfile: " + currentFile.getName());
        }
    }

    private static void cd(String oldPath, String command) {

        StringBuilder newPath = new StringBuilder(oldPath);

        if (command.contains("..")) {
            newPath.delete(newPath.lastIndexOf("\\"), newPath.length()).delete(newPath.lastIndexOf("\\") + 1, newPath.length());
            path = newPath.toString();
        }

        StringBuilder newFolder = new StringBuilder(command);
        newFolder.delete(0, 3);

        for (File currentFile : getFile(oldPath).listFiles()) {
            if (newFolder.toString().equals(currentFile.getName())) {
                newPath.append(currentFile.getName()).append(File.separator);
                path = newPath.toString();
            }
        }
        System.out.println("Неверно указан путь!");
    }

    private static File getFile(String path) {
        return new File(path);
    }
}