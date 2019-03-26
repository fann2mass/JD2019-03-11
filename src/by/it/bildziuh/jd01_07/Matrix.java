package by.it.bildziuh.jd01_07;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Matrix extends Var {

    private double[][] value;

    Matrix(double[][] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    Matrix(String strMatrix) {

        StringBuilder sb = new StringBuilder(strMatrix);
        sb.deleteCharAt(0).deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(0).deleteCharAt(sb.length() - 1);
        String string = sb.toString();

        String[] splitedString = string.split("[{]");
        //  System.out.println(splitedString[0]);
        //  System.out.println(splitedString[1]);

        double[][] matrix = new double[splitedString.length][2];

        for (int i = 0; i < splitedString.length; i++) {
            for (int j = 0; j < splitedString.length; j++) {
                String[] raw = splitedString[i].split("[^\\d.]+");
                matrix[i][j] = Double.parseDouble(raw[j]);
            }
            this.value = matrix;
        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (int i = 0; i < this.value.length; i++) {
            sb.append("{");
            for (int j = 0; j < this.value[i].length; j++) {
                double element = this.value[i][j];
                sb.append(delimiter).append(element);
                delimiter = ", ";
            }
            sb.append("}");
            if (i + 1 < this.value.length)
                sb.append(",");
            delimiter = "";
        }
        sb.append("}");
        return sb.toString();
    }
}






