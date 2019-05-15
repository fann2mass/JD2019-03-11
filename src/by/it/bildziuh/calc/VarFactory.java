package by.it.bildziuh.calc;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class VarFactory {
    private static Map<String, Var> vars = new HashMap<>();

    static Map<String, Var> varList() {
        return vars;
    }

    static Var createVar(String operand) throws CalcException {
        operand = operand.trim().replace("\\s+", "");
        if (operand.matches(Patterns.SCALAR))
            return new Scalar(operand);
        else if (operand.matches(Patterns.VECTOR))
            return new Vector(operand);
        else if (operand.matches(Patterns.MATRIX))
            return new Matrix(operand);
        else if (vars.containsKey(operand))
            return vars.get(operand);
        else {
            Var var = vars.get(operand);
            if (var != null) {
                return var;
            }
            throw new CalcException(Localization.manager.getString(Msg.UNABLETOCREATE) + ": " + operand);
        }
    }

    static Map<String, Var> sortVarList() {
        Map<String, Var> sortedList = new TreeMap<>();
        for (Map.Entry<String, Var> stringVarEntry : vars.entrySet()) {
            String key = (String) ((Map.Entry) stringVarEntry).getKey();
            Var value = (Var) ((Map.Entry) stringVarEntry).getValue();
            sortedList.put(key, value);
        }
        return sortedList;

    }


    static Var saveVar(String name, Var var) {
        vars.put(name, var);
        return var;
    }

    static void save() {
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
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static String getFileName() {
        String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String strPackage = Var.class.getPackage().getName();
        String relPath = strPackage.replace(".", File.separator);
        return src + relPath + File.separator + "vars.txt";
    }

}
