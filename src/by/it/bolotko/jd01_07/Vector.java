package by.it.bolotko.jd01_07;

import java.util.Arrays;

class Vector extends Var {

    private double[] value;

    Vector(double[] value){

        this.value= Arrays.copyOf(value,value.length);
    }
    Vector(String str) {
        String result = str.replaceAll("[^0-9. ]", "");
        String strArr[] = result.split(" ");
        double value[] = new double[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            value[i] = Double.parseDouble(strArr[i]);
        }
        this.value= Arrays.copyOf(value,value.length);
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
