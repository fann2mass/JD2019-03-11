package by.it.bildziuh.jd01_07;

import java.util.Arrays;

public class Matrix extends Var {

    private double[][] value;

    Matrix(double[][] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    Matrix(String strMatrix) {
/*
        StringBuilder sb = new StringBuilder(strMatrix);
        sb.deleteCharAt(0).deleteCharAt(sb.length() - 1);
// запихнуть цикл c разделением
        String str = sb.toString();
        String[] arrayString = str.split("[^\\d.]+");
        double[][] arrayDouble = new double[arrayString[0].length()][arrayString.length];

        for (int i = 0; i < arrayString[0].length(); i++) {
            for (int j = 0; j < arrayString.length; j++) {
                arrayDouble[i][j] = Double.parseDouble(arrayString[j]);
            }
            this.value = arrayDouble;
        }
*/
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






