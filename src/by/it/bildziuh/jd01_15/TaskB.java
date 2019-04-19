package by.it.bildziuh.jd01_15;

import java.io.*;

public class TaskB {
    /**
     * @param cl
     */
    private static String getPath(Class<?> cl, String name) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String classDir = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        return path + classDir + File.separator + name;
    }

    //однострочный коммент номер один
    public static void main(String[] args) {
        String inpTxt = getPath(TaskB.class, "TaskB.java");/* двустрочный коммент 123
         */
        String outTxt = getPath(TaskB.class, "TaskB.txt");
        process(inpTxt, outTxt);
    }

    //однострочный коммент номер два\
    private static void process(String input, String output) {
        try (BufferedReader reader = new BufferedReader(new FileReader(input));/* пиу-пиу
        */
             PrintWriter writer = new PrintWriter(new FileWriter(output))//фыв
        ) {
            StringBuilder result = new StringBuilder();
            StringBuilder temp = new StringBuilder();
            boolean write = true;

            while (reader.ready()) {
                String line = reader.readLine();
/*                int index = line.indexOf("/");
                boolean contains = line.contains("//");*/

                if (line.contains("//") && !line.contains("contains")) {
                    result.append(line).append("\n");
                    if (!(result.toString().contains("contains"))) {
                        result.delete(result.indexOf("//"), result.length()).append("\n");
                    }
                    continue;
                }
                if (line.contains("/*") && !line.contains("contains")) {
                    temp.append(line).append("\n");
                    if (!(temp.toString().contains("contains"))) {
                        temp.delete(temp.indexOf("/*"), temp.length()).append("\n");
                        result.append(temp);
                    }
                    write = false;
                }

                if (write)
                    result.append(line).append("\n");
                if (line.contains("*/"))
                    write = true;
                temp.delete(0,temp.length());
            }
            writer.println(result);
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}