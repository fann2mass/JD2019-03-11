package by.it.narushevich.calc;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class Logger {
    private static final int capacity = 50;
    String logFile = createFile(Logger.class, "log.txt");
    private static LinkedHashMap<String, String> hashMap = new LinkedHashMap<String, String>(capacity, 1.0f, true) {
        @Override
        protected boolean
        removeEldestEntry(Map.Entry<String, String> eldest) {
            return this.size() > capacity || super.removeEldestEntry(eldest);
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

    static void loadLog() {
        File file = new File(createFile(Logger.class, "log.txt"));
        if (file.exists()) {
            try (BufferedReader in = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = in.readLine()) != null) {
                    String[] splitedLine = line.split("\\s:\\s");
                    for (int i = 0; i < 2; i++) {
                        String data = splitedLine[0];
                        String log = splitedLine[1];
                        hashMap.put(data, log);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static String createFile(Class<?> cl, String name) {
        String userDir = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String pathPack = cl.getPackage().getName().replace(".", File.separator) + File.separator;
        ;
        return userDir + pathPack + name;
    }

    private static String data() {
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
        return formatForDateNow.format(dateNow);
    }
}

