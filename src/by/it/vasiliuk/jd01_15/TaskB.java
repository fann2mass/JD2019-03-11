package by.it.vasiliuk.jd01_15;

/*
 * В программе создайте хотя бы 5 разных комментариев:
 * 2 однострочных, 2 многострочных и 1 JavaDoc
 * Программа должна прочитать свой собственный текст в переменную типа StringBuilder.
 * Читая программу необходимо удалить все возможные виды комментариев, не трогая остальное.
 * Результат вывести на консоль и в файл с тем же местоположением и именем,
 * но с расширением txt,а не java.
 * Считайте, что комментарии внутри строки невозможны (s=“//так не бывает”)
 * Регулярные выражения использовать нельзя
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;


public class TaskB {
    private static StringBuilder sb = new StringBuilder();
    private static String getFileName(String fileName) {
        String source = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String strPackage = TaskB.class.getPackage().getName();
        String relPath = strPackage.replace(".", File.separator);
        return source + relPath + File.separator + fileName;
    }
    public static void main(String[] args) {

        String filename = getFileName("TaskB.java");//get filename for read
        readFile(filename);//read file and write it to the sb
        writeFile();
        showFile();
    }

    /**
     * Читает файл в переменную StringBuilder
     * @author Liza Khlystunova
     * @param filename имя файла для чтения
     * @version 2019-04-14
     *
     */
    private static void readFile(String filename) {
        try(BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String s;
            while((s = reader.readLine())!=null){
                StringBuilder sbLine  = new StringBuilder(s).append('\n');
                if(s.contains("/")&& check(s)) {
                    sbLine.delete(sbLine.indexOf("/"),sbLine.length()).append('\n');
                }
                String changeLine = sbLine.toString();
                if(changeLine.contains("*")&&check(s)){
                    continue;
                }
                sb.append(sbLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /*Метод возвращает true если строка не содержит con и ind*/
    private static boolean check(String s) {
        return !s.contains("contains") && !s.contains("indexOf");
    }

    private static void writeFile() {
        String fileNameForWrite = getFileName("TaskB.txt");
        try(BufferedWriter writer = new BufferedWriter(new PrintWriter(fileNameForWrite))) {
            writer.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /*
     * выводим содержимое файла TaskB.txt
     * в консоль
     */
    private static void showFile() {
        try (BufferedReader in=new BufferedReader(new FileReader(getFileName("TaskB.txt")))){
            String line;
            while ((line=in.readLine())!=null){
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}