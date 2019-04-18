package by.it.khlystunova.jd01_14;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/*Вариант C.В классе TaskC нужно выполнить следующие шаги:
Вывести список всех файлов и каталогов вашего пакета by.it.фамилия в формате
 file:имя_файла или dir:имя_каталога.
Продублировать вывод в консоль в файл resultTaskC.txt*/
public class TaskC {
    private static StringBuilder sb =  new StringBuilder();

    private static String getFileName() {
        String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String strPackage = TaskC.class.getPackage().getName();
        String relPath = strPackage.replace(".", File.separator);
        return src + relPath + File.separator + "resultTaskC.txt";
    }
    public static void main(String[] args) {
        String[] listOfPackages = getNameOfPackages();
        ArrayList<String> arrayListOfFiles = new ArrayList<>();
         //выводим в консоль
        for (String s : listOfPackages) {
            System.out.println("dir:"+s);
            String[] nameOfFiles = getNameOfFiles(s);
            for (String name : nameOfFiles) {
              System.out.println("file:"+name);
              arrayListOfFiles.add(name);
            }
        }

        saveToFileTxt(listOfPackages,arrayListOfFiles);
    }

    private static String[] getNameOfPackages() {
        String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String strPackage = TaskC.class.getPackage().getName();
        String relPath = strPackage.replace(".", File.separator);
        String s = src + relPath;
        String[] split = s.split(File.separator+File.separator);
        for (int i = 0; i <split.length-1 ; i++) {
            sb.append(split[i]);
            sb.append(File.separator);
        }
        System.out.println(sb.toString());//C:\JD2019-03-11\src\by\it\khlystunova\
        File file = new File(sb.toString());//sb = "C:\\JD2019-03-11\\src\\by\\it\\khlystunova"
        return file.list();
    }

    private static String[] getNameOfFiles(String nameOfPackage) {
        //"C:\\JD2019-03-11\\src\\by\\it\\khlystunova\\"
        File file = new File(sb+nameOfPackage);
        return file.list();
    }

    private static void saveToFileTxt(String[] list, ArrayList<String> arrayList) {
        String fileName = getFileName();
        try( PrintWriter printWriter = new PrintWriter(new FileWriter(fileName))) {
            for (String s : list) {
                printWriter.write("dir:"+s);
                printWriter.write("\n");
            }
            for (String s : arrayList) {
                printWriter.write("file:"+s);
                printWriter.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
