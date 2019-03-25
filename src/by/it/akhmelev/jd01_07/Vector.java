package by.it.akhmelev.jd01_07;

import java.util.Arrays;

public class Vector extends Var {

    private double[] value;

    Vector(double[] value) {
        this.value = Arrays.copyOf(value,value.length);
    }

    @Override
    public String toString() {
        StringBuilder res=new StringBuilder("{");
        String delimiter="";
        for (int i = 0; i < value.length; i++) {
            double element = value[i];
            res.append(delimiter).append(element);
            delimiter = ", ";
        }
        res.append("}");
        return res.toString();
    }
}
