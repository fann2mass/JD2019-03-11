package by.it.khlystunova.jd02_05.calc02_05;


import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public abstract class Var implements Operation {

    private static Map<String, Var> vars = new HashMap<>();
    private static StringBuilder sb = new StringBuilder();


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
    @Override
    public String toString() {
        return "abstract Var";
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException(ResourceManager.INSTANCE.getString(Msg.MESSAGES_ADD)+
                " "+ this + " + " + other +" "+ResourceManager.INSTANCE.getString(Msg.MESSAGES_IMPOSSSIBLE));//this-в данном случае - это объект который вызывает метод.

    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException(ResourceManager.INSTANCE.getString(Msg.MESSAGES_SUB)
                +" " + this + " - " + other +" "+ ResourceManager.INSTANCE.getString(Msg.MESSAGES_IMPOSSSIBLE));

    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException(ResourceManager.INSTANCE.getString(Msg.MESSAGES_MUL)+
                " " + this + " * " + other + " "+ ResourceManager.INSTANCE.getString(Msg.MESSAGES_IMPOSSSIBLE));

    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(ResourceManager.INSTANCE.getString(Msg.MESSAGES_DIV) +
                " "+ this + " / " + other +" "+ResourceManager.INSTANCE.getString(Msg.MESSAGES_IMPOSSSIBLE));

    }

    private static void save() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(getFileName("vars.txt")))) {
            for (Map.Entry<String, Var> pair : vars.entrySet()) {
                writer.println(pair.getKey() + "=" + pair.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static void load() throws CalcException {
        Parser p = new Parser();
        File file = new File(getFileName("vars.txt"));
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

     static void saveLogs(String error) {
        sb.append(error);
        sb.append('\n');
        try (PrintWriter writer = new PrintWriter(new FileWriter(getFileName("log.txt")))) {
            trimToNeedSize();
            writer.write(sb.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void trimToNeedSize() {
        String[] split = sb.toString().split("\n");
        int length = split.length;
        if(length>50){
          sb.delete(0,'\n');
        }
    }

    static void loadLogs(){
        File file = new File(getFileName("log.txt"));
        if (file.exists()) {
            try (BufferedReader in = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = in.readLine()) != null) {
                  sb.append(line);
                  sb.append('\n');
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    private static String getFileName(String fileName) {
        String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String strPackage = Var.class.getPackage().getName();
        String relPath = strPackage.replace(".", File.separator);
        return src + relPath + File.separator + fileName;
    }
}
