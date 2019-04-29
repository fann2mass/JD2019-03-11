package by.it.khlystunova.jd02_05.calc02_05;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Matrix extends Var {

    private double[][] matrix;

    private Matrix(double[][] value) {
        this.matrix = Arrays.copyOf(value,value.length);
    }

    //Matrix(Matrix value){
   //    this.matrix = Arrays.copyOf(value.matrix,value.matrix.length);
    //}

    Matrix(String matrix){
        String[] line = matrix.split("},");
        for (int i = 0; i < line.length; i++) {
            line[i]=line[i].replace("{","").replace("}","");
        }
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
            if(i!=matrix.length-1)
                result.append(", ");
        }
        result.append("}");
        return result.toString();
    }

    @Override
    public Var add(Var other) throws CalcException {
        double[][] result = new double[this.matrix.length][this.matrix[0].length];
        if(other instanceof Matrix) {
            //если размерность матриц одинаковая
            if (this.matrix.length == ((Matrix) other).matrix.length && this.matrix[0].length == ((Matrix) other).matrix[0].length) {
                for (int i = 0; i < ((Matrix) other).matrix.length; i++) {
                    for (int j = 0; j < ((Matrix) other).matrix.length; j++) {
                        result[i][j] = this.matrix[i][j] + ((Matrix) other).matrix[i][j];
                    }
                }
            return new Matrix(result);
        }else throw  new CalcException(ResourceManager.INSTANCE.getString(Msg.EXEPTION_FALSE_SIZE_MATRIX));
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
    public Var sub(Var other) throws CalcException {
        double[][] result = new double[this.matrix.length][this.matrix[0].length];
        if(other instanceof Matrix) {
            //если размерность матриц одинаковая
            if (this.matrix.length == ((Matrix) other).matrix.length && this.matrix[0].length == ((Matrix) other).matrix[0].length) {
                for (int i = 0; i < ((Matrix) other).matrix.length; i++) {
                    for (int j = 0; j < ((Matrix) other).matrix.length; j++) {
                        result[i][j] = this.matrix[i][j] - ((Matrix) other).matrix[i][j];
                    }
                }
            return new Matrix(result);
            }else throw  new CalcException(ResourceManager.INSTANCE.getString(Msg.EXEPTION_FALSE_SIZE_MATRIX));
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
    public Var mul(Var other) throws CalcException {
        if(other instanceof Vector){
            double[] result = new double[((Vector) other).getVector().length];
            //если число столбцов матрицы = кол-ву элементов вектора
            if(this.matrix[0].length == ((Vector) other).getVector().length) {
                for (int i = 0; i < this.matrix[0].length; i++) {
                    for (int j = 0; j < ((Vector) other).getVector().length; j++) {
                        result[i] += this.matrix[i][j]*((Vector) other).getVector()[j];
                    }
                }
                return new Vector(result);
            }else throw  new CalcException(ResourceManager.INSTANCE.getString(Msg.EXEPTION_FALSE_SIZE_VECTOR));
        }else if(other instanceof Matrix) {
            double[][] result = new double[this.matrix.length][this.matrix[0].length];
            //кол-во столбцов 1 матрицы = кол-ву строк во 2
            if (this.matrix[0].length == ((Matrix) other).matrix.length) {
                for (int i = 0; i < this.matrix.length; i++) {
                    for (int j = 0; j < ((Matrix) other).matrix[0].length; j++) {
                        for (int k = 0; k < ((Matrix) other).matrix.length; k++) {
                            result[i][j] += this.matrix[i][k] * ((Matrix) other).matrix[k][j];
                        }
                    }
                }
            return new Matrix(result);
            }else throw  new CalcException(ResourceManager.INSTANCE.getString(Msg.EXEPTION_FALSE_SIZE_MATRIX+"\n"));
        }else if(other instanceof Scalar){
            double[][] result = new double[this.matrix.length][this.matrix[0].length];
            for (int i = 0; i < this.matrix.length; i++) {
                for (int j = 0; j < this.matrix.length; j++) {
                    result[i][j] = this.matrix[i][j] * ((Scalar) other).getValue();
                }
            }
            return new Matrix(result);
        }
        return super.mul(other);
    }
}
