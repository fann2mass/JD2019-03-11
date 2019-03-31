package by.it.bildziuh.jd01_07;


import java.util.regex.Matcher;
import java.util.regex.Pattern;
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

        Pattern patternRows = Pattern.compile("((-?[\\d]+\\.?[\\d]*)\\s?,?\\s?)+");
        Pattern patternNumbers = Pattern.compile("[\\d]+\\.?+\\d*");
        Matcher matcherRows = patternRows.matcher(strMatrix);
        Matcher matcherNumbers = patternNumbers.matcher(strMatrix);
        int rows = 0;
        int numbers = 0;
        while (matcherRows.find()) {
            rows++;
        }
        while (matcherNumbers.find()) {
            numbers++;
        }
        int cols = numbers / rows;

        String[] splitString = strMatrix.split("\\}\\s?,\\s?\\{");
        for (int i = 0; i < splitString.length; i++) {
            splitString[i] = splitString[i].replace("{", "").replace("}", "");
        }
        double[][] matrix = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                String[] row = splitString[i].split(",");
                matrix[i][j] = Double.parseDouble(row[j]);
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






