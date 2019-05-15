package by.it.khlystunova.jd02_06.calc02_06;

public class Scalar extends Var {
    private double value;

    public double getValue() {
        return value;
    }

    Scalar(double value){
        this.value = value;
    }

    //Scalar(Scalar scalar) {
     //   this.value = scalar.value;
  //  }

    Scalar(String value) {
        this.value = Double.parseDouble(value);
    }

    @Override
    //вызывается при выводе объекта в консоль
    public String toString() {
        return Double.toString(value);
    }


    @Override
    public Var add(Var other) throws CalcException {
        if(other instanceof Scalar)
            return new Scalar(this.value+((Scalar) other).value);
        else return other.add(this);
    }

    @Override
    //тот объект который вызвал этот метод ТОЧНО Scalar
    public Var sub(Var other) throws CalcException {
        if(other instanceof Scalar)
            return new Scalar(this.value -((Scalar) other).value);
        Scalar minus = new Scalar(-1);
        return other.sub(this).mul(minus);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if(other instanceof Scalar)
            return new Scalar(this.value *((Scalar) other).value);
        else return other.mul(this);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if(other instanceof Scalar) {
            if (((Scalar) other).value == 0) throw new CalcException(ResourceManager.INSTANCE.getString(Msg.MESSAGES_EXEPTION_DIV_BY_ZERO));
            return new Scalar(this.value / ((Scalar) other).value);
        }
        else  return super.div(other);//вызваем метод родителя, потому что число можно поделить только на число(на матрицу и вектор нельзя)
    }
}
