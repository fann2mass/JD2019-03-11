package by.it.narushevich.calc;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

abstract class Var implements Operation {

    private static Map<String,Var> vars = new HashMap<>();

    static Map<String, Var> getVars() {
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

    @Override
    public Var add(Var other) {
        System.out.printf("Операция сложения %s+%s невозможна!\n",this,other);
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.printf("Операция вычитания %s+%s невозможна!\n",this,other);
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.printf("Операция умножения %s+%s невозможна!\n",this,other);
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.printf("Операция деления %s+%s невозможна!\n",this,other);
        return null;
    }

    @Override
    public String toString() {
        return "Это класс Var";
    }

}
