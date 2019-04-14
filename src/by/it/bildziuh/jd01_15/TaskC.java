package by.it.bildziuh.jd01_15;

import java.io.File;
import java.util.Scanner;

public class TaskC {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;

        while (!(line = scanner.nextLine()).equals("end")) {
            if (line.contains("cd"))
                cd(path, line);
            if (line.contains("dir"))
                dir(path);
            if (!(line.contains("dir") || line.contains("cd")))
                System.out.println("Неверная команда!");
        }
    }

    private static String path = getPath(TaskC.class);

    private static String separator = File.separator;

    private static String getPath(Class<?> cl) {
        String path = System.getProperty("user.dir") + separator + "src" + separator;
        String classDir = cl.getName().replace(cl.getSimpleName(), "").replace(".", separator);
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
            newPath.delete(newPath.lastIndexOf(separator), newPath.length()).delete(newPath.lastIndexOf(separator) + 1, newPath.length());
            path = newPath.toString();
            return;
        }

        StringBuilder newFolder = new StringBuilder(command);
        newFolder.delete(0, 3);

        for (File currentFile : getFile(oldPath).listFiles()) {
            if (newFolder.toString().equals(currentFile.getName())) {
                newPath.append(currentFile.getName()).append(separator);
                path = newPath.toString();
                return;
            }
        }
        System.out.println("Неверно указан путь!");
    }

    private static File getFile(String path) {
        return new File(path);
    }

}