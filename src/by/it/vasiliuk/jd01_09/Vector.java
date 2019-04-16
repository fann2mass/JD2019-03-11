package by.it.vasiliuk.jd01_09;

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

    Vector(Vector vector) {
        this.vector = vector.vector;
    }

    Vector(String vector) {

        Pattern pattern = Pattern.compile("[^{}, ]+");
        Matcher matcher = pattern.matcher(vector);
        int length = 0;
        while (matcher.find()) {
            length++;
        }
        matcher.reset();
        double[] array = new double[length];
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
        StringBuilder res = new StringBuilder("{");
        for (int i = 0; i < vector.length; i++) {
            res.append(vector[i]);
            if(i== vector.length-1)
                res.append("}");
            else res.append(", ");
        }
        return res.toString();
    }

    @Override
    public Var add(Var other) {
        Vector result = new Vector(this.vector);
        if(other instanceof Vector){
            if(((Vector) other).vector.length == result.vector.length){
                for (int i = 0; i < result.vector.length; i++) {
                    result.vector[i] =result.vector[i]+((Vector) other).vector[i];
                }
            }
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
    public Var sub(Var other) {
        Vector result = new Vector(this.vector);
        if(other instanceof Vector){
            if(((Vector) other).vector.length == result.vector.length){
                for (int i = 0; i < result.vector.length; i++) {
                    result.vector[i] =result.vector[i]-((Vector) other).vector[i];
                }
            }
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
    public Var mul(Var other) {
        Vector result = new Vector(this.vector);
        if(other instanceof Vector){
            double value = 0;
            if(((Vector) other).vector.length == result.vector.length){
                for (int i = 0; i < result.vector.length; i++) {
                    value +=result.vector[i]*((Vector) other).vector[i];
                }
            }
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
    public Var div(Var other) {
        Vector result = new Vector(this.vector);
        if(other instanceof Scalar){
            for (int i = 0; i < result.vector.length; i++) {
                result.vector[i] = result.vector[i] / ((Scalar)other).getValue();
            }
            return result;
        }
        return super.div(other);
    }
}
