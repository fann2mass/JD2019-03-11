package by.it.khlystunova.jd02_06.calc02_06;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class VarFactory {

    private static Map<String, Var> vars = new HashMap<>();

    private static String getFileName() {
        String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String strPackage = Var.class.getPackage().getName();
        String relPath = strPackage.replace(".", File.separator);
        return src + relPath + File.separator + "vars.txt";
    }

    public static Map getVar() {
        Map<String, Var> copy = new HashMap<>();
        for (Map.Entry<String, Var> stringVarEntry : vars.entrySet()) {
            String key = (String) ((Map.Entry) stringVarEntry).getKey();
            Var value = (Var) ((Map.Entry) stringVarEntry).getValue();
            copy.put(key, value);
        }
        return copy;
    }

    static void saveVar(String operand, Var two) {
        vars.put(operand,two);
        save();
    }

    private static void save() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(getFileName()))) {
            for (Map.Entry<String, Var> pair : vars.entrySet()) {
                writer.println(pair.getKey() + "=" + pair.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static Var createVar(String operand) throws CalcException {

        if(operand.matches(Patterns.SCALAR))
            return new Scalar(operand);
        else if(operand.matches(Patterns.VECTOR))
            return new Vector(operand);
        else if(operand.matches(Patterns.MATRIX))
            return new Matrix(operand);
        else{
            Var var = vars.get(operand);
            if(var!=null) {
                return var;
            }else throw  new CalcException(ResourceManager.INSTANCE.getString(Msg.EXEPTION_NO_SUCH_VARIABLE)+" "+operand);
        }
    }

    static void sortVar() {
        Map<String, Var> sortArray = new TreeMap<>();
        for (Map.Entry<String, Var> stringVarEntry : vars.entrySet()) {
            String key = (String) ((Map.Entry) stringVarEntry).getKey();
            Var value = (Var) ((Map.Entry) stringVarEntry).getValue();
            sortArray.put(key, value);
        }
        Printer.printVar(sortArray);
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

}
