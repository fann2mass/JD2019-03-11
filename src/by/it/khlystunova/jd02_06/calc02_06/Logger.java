package by.it.khlystunova.jd02_06.calc02_06;

import java.io.*;
import java.util.Date;
/*
* класс для создания,загрузки и сохранения единственного экземпляра файла с ошибками
* */
class Logger {

    private static  volatile Logger instance;
    private static StringBuilder sb = new StringBuilder();


    private Logger() {
    }

    private static String getFileName() {
        String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String strPackage = Logger.class.getPackage().getName();
        String relPath = strPackage.replace(".", File.separator);
        return src + relPath + File.separator + "log.txt";
    }


     static Logger getInstance(){
        if (instance==null){
            synchronized (Logger.class){
                if(instance==null)//double cheek
                    instance = new Logger();
            }
        }
        return instance;

    }

        void loadLogs(){
        File file = new File(getFileName());
        if (file.exists()) {
            try (BufferedReader in = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = in.readLine()) != null) {
                    sb.append(line);
                    sb.append('\n');
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private  void trimToNeedSize() {
        String[] split = sb.toString().split("\n");
        int length = split.length;
        if(length>50){
            sb.delete(0,'\n');
        }
    }

     void saveLogs(String error) {
        sb.append(error);
        sb.append(' ');
        sb.append(new Date());
        sb.append('\n');
        try (PrintWriter writer = new PrintWriter(new FileWriter(getFileName()))) {
            trimToNeedSize();
            writer.write(sb.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
