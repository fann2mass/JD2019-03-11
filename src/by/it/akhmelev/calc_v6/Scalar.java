package by.it.akhmelev.calc_v6;

class Scalar extends Var {

    private double value;

    public double getValue() {
        return value;
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar)
            return new Scalar(this.value + ((Scalar) other).value);
        return other.add(this);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar)
            return new Scalar(this.value - ((Scalar) other).value);
        Scalar minus=new Scalar(-1);
        return other.sub(this).mul(minus);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar)
            return new Scalar(this.value * ((Scalar) other).value);
        return other.mul(this);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar){
            double z = ((Scalar) other).value;
            if (z==0)
                throw new CalcException("Деление на ноль");
            return new Scalar(this.value / z);
        }
        return super.div(other);
    }

    Scalar(double value) {
        this.value = value;
    }

    Scalar(String strValue) {
        this.value = Double.parseDouble(strValue);
    }

    Scalar(Scalar otherScalar) {
        this.value = otherScalar.value;
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
