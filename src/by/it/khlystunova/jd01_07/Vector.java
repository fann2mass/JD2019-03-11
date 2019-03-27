package by.it.khlystunova.jd01_07;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Vector extends Var {

    private double[] vector;

    Vector(double[] value) {
        this.vector = value;
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
}
