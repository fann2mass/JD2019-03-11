package by.it.akhmelev.calc_v6;

import java.util.Arrays;

public class Vector extends Var {

    private double[] value;

    public double[] getValue() {
        return value;
    }

    Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    public Vector(String strValue) {
        String[] arr = strValue
                .replace("{", "")
                .replace("}", "")
                .split(",");
        value=new double[arr.length];
        for (int i = 0; i < value.length; i++) {
            value[i]=Double.parseDouble(arr[i]);
        }
    }

    @Override
    public Var add(Var other) throws CalcException {
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
        for (double element : value) {
            res.append(delimiter).append(element);
            delimiter = ", ";
        }
        res.append("}");
        return res.toString();
    }
}
