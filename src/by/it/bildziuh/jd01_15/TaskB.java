package by.it.bildziuh.jd01_15;

import java.io.*;

public class TaskB {
    /**
     * @param cl
     * @param name
     * @return
     */
    private static String getPath(Class<?> cl, String name) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String classDir = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        return path + classDir + File.separator + name;
    }
    //однострочный коммент номер один
    public static void main(String[] args) {
        String inpTxt = getPath(TaskB.class, "TaskB.java");
        String outTxt = getPath(TaskB.class, "TaskB.txt");
        process(inpTxt, outTxt);
    }
    //однострочный коммент номер два\
    /*
    многострочный комментарий
     */
    private static void process(String input, String output) {
        try (BufferedReader reader = new BufferedReader(new FileReader(input));
             PrintWriter writer = new PrintWriter(new FileWriter(output))
        ) {
            StringBuilder result = new StringBuilder();
            boolean write = true;
            while (reader.ready()) {
                String line = reader.readLine();
                String emptyLine = new String();

                if (line.contains("//") && !line.contains("line.contains"))
                    line = emptyLine;
                if (line.contains("/*") && !line.contains("line.contains"))
                    write = false;
                if (line.contains("/**") && !line.contains("line.contains"))
                    write = false;
                if (write)
                    result.append(line).append("\n");
                if (line.endsWith("*/"))
                    write = true;
            }
            /*
            Двустрочный коммент номер один
             */
            writer.println(result);
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*Двустрочный коммент номер два
     */
}