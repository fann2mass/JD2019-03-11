package by.it.narushevich.calc;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

class Logger {

    private static volatile Logger instance;

    private final String logFile;

    public Logger() {
        logFile = createFile(Logger.class, "log.txt");
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

    private static final int CAPACITY = 50;
    private static LinkedHashMap<String, String> hashMap =
            new LinkedHashMap<String, String>(CAPACITY, 1.0f, true) {
                @Override
                protected boolean
                removeEldestEntry(Map.Entry<String, String> eldest) {
                    return this.size() > CAPACITY || super.removeEldestEntry(eldest);
                }
            };

    public void fillReport(String s) {
        hashMap.put(data(), s);
        saveLog();
    }

    private void saveLog() {
        try (PrintWriter out = new PrintWriter(new FileWriter(logFile))) {
            for (Map.Entry<String, String> pair : hashMap.entrySet()) {
                out.println(pair.getKey() + " : " + pair.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void loadLog() {
        try (BufferedReader in = new BufferedReader(new FileReader(logFile))) {
            String line;
            while ((line = in.readLine()) != null) {
                String[] splittedLine = line.split("\\s:\\s");
                for (int i = 0; i < 2; i++) {
                    String data = splittedLine[0];
                    String log = splittedLine[1];
                    hashMap.put(data, log);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String createFile(Class<?> cl, String name) {
        String userDir = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String pathPack = cl.getPackage().getName().replace(".", File.separator) + File.separator;
        return userDir + pathPack + name;
    }

    private static String data() {
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
        return formatForDateNow.format(dateNow);
    }
}

