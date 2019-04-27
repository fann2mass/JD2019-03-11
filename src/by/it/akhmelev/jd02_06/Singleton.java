package by.it.akhmelev.jd02_06;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

class Singleton {

    private static volatile Singleton instance;

    private static String getFileName(String name) {
        String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String strPackage = Singleton.class.getPackage().getName();
        String relPath = strPackage.replace(".", File.separator);
        return src + relPath + File.separator + name;
    }

    private String filename;


    private Singleton() {
        filename = getFileName("log.txt");
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

    void log(String message) {
        try (
                BufferedWriter out = new BufferedWriter(new FileWriter(filename, true))
        ) {
            out.append(new Date().toString());
            out.append(" ");
            out.append(message);
            out.newLine();
            out.flush();
        } catch (IOException e) {
            System.out.println("У нас проблемы...");
        }
    }


}
