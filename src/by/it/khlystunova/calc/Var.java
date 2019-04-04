package by.it.khlystunova.calc;

import java.util.*;

public abstract class Var implements Operation {

    private static Map<String,Var> vars = new TreeMap<>();

    static Var createVar(String operand){
     if(operand.matches(Patterns.SCALAR))
        return new Scalar(operand);
     else if(operand.matches(Patterns.VECTOR))
         return new Vector(operand);
     else if(operand.matches(Patterns.MATRIX))
         return new Matrix(operand);
        return vars.get(operand);//возвращает объект с указанным ключом
    }

    public static void saveVar(String operand, Var two) {
        vars.put(operand,two);
    }

    public static void printVar(){
        System.out.println(vars);
    }

    public static void sortVar() {
        System.out.println(vars);

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
