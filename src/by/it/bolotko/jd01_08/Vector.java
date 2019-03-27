package by.it.bolotko.jd01_08;

import java.util.Arrays;

class Vector extends Var {

    private double[] value;

    public double[] getValue() {
        return value;
    }
    Vector(double[] value){ this.value= Arrays.copyOf(value,value.length); }

    @Override
    public Var add(Var other) {
        Vector result = new Vector(value);
        if (other instanceof Scalar) {
            for (int i = 0; i < result.value.length; i++) {
                result.value[i] = result.value[i] + ((Scalar) other).getValue();
            }
            return result;
        }
        if (other instanceof Vector) {
            for (int i = 0; i < result.value.length; i++) {
                result.value[i] = result.value[i] + ((Vector) other).value[i];
            }
            return result;
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        Vector result = new Vector(value);
        if (other instanceof Scalar) {
            for (int i = 0; i < result.value.length; i++) {
                result.value[i] = result.value[i] - ((Scalar) other).getValue();
            }
            return result;
        }
        if (other instanceof Vector) {
            for (int i = 0; i < result.value.length; i++) {
                result.value[i] = result.value[i] - ((Vector) other).value[i];
            }
            return result;
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
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
