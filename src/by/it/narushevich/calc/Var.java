package by.it.narushevich.calc;

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

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException("Операция сложения %s+%s невозможна!\n",this,other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException("Операция вычитания %s-%s невозможна!\n",this,other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException("Операция умножения %s*%s невозможна!\n",this,other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException("Операция деления %s/%s невозможна!\n",this,other);
    }

    @Override
    public String toString() {
        return "Это класс Var";
    }

}
