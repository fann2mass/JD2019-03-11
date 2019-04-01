package by.it.khlystunova.thinkAboutIndexOf;

public abstract class Var implements Operation,ScalarOperation,VectorOperation,MatrixOperation {

    static Var createVar(String operand){

     if(operand.matches(Patterns.SCALAR))
        return new Scalar(operand);
     else if(operand.matches(Patterns.VECTOR))
         return new Vector(operand);
     else if(operand.matches(Patterns.MATRIX))
         return new Matrix(operand);

     else return null;
    }

    @Override
    public String toString() {
        return "abstract Var";
    }


    @Override
    public Var add(Vector other) {
        System.out.println("Сложение " + this + " + " + other + " невозможно!");//this-в данном случае - это объект который вызывает метод.
        return null;
    }

    @Override
    public Var add(Scalar other) {
        System.out.println("Сложение " + this + " + " + other + " невозможно!");//this-в данном случае - это объект который вызывает метод.
        return null;
    }

    @Override
    public Var add(Matrix other) {
        System.out.println("Сложение " + this + " + " + other + " невозможно!");//this-в данном случае - это объект который вызывает метод.
        return null;
    }

    @Override
    public Var add(Var other) {
        System.out.println("Сложение " + this + " + " + other + " невозможно!");//this-в данном случае - это объект который вызывает метод.
        return null;
    }



    @Override
    public Var sub(Matrix other) {
        System.out.println("Вычитание " + this + " - " + other + " невозможно!");
        return null;
    }

    @Override
    public Var sub(Vector other) {
        System.out.println("Вычитание " + this + " - " + other + " невозможно!");
        return null;
    }

    @Override
    public Var sub(Scalar other) {
        System.out.println("Вычитание " + this + " - " + other + " невозможно!");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Вычитание " + this + " - " + other + " невозможно!");
        return null;
    }

    @Override
    public Var mul(Vector other) {
        System.out.println("Умножение " + this + " * " + other + " невозможно!");
        return null;
    }

    @Override
    public Var mul(Matrix other) {
        System.out.println("Умножение " + this + " * " + other + " невозможно!");
        return null;
    }

    @Override
    public Var mul(Scalar other) {
        System.out.println("Умножение " + this + " * " + other + " невозможно!");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Умножение " + this + " * " + other + " невозможно!");
        return null;
    }

    @Override
    public Var div(Scalar other) {
        System.out.println("Деление " + this + " / " + other + " невозможно!");
        return null;
    }
    @Override
    public Var div(Vector other) {
        System.out.println("Деление " + this + " / " + other + " невозможно!");
        return null;
    }
    @Override
    public Var div(Matrix other) {
        System.out.println("Деление " + this + " / " + other + " невозможно!");
        return null;
    }


    @Override
    public Var div(Var other) {
        System.out.println("Деление " + this + " / " + other + " невозможно!");
        return null;
    }
}
