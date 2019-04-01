package by.it.khlystunova.thinkAboutIndexOf;

public class Scalar extends Var {
    private double value;

    public double getValue() {
        return value;
    }

    Scalar(double value){
        this.value = value;
    }

    Scalar(Scalar scalar) {
        this.value = scalar.value;
    }

    Scalar(String value) {
        this.value = Double.parseDouble(value);
    }

    @Override
    //вызывается при выводе объекта в консоль
    public String toString() {
        return Double.toString(value);
    }

    @Override
    public Var add(Scalar other) {
        return new Scalar(this.value+other.value);
    }

    @Override
    public Var add(Var other) {
        return other.add(this);
    }

    @Override
    public Var sub(Scalar other) {
        return new Scalar(this.value -other.value);
    }

    @Override
    //тот объект который вызвал этот метод ТОЧНО Scalar
    public Var sub(Var other) {
        Scalar minus = new Scalar(-1);
        return other.sub(this).mul(minus);
    }

    @Override
    public Var mul(Scalar other) {
        return new Scalar(this.value *other.value);
    }

    @Override
    public Var mul(Var other) {
      return other.mul(this);
    }

    @Override
    public Var div(Scalar other) {
        return new Scalar(this.value / other.value);
    }

    @Override
    public Var div(Matrix other) {
        return super.div(other);
    }

    @Override
    public Var div(Var other) {
        System.out.println("this is i am ");
        return super.div(other);//вызваем метод родителя, потому что число можно поделить только на число(на матрицу и вектор нельзя)
    }
}
