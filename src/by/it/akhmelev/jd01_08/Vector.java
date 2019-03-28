package by.it.akhmelev.jd01_08;

import java.util.Arrays;

public class Vector extends Var {

    private double[] value;

    public double[] getValue() {
        return value;
    }

    Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

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
    public String toString() {
        StringBuilder res = new StringBuilder("{");
        String delimiter = "";
        for (int i = 0; i < value.length; i++) {
            double element = value[i];
            res.append(delimiter).append(element);
            delimiter = ", ";
        }
        res.append("}");
        return res.toString();
    }
}
