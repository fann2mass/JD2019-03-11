package by.it.vasiliuk.calc;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Vector extends Var {

    private double[] vector;

    public double[] getVector() {
        return vector;
    }
    Vector(double[] value) {
        this.vector = Arrays.copyOf(value, value.length);
    }


    Vector(String vector) {

        Pattern pattern = Pattern.compile("[^{}, ]+");
        Matcher matcher = pattern.matcher(vector);
        int len = 0;
        while (matcher.find()) {
            len++;
        }
        matcher.reset();
        double[] array = new double[len];
        int i = 0;
        while (matcher.find()){
            String s = matcher.group();
            array[i] = Double.parseDouble(s);
            i++;
        }
        this.vector = array;
    }



    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("{");
        for (int i = 0; i < vector.length; i++) {
            result.append(vector[i]);
            if(i== vector.length-1)
                result.append("}");
            else result.append(", ");
        }
        return result.toString();
    }

    @Override
    public Var add(Var other) throws CalcException {
        Vector result = new Vector(this.vector);
        if(other instanceof Vector){
            if(((Vector) other).vector.length == result.vector.length){
                for (int i = 0; i < result.vector.length; i++) {
                    result.vector[i] =result.vector[i]+((Vector) other).vector[i];
                }
            }else throw new CalcException("Неправильная длина.");
            return result;
        }else if(other instanceof Scalar){
            for (int i = 0; i < result.vector.length; i++) {
                result.vector[i] = result.vector[i] + ((Scalar)other).getValue();
            }
            return result;
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        Vector result = new Vector(this.vector);
        if(other instanceof Vector){
            if(((Vector) other).vector.length == result.vector.length){
                for (int i = 0; i < result.vector.length; i++) {
                    result.vector[i] =result.vector[i]-((Vector) other).vector[i];
                }
            }else throw new CalcException("Неправильная длина.");
            return result;
        }else if(other instanceof Scalar){
            for (int i = 0; i < result.vector.length; i++) {
                result.vector[i] = result.vector[i] - ((Scalar)other).getValue();
            }
            return result;
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        Vector result = new Vector(this.vector);
        if(other instanceof Vector){
            double value = 0;
            if(((Vector) other).vector.length == result.vector.length){
                for (int i = 0; i < result.vector.length; i++) {
                    value +=result.vector[i]*((Vector) other).vector[i];
                }
            }else throw new CalcException("Неправильная длина.");
            return new Scalar(value);
        }else if(other instanceof Scalar){
            for (int i = 0; i < result.vector.length; i++) {
                result.vector[i] = result.vector[i] * ((Scalar)other).getValue();
            }
            return result;
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        Vector res = new Vector(this.vector);
        if(other instanceof Scalar){
            if(((Scalar) other).getValue()==0) throw new CalcException("Деление на ноль.");
            for (int i = 0; i < res.vector.length; i++) {
                res.vector[i] = res.vector[i] / ((Scalar)other).getValue();
            }
            return res;
        }
        return super.div(other);
    }
}