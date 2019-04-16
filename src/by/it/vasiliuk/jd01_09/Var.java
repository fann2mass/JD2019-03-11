package by.it.vasiliuk.jd01_09;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public abstract class Var implements Operation {

    private static Map<String, Var> vars = new HashMap<>();

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
    }

    static Var createVar(String operand){
        if(operand.matches(Patterns.SCALAR))
            return new Scalar(operand);
        else if(operand.matches(Patterns.VECTOR))
            return new Vector(operand);
        else if(operand.matches(Patterns.MATRIX))
            return new Matrix(operand);
        return vars.get(operand);
    }

    static void sortVar() {
        Map<String, Var> sortArray = new TreeMap<>();
        for (Map.Entry<String, Var> stringVarEntry : vars.entrySet()) {
            String key = (String) ((Map.Entry) stringVarEntry).getKey();
            Var valueof = (Var) ((Map.Entry) stringVarEntry).getValue();
            sortArray.put(key, valueof);
        }
        Printer.printVar(sortArray);
    }
    @Override
    public String toString() {
        return "abstract Var";
    }

    @Override
    public Var add(Var other) {
        System.out.println("Сложение " + this + " + " + other + " невозможно!");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Вычитание " + this + " - " + other + " невозможно!");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Умножение " + this + " * " + other + " невозможно!");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Деление " + this + " / " + other + " невозможно!");
        return null;
    }
}
