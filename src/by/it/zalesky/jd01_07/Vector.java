package by.it.zalesky.jd01_07;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Vector extends Var {

    private double[] value;

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



    Vector (Vector vector) {
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