package by.it.narushevich.jd01_15;

import java.io.*;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        String path = getPath();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             OutputStream outputStream = new FileOutputStream(reader.readLine())
        ) {

            Scanner scanner = new Scanner(System.in);
            String expr;
            for (; ; ) {
                expr = scanner.nextLine();
                if (expr.equals("end"))
                    break;
                if (expr.equals("cd..")) {
                    pathDirectory(path);
                }
                if (expr.contains("cd ")) {
                    parser(expr);
                }
                if (expr.equals("dir")) {
                    return;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void parser(String expression) {
        String folderName = expression.replace("cd ", "");

        System.out.println(folderName + File.separator);
    }

    private static void pathDirectory(String path) {
        File f = new File(path);
        String parent = f.getParent();
        System.out.print(parent + File.separator);
    }

    private static String getPath() {
        String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String replacePath = TaskC.class.getPackage().getName().replace(".", File.separator);
        System.out.print(src + replacePath + File.separator);
        return src + replacePath + File.separator;
    }

    private static String getPathToFile(String name) {
        String userDir = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String pathPack = TaskC.class.getPackage().getName().replace(".", File.separator);
        return userDir + pathPack + name;
    }
}
