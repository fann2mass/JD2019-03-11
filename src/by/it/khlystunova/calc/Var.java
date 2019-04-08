package by.it.khlystunova.calc;

import java.util.*;

public abstract class Var implements Operation {

    private static Map<String,Var> vars = new HashMap<>();

    public static Map getVar() {
        Map<String,Var> copy = new HashMap<>();
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

    static Var createVar(String operand) throws CalcException {
     if(operand.matches(Patterns.SCALAR))
        return new Scalar(operand);
     else if(operand.matches(Patterns.VECTOR))
         return new Vector(operand);
     else if(operand.matches(Patterns.MATRIX))
         return new Matrix(operand);

        Var var = vars.get(operand);
        if(var==null)
        throw  new CalcException();//возвращает объект с указанным ключом
        return  var;
    }

    static void sortVar() {
        Map<String,Var> sortArray = new TreeMap<>();
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
        throw new CalcException("Сложение " + this + " + " + other + " невозможно!");//this-в данном случае - это объект который вызывает метод.

    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException("Вычитание " + this + " - " + other + " невозможно!");

    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException("Умножение " + this + " * " + other + " невозможно!");

    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException("Деление " + this + " / " + other + " невозможно!");

    }
}
