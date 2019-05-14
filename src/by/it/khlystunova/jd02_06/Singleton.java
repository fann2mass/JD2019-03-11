package by.it.khlystunova.jd02_06;

/*TaskA Необходимо создать логгер выводящий сообщения об ошибках и событиях
 в текстовый файл. Объект логгера должен быть создан с помощью шаблона проектирования
 Singleton. У объекта должен быть обязательным один метод, получающий на вход
 текст сообщения об ошибке и записывающий его в файл вместе с информацией о
 дате и времени происшествия. Файл имеет имя log.txt
 и располагается в том же каталоге, что и исходный код класса Singleton.*/

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Singleton {

    private static  volatile Singleton instance;
    private  static String fileName;

    private static String getFileName() {
        String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String strPackage = Singleton.class.getPackage().getName();
        String relPath = strPackage.replace(".", File.separator);
        return src + relPath + File.separator + "log.txt";
    }

    private Singleton() {
        fileName=getFileName();
    }

    public static Singleton getInstance(){
       if (instance==null){
           synchronized (Singleton.class){
               if(instance==null)//double cheek
               instance = new Singleton();
           }
       }
            return instance;

    }

     void log(String message) {
         try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileName,true))) {
             bw.append(new Date().toString());
             bw.append(" ");
             bw.append(message);
             bw.newLine();
             bw.flush();
         } catch (IOException e) {
             System.out.println("Какие-то проблемы у нас...");
             e.printStackTrace();
         }
    }
}
