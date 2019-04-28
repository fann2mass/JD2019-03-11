package by.it.eslaikouskaya.calc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

class Printer {

    private static String getFileName() {
        String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String strPackage = Singleton.class.getPackage().getName();
        String relPath = strPackage.replace(".", File.separator);
        return src + relPath + File.separator + "operationsAndResults.txt";
    }

    public void print(Var result) {
        if (result != null) {
            System.out.println(result);
            try (BufferedWriter out = new BufferedWriter(new FileWriter(getFileName(),
                    true))) {
                out.append("result: ").append(result.toString());
                out.newLine();
                out.flush();
            } catch (IOException e) {
                Singleton logger = Singleton.getInstance();
                logger.log("У нас проблемы...");
                System.out.println("У нас проблемы...");
            }
        }
    }

    void println(Map<String, Var> vars) {
        Set<Map.Entry<String, Var>> entries = vars.entrySet();
        for (Map.Entry<String, Var> entry : entries) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }


    void sortPrint(Map<String, Var> vars) {
        Set<Map.Entry<String, Var>> entries = vars.entrySet();
        TreeSet<String> elements = new TreeSet<>();
        for (Map.Entry<String, Var> entry : entries) {
            String element = entry.getKey() + " = " + entry.getValue();
            elements.add(element);
        }
        for (String element : elements) {
            System.out.println(element);
        }
    }

}
