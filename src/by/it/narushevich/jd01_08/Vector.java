package by.it.narushevich.jd01_08;

import java.util.Arrays;

public class Vector extends Var {

    private double[] value;

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar){
            Vector vector = new Vector(value);
            double[] result = ;
        }
        return super.add(other);
    }

    Vector(double[] value) {
        this.value = Arrays.copyOf(value,value.length);
        }

    Vector(Vector vector) {
        this.value = vector.value;
    }

    Vector(String strVector) {
        StringBuilder sb = new StringBuilder(strVector);
        sb.deleteCharAt(0).deleteCharAt(sb.length() - 1);
        String str = sb.toString();
        String[] arrayString = str.split("[^\\d.]+");
        double[] arrayDouble = new double[arrayString.length];
        for (int i = 0; i < arrayString.length; i++) {
            arrayDouble[i] = Double.parseDouble(arrayString[i]);
        }
        this.value = arrayDouble;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (double element : value) {
            sb.append(delimiter).append(element);
            delimiter = ", ";
        }
        sb.append("}");
        return sb.toString();
    }
}
