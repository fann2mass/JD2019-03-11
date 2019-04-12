package by.it.narushevich.calc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {

    private static Map<String,Var> vars = new HashMap<>();

    public static Map<String, Var> getVars() {
        return vars;
    }

    static void saveVar(String name, Var var){
        vars.put(name, var);
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

    static void save() {
        try {
        for (Map.Entry<String, Var> pair : vars.entrySet()) {
            System.out.println(pair.getKey() +" = "+ pair.getValue());
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String createFile() {
        String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String replacePath = Var.class.getPackage().getName().replace(".", File.separator);
        return src + replacePath + File.separator + "vars.txt";
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException();
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException();
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException();
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException();
    }

    @Override
    public String toString() {
        return "Это класс Var";
    }

}
