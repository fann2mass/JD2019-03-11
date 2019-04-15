package by.it.bolotko.jd01_15;


import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * JavaDoc
 */
public class TaskB {
    private static String getFileName(String name) { /*getFileName*/
        String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String strPackage = TaskB.class.getPackage().getName();
        String relPath = strPackage.replace(".", File.separator);
        return src + relPath + File.separator + name;
    }

    /*
   * Пример многострочного комментария
     */

    public static void main(String[] args) {     /*main*/
        String fileName=getFileName("TaskB.java");
        StringBuilder sb = readTaskB(fileName);
        String resultFileName = getFileName("resultTaskB.txt");
        saveLineToTheFileTxt(sb, resultFileName);

    }

    private static StringBuilder readTaskB(String fileName) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            while(reader.ready()){
                String s = reader.readLine();
                Pattern pat=Pattern.compile("/\\*([^*]|[\\r\\n]|(\\*+([^*/]|[\\r\\n])))*\\*+/"); // регулярное выражение поиска комментариев
                Matcher match=pat.matcher(s); // получаем объект соответствий к строке s
                String result=match.replaceAll(""); // заменяем все соответствия пустой строкой
                System.out.println(result);
                result=sb.toString();
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb;
    }

    private static void saveLineToTheFileTxt(StringBuilder sb, String resultFileName) {
        try (PrintWriter printWriter = new PrintWriter((new FileWriter(resultFileName)))){
            printWriter.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
