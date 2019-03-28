package by.it.vasiliuk.jd01_07;

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
        int length = 0;
        while (matcher.find()) {
            length++;
        }
        matcher.reset();
        double[] array = new double[length];
        int i = 0;
        while (matcher.find()){
            String s_gr = matcher.group();
            array[i] = Double.parseDouble(s_gr);
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
}
