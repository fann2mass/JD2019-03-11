package by.it.khlystunova.Calc;

import java.util.HashMap;
import java.util.Map;

public abstract class Var implements Operation {

    private static Map<String,Var> vars = new HashMap<>();

    static Var createVar(String operand){

     if(operand.matches(Patterns.SCALAR))
        return new Scalar(operand);
     else if(operand.matches(Patterns.VECTOR))
         return new Vector(operand);
     else if(operand.matches(Patterns.MATRIX))
         return new Matrix(operand);
      return vars.get(operand);
    }

    public static void saveVar(String name, Var var) {
        vars.put(name,var);
    }

    @Override
    public String toString() {
        return "abstract Var";
    }

    @Override
    public Var add(Var other) {
        System.out.println("Сложение " + this + " + " + other + " невозможно!");//this-в данном случае - это объект который вызывает метод.
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
