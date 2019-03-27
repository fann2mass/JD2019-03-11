package by.it.bolotko.jd01_08;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Matrix extends Var {

    private double[][] matrix;

    public double[][] getMatrix() {
        return matrix;
    }

    @Override
    public Var add(Var other) {
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        return super.div(other);
    }

    Matrix(double[][] matrix) {
        this.matrix = matrix;
    }

    Matrix(Matrix matrix){
        this.matrix = matrix.matrix;
    }

    Matrix(String matrix){
        String[] line = matrix.split("[}, {]{4}");
        int matrixLen = line.length;//кол-во строк
        Pattern pattern = Pattern.compile("[^{}, ]+");
        Matcher matcher = pattern.matcher(line[0]);
        int len = 0;
        while(matcher.find()){
            len++;
        }
        matcher.reset();
        double[][]result = new double[matrixLen][len];
        for (int i =  0;i<line.length;i++) {
            matcher = pattern.matcher(line[i]);
            int j = 0;
            while(matcher.find()){
                String stringElement = matcher.group();
                result[i][j] = Double.parseDouble(stringElement);
                j++;
            }
        }
        this.matrix = result;


    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("{");
        for (int i = 0; i < matrix.length; i++) {
            result.append("{");
            for (int j = 0; j < matrix[0].length; j++) {
                result.append(matrix[i][j]);
                if(j!= matrix[0].length-1)
                    result.append(", ");
                else result.append("}");
            }
            if(i!=matrix.length-1) result.append(",");
        }
        result.append("}");
        return result.toString();
    }
}

