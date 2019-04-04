package by.it.vasiliuk.jd01_09;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Matrix extends Var {

    double[][] matrix;

    Matrix(double[][] value) {
        this.matrix = Arrays.copyOf(value,value.length);
    }

    Matrix(Matrix value){
        this.matrix = Arrays.copyOf(value.matrix,value.matrix.length);
    }

    Matrix(String matrix){
        String[] line = matrix.split("},");
        for (int i = 0; i < line.length; i++) {
            line[i]=line[i].replace("{","").replace("}","");
        }
        int matrixLength = line.length;
        Pattern pattern = Pattern.compile("[^{}, ]+");
        Matcher matcher = pattern.matcher(line[0]);
        int len = 0;
        while(matcher.find()){
            len++;
        }
        matcher.reset();
        double[][]res = new double[matrixLength][len];
        for (int i =  0;i<line.length;i++) {
            matcher = pattern.matcher(line[i]);
            int j = 0;
            while(matcher.find()){
                String stringElement = matcher.group();
                res[i][j] = Double.parseDouble(stringElement);
                j++;
            }
        }
        this.matrix = res;

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
                res.append(", ");
        }
        res.append("}");
        return res.toString();
    }

    @Override
    public Var add(Var other) {
        double[][] result = new double[this.matrix.length][this.matrix[0].length];
        if(other instanceof Matrix){
                        if(this.matrix.length == ((Matrix) other).matrix.length  && this.matrix[0].length == ((Matrix) other).matrix[0].length ){
                for (int i = 0; i < ((Matrix) other).matrix.length; i++) {
                    for (int j = 0; j < ((Matrix) other).matrix.length; j++) {
                        result[i][j] = this.matrix[i][j] + ((Matrix) other).matrix[i][j];
                    }
                }
            }return new Matrix(result);
        }else if(other instanceof Scalar){
            for (int i = 0; i < this.matrix.length; i++) {
                for (int j = 0; j < this.matrix.length; j++) {
                    result[i][j] = this.matrix[i][j] + ((Scalar) other).getValue();
                }
            }
            return new Matrix(result);
        }
        else return  super.add(other);
    }

    @Override
    public Var sub(Var other) {
        double[][] result = new double[this.matrix.length][this.matrix[0].length];
        if(other instanceof Matrix){
                        if(this.matrix.length == ((Matrix) other).matrix.length  && this.matrix[0].length == ((Matrix) other).matrix[0].length ){
                for (int i = 0; i < ((Matrix) other).matrix.length; i++) {
                    for (int j = 0; j < ((Matrix) other).matrix.length; j++) {
                        result[i][j] = this.matrix[i][j] - ((Matrix) other).matrix[i][j];
                    }
                }
            }return new Matrix(result);
        }else if(other instanceof Scalar){
            for (int i = 0; i < this.matrix.length; i++) {
                for (int j = 0; j < this.matrix.length; j++) {
                    result[i][j] = this.matrix[i][j] - ((Scalar) other).getValue();
                }
            }
            return new Matrix(result);
        }
        else return  super.add(other);
    }
    @Override
    public Var mul(Var other) {
        if(other instanceof Vector){
            double[] res = new double[((Vector) other).getVector().length];
                        if(this.matrix[0].length == ((Vector) other).getVector().length) {
                for (int i = 0; i < this.matrix[0].length; i++) {
                    for (int j = 0; j < ((Vector) other).getVector().length; j++) {
                        res[i] += this.matrix[i][j]*((Vector) other).getVector()[j];
                    }
                }
            }
            return new Vector(res);
        }else if(other instanceof Matrix){
            double[][] res = new double[this.matrix.length][this.matrix[0].length];
                        if(this.matrix[0].length == ((Matrix) other).matrix.length){
                for (int i = 0; i < this.matrix.length; i++) {
                    for (int j = 0; j < ((Matrix) other).matrix[0].length; j++) {
                        for (int k = 0; k < ((Matrix) other).matrix.length; k++) {
                            res[i][j] += this.matrix[i][k]*((Matrix) other).matrix[k][j];
                        }
                    }
                }
            }
            return new Matrix(res);
        }else if(other instanceof Scalar){
            double[][] res = new double[this.matrix.length][this.matrix[0].length];
            for (int i = 0; i < this.matrix.length; i++) {
                for (int j = 0; j < this.matrix.length; j++) {
                    res[i][j] = this.matrix[i][j] * ((Scalar) other).getValue();
                }
            }
            return new Matrix(res);
        }
        return super.mul(other);
    }
}
