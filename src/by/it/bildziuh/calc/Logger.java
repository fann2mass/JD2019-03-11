package by.it.bildziuh.calc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

class Logger {

    private static volatile Logger instance;

    private static String getFileName(String name) {
        String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String strPackage = Logger.class.getPackage().getName();
        String relPath = strPackage.replace(".", File.separator);
        return src + relPath + File.separator + name;
    }

    private String filename;

    private Logger() {
        filename = getFileName("log.txt");
    }

    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
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
