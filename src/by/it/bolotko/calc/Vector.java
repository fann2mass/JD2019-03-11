package by.it.bolotko.calc;

import java.util.Arrays;

class Vector extends Var {

    private double[] value;

    public double[] getValue() {
        return value;
    }
    Vector(double[] value){ this.value= Arrays.copyOf(value,value.length); }

    @Override
    public Var add(Var other) throws CalcException{
        Vector result = new Vector(value);
        if (other instanceof Scalar) {
            for (int i = 0; i < result.value.length; i++) {
                result.value[i] = result.value[i] + ((Scalar) other).getValue();
            }
            return result;
        }
        if (other instanceof Vector) {
            if (!(result.value.length ==((Vector) other).value.length)) return super.add(other);
            for (int i = 0; i < result.value.length; i++) {
                result.value[i] = result.value[i] + ((Vector) other).value[i];
            }
            return result;
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcException{
        Vector result = new Vector(value);
        if (other instanceof Scalar) {
            for (int i = 0; i < result.value.length; i++) {
                result.value[i] = result.value[i] - ((Scalar) other).getValue();
            }
            return result;
        }
        if (other instanceof Vector) {
            if (!(result.value.length ==((Vector) other).value.length)) return super.sub(other);
            for (int i = 0; i < result.value.length; i++) {
                result.value[i] = result.value[i] - ((Vector) other).value[i];
            }
            return result;
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcException{
        Vector result = new Vector(value);
        if (other instanceof Scalar) {
            for (int i = 0; i < result.value.length; i++) {
                result.value[i] = result.value[i] * ((Scalar) other).getValue();
            }
            return result;
        }
        if (other instanceof Vector) {
            double sum = 0;
            for (int i = 0; i < result.value.length; i++) {
                result.value[i] = result.value[i] * ((Vector) other).value[i];
                sum=sum+result.value[i];
            }
            return new Scalar(sum);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) throws CalcException{
        Vector result = new Vector(value);
        if (other instanceof Scalar) {
            if (((Scalar) other).value==0)
                throw new CalcException("Деление на ноль");
            for (int i = 0; i < result.value.length; i++) {
                result.value[i] = result.value[i] / ((Scalar) other).getValue();
            }
            return result;
        }
        if (other instanceof Vector) return super.div(other);

        return super.div(other);
    }


    Vector(String str) {
        StringBuilder sb=new StringBuilder(str);
        sb.deleteCharAt(0).deleteCharAt(sb.length()-1);
        String result=sb.toString();
        String[] strArr = result.split("[^\\d.]+");
        double[] value = new double[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            value[i] = Double.parseDouble(strArr[i]);
        }
        this.value=value;
    }

    Vector(Vector vector){this.value=vector.value;}


    @Override
    public String toString() {
        StringBuilder res=new StringBuilder("{");
        String delimiter="";
        for (double element : value) {
            res.append(delimiter).append(element);
            delimiter = ", ";
        }
        res.append("}");
        return res.toString();
    }
}
