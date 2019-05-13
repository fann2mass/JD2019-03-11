package by.it.bildziuh.calc;

import java.io.*;
import java.util.Date;

class Logger {

    private String logError = Localization.manager.getString(Msg.LOG);

    private static volatile Logger instance;

    private static StringBuilder sb = new StringBuilder();

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

    void loadLog(){
        File file = new File(getFileName(filename));

        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                    sb.append('\n');
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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
            Logger logger = Logger.getInstance();
            logger.log(logError);
            System.out.println(logError);
        }
    }

}
