package by.it.zalesky.Calc;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Vector extends Var {

    private double[] value;


    @Override
    public Var add(Var other) throws CalcException{
        Vector res = new Vector(value);
        if (other instanceof Scalar) {
            for (int i = 0; i < res.value.length; i++) {
                res.value[i] = res.value[i] + ((Scalar) other).getValue();
            }
            return res;
        }
        if (other instanceof Vector) {
            for (int i = 0; i < res.value.length; i++) {
                res.value[i] = res.value[i] + ((Vector) other).value[i];
            }
            return res;
        }
        return super.add(other);
    }




    @Override
    public Var sub(Var other) throws CalcException{
        if (other instanceof Scalar) {
            double[] vector = Arrays.copyOf(this.value, this.value.length);
            double scalar = ((Scalar) other).getValue();
            for (int i = 0; i < vector.length; i++) {
                vector[i] -= scalar;

            }
            return new Vector(vector);

        } else if (other instanceof Vector) {
            double [] vector = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < vector.length; i++) {
                vector[i] -= ((Vector) other).value[i];

            }
            return new Vector(vector);
        }
        else

            return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcException{
        if (other instanceof Scalar) {
            double [] vector = Arrays.copyOf(this.value, this.value.length);
            double scalar = ((Scalar)other).getValue();
            for (int i = 0; i < vector.length; i++) {
                vector[i] *= scalar;
            }
            return new Vector(vector);
        }
        else if (other instanceof Vector) {
            double res = 0;
            for (int i = 0; i < this.value.length; i++) {
                res+= this.value[i] + ((Vector) other).value[i];
            }
            return new Scalar(res);
        }
        else
            return super.mul(other);
    }

    @Override
    public Var div(Var other) throws CalcException{
        if (other instanceof Scalar) {
            double[] vector = Arrays.copyOf(this.value, this.value.length);
            double scalar = ((Scalar) other).getValue();
            for (int i = 0; i < vector.length; i++) {
                vector[i] /= scalar;
            }
            return new Vector(vector);
        }
        else
            return super.div(other);

    }

    Vector(double[] value) {
        this.value = value;
    }


    Vector(String vector) {

        Pattern pattern = Pattern.compile("[^{}, ]+");
        Matcher matcher = pattern.matcher(vector);
        int vec = 0;
        while (matcher.find()) {
            vec++;
        }
        matcher.reset();
        double[] array = new double[vec];
        int i = 0;
        while (matcher.find()){
            String str = matcher.group();
            array[i] = Double.parseDouble(str);
            i++;
        }
        this.value = array;
    }


    private double value(int i) {
        return 0;
    }

    Vector(Vector vector) {
        this.value = vector.value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimeter = "";
        for (double element : value) {
            sb.append(delimeter).append(element);
            delimeter = ", ";
        }
        sb.append("}");
        return sb.toString();
    }

}