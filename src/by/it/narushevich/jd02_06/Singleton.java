package by.it.narushevich.jd02_06;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Singleton {

    private static volatile Singleton instance;

    private static String getPath(String name) {
        String userDir = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String pathPack = Singleton.class.getPackage().getName().replace(".", File.separator);
        return userDir + pathPack + File.separator + name;
    }

    private String filename;

    private Singleton() {
        filename = getPath("log.txt");
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    void log(String message){
        try (
             BufferedWriter out = new BufferedWriter(new FileWriter(filename, true))
        ) {
            out.append(new Date().toString()).append('\t');
            out.append(message).append('\n');
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
