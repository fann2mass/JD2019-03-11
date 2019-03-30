package by.it.narushevich.jd01_09;

public class Scalar extends Var {

    private double value;

    public double getValue() {
        return value;
    }

    @Override
    public Var add(Var other) {
        if (other.toString().matches(Patterns.SCALAR))
            return new Scalar(this.value + ((Scalar) other).value);
        return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if (other.toString().matches(Patterns.SCALAR))
            return new Scalar(this.value - ((Scalar) other).value);
        Scalar minus=new Scalar(-1);
        return other.sub(this).mul(minus);
    }

    @Override
    public Var mul(Var other) {
        if (other.toString().matches(Patterns.SCALAR))
            return new Scalar(this.value * ((Scalar) other).value);
        return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        if (other.toString().matches(Patterns.SCALAR))
            return new Scalar(this.value / ((Scalar) other).value);
        return other.div(this);
    }

    Scalar(double value) {
        this.value = value;
    }

    Scalar(Scalar scalar) {
        this.value = scalar.value;
    }

    Scalar(String strScalar) {
        this.value = Double.parseDouble(strScalar);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
