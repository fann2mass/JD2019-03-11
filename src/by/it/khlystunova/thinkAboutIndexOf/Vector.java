package by.it.khlystunova.thinkAboutIndexOf;

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
    public Var add(Scalar other) {
        Vector result = new Vector(this.vector);//копируем вектор, который вызвал этот метод(this.vector) в вектор результата.
        for (int i = 0; i < result.vector.length; i++) {
            result.vector[i] = result.vector[i] + ((Scalar)other).getValue();
        }
        return result;
    }

    @Override
    public Var add(Vector other) {
        Vector result = new Vector(this.vector);//копируем вектор, который вызвал этот метод(this.vector) в вектор результата.
        if(((Vector) other).vector.length == result.vector.length){
            for (int i = 0; i < result.vector.length; i++) {
                result.vector[i] =result.vector[i]+((Vector) other).vector[i];
            }
        }
        return result;
    }

    @Override
    public Var add(Var other) {
            return super.add(other);
    }

    @Override
    public Var sub(Scalar other) {
        Vector result = new Vector(this.vector);//копируем вектор, который вызвал этот метод(this.vector) в вектор результата.
        for (int i = 0; i < result.vector.length; i++) {
            result.vector[i] = result.vector[i] - ((Scalar)other).getValue();
        }
        return result;
    }

    @Override
    public Var sub(Vector other) {
        Vector result = new Vector(this.vector);//копируем вектор, который вызвал этот метод(this.vector) в вектор результата.
        //если вектор, который вызвал этот метод и вектор other одинаковой длины то вычитаем
        if(((Vector) other).vector.length == result.vector.length){
            for (int i = 0; i < result.vector.length; i++) {
                result.vector[i] =result.vector[i]-((Vector) other).vector[i];
            }
        }
        return result;
    }

    @Override
    public Var sub(Var other) {
        return super.sub(other);
    }

    @Override
    public Var mul(Scalar other) {
        Vector result = new Vector(this.vector);//копируем вектор, который вызвал этот метод(this.vector) в вектор результата.
        for (int i = 0; i < result.vector.length; i++) {
            result.vector[i] = result.vector[i] * ((Scalar)other).getValue();
        }
        return result;
    }

    @Override
    public Var mul(Vector other) {
        Vector result = new Vector(this.vector);//копируем вектор, который вызвал этот метод(this.vector) в вектор результата.
//если вектор, который вызвал этот метод и вектор other одинаковой длины то вычитаем
        double value = 0;
        if(((Vector) other).vector.length == result.vector.length){
            for (int i = 0; i < result.vector.length; i++) {
                value +=result.vector[i]*((Vector) other).vector[i];
            }
        }
        return new Scalar(value);
    }

    @Override
    public Var mul(Var other) {
        return super.mul(other);
    }


    @Override
    public Var div(Matrix other) {
        return null;
    }
    @Override
    public Var div(Scalar other) {
        Vector result = new Vector(this.vector);//копируем вектор, который вызвал этот метод(this.vector) в вектор результата.
        for (int i = 0; i < result.vector.length; i++) {
            result.vector[i] = result.vector[i] / ((Scalar)other).getValue();
        }
        return result;
    }

    @Override
    public Var div(Var other) {
        return super.div(other);
    }
}
