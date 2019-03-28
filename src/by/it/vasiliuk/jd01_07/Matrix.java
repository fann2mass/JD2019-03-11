package by.it.vasiliuk.jd01_07;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Matrix extends Var {

    private double[][] matrix;

    Matrix(double[][] matrix) {
        this.matrix = matrix;
    }

    Matrix(Matrix matrix){
        this.matrix = matrix.matrix;
    }

    Matrix(String matrix){
        String[] line = matrix.split("[}, {]{4}");
        int matrixLength = line.length;//кол-во строк
        Pattern pattern = Pattern.compile("[^{}, ]+");
        Matcher matcher = pattern.matcher(line[0]);
        int length = 0;
        while(matcher.find()){
            length++;
        }
        matcher.reset();
        double[][]result = new double[matrixLength][length];
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
        StringBuilder res = new StringBuilder("{");
        for (int i = 0; i < matrix.length; i++) {
            res.append("{");
            for (int j = 0; j < matrix[0].length; j++) {
                res.append(matrix[i][j]);
                if(j!= matrix[0].length-1)
                    res.append(", ");
                else res.append("}");
            }
            if(i!=matrix.length-1)
                res.append(",");
        }
        res.append("}");
        return res.toString();
    }
}
