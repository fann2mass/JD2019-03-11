package by.it.bolotko.jd01_15;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class TaskB {
    /**
     * @param cl   class
     * @param name create file Name
     * @return file
     */
    private static String createFile(Class<?> cl, String name) {
        String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String replacePath = cl.getPackage().getName().replace(".", File.separator);
        return src + replacePath + File.separator + name;
    }

    public static void main(String[] args) {
        String result = createFile(TaskB.class, "TaskB.txt");//путь к файлу, в котором будет лежать текст программы
        String from = createFile(TaskB.class, "TaskB.java");//путь к файлу, в котором лежит текст программы
        readChangeAndWrite(from, result);
        showFile(result);
    }

    private static void readChangeAndWrite(String from, String result) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(from));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(result))
        ) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                StringBuilder sb = new StringBuilder(line).append('\n');
                boolean containsSlash = line.contains("/");
                if (containsSlash && !exceptionCheck(line)) {
                    int indexOfSlash = sb.indexOf("/");
                    int length = sb.length();
                    sb.delete(indexOfSlash, length).append('\n');
                }
                String changeLine = sb.toString();
                boolean containsStar = changeLine.contains("*");
                if (containsStar && !exceptionCheck(line)) {
                    continue;
                }
                String changeLine2 = sb.toString();
                bufferedWriter.write(changeLine2);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean exceptionCheck(String line) {
        return line.contains("contains") || line.contains("indexOf");
    }

    private static void showFile(String result) {
        try (BufferedReader reader = new BufferedReader(new FileReader(result))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
