package by.it.bolotko.jd02_06.calc;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class VarFactory {
    private static Map<String, Var> vars = new HashMap<>();
    static Map<String, Var> getVars() {
        return vars;
    }

    private static String getFileName() {
        String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String strPackage = Var.class.getPackage().getName();
        String relPath = strPackage.replace(".", File.separator);
        return src + relPath + File.separator + "vars.txt";
    }

    static void saveVar(String name, Var var) {
        vars.put(name, var);
        save();
    }

    private static void save() {
        try (PrintWriter out = new PrintWriter(new FileWriter(getFileName()))) {
            for (Map.Entry<String, Var> pair : vars.entrySet()) {
                out.println(pair.getKey() + "=" + pair.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void load() throws CalcException {
        Parser p = new Parser();
        File file = new File(getFileName());
        if (file.exists()) {
            try (BufferedReader in = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = in.readLine()) != null) {
                    p.calc(line);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static Var createVar(String operand) {
        operand = operand.trim();
        if (operand.matches(Patterns.SCALAR))
            return new Scalar(operand);
        if (operand.matches(Patterns.VECTOR))
            return new Vector(operand);
        if (operand.matches(Patterns.MATRIX))
            return new Matrix(operand);
        if (vars.containsKey(operand))
            return vars.get(operand);
        return null;
    }
}

