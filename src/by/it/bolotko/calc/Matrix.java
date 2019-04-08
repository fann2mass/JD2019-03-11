package by.it.bolotko.calc;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Matrix extends Var {

    private double[][] value;

    public double[][] getValue() {
        return value;
    }

    @Override
    public Var add(Var other) {
        Matrix result = new Matrix(value);
        this.value= Arrays.copyOf(value,value.length);
        if (other instanceof Scalar) {
            for (int i = 0; i < result.value.length; i++) {
                for (int j = 0; j < result.value.length; j++) {
                    result.value[i][j] = result.value[i][j] + ((Scalar) other).getValue();
                }
            }
            return result;
        }
        if (other instanceof Matrix) {
            if (!(result.value.length == ((Matrix) other).value.length)) return super.add(other);
            for (int i = 0; i < result.value.length; i++) {
                for (int j = 0; j < result.value.length; j++) {
                    result.value[i][j] = result.value[i][j] + ((Matrix) other).value[i][j];
                }
            }
            return result;
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        Matrix result = new Matrix(value);
        if (other instanceof Scalar) {
            for (int i = 0; i < result.value.length; i++) {
                for (int j = 0; j < result.value.length; j++) {
                    result.value[i][j] = result.value[i][j] - ((Scalar) other).getValue();
                }
            }
            return result;
        }
        this.value= Arrays.copyOf(value,value.length);
        if (other instanceof Matrix) {
            if (!(result.value.length == ((Matrix) other).value.length)) return super.sub(other);
            for (int i = 0; i < result.value.length; i++) {
                for (int j = 0; j < result.value.length; j++) {
                    result.value[i][j] = result.value[i][j] - ((Matrix) other).value[i][j];
                }
            }
            return result;
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        Matrix result = new Matrix(value);
        this.value= Arrays.copyOf(value,value.length);
        if (other instanceof Scalar) {
            for (int i = 0; i < result.value.length; i++) {
                for (int j = 0; j < result.value.length; j++) {
                    result.value[i][j] = result.value[i][j] * ((Scalar) other).getValue();
                }
            }
            return result;
        }
        if (other instanceof Vector) {
            double[] resultVector=new double[value.length];
            if (!(result.value.length == ((Vector) other).getValue().length)) return super.mul(other);
            for (int i = 0; i < result.value.length; i++) {
                for (int j = 0; j < result.value.length; j++) {
                    resultVector[i] += result.value[i][j] * ((Vector) other).getValue()[j];
                }
            }
            return new Vector(resultVector);
        }
        if (other instanceof Matrix) {
            if (!(result.value.length == ((Matrix) other).value.length)) return super.mul(other);
            double[][] sum=new double[value.length][value.length];
            for (int i = 0; i < result.value.length; i++) {
                for (int j = 0; j < result.value.length; j++) {
                    for (int k = 0; k < value.length; k++) {
                        sum[i][j]+= result.value[i][k]*((Matrix) other).value[k][j];
                    }
                }
            }
            return new Matrix(sum);
        }
        return super.mul(other);
    }


    Matrix(double[][] value){
        double[][] value2 = new double[value.length][value[0].length];
        for (int i = 0; i < value2.length; i++)
            System.arraycopy(value[i], 0, value2[i], 0, value2[0].length);
        this.value = value2;
    }

    Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    Matrix(String matrix) {
        String[] line = matrix.split("},");
        for (int i = 0; i < line.length; i++) {
            line[i] = line[i].replace("{", "").replace("}", "");

        }
        int matrixLen = line.length;//кол-во строк
        Pattern pattern = Pattern.compile("[^{}, ]+");
        Matcher matcher = pattern.matcher(line[0]);
        int len = 0;
        while (matcher.find()) {
            len++;
        }
        matcher.reset();
        double[][] result = new double[matrixLen][len];
        for (int i = 0; i < line.length; i++) {
            matcher = pattern.matcher(line[i]);
            int j = 0;
            while (matcher.find()) {
                String stringElement = matcher.group();
                result[i][j] = Double.parseDouble(stringElement);
                j++;
            }
        }
        this.value = result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("{");
        for (int i = 0; i < value.length; i++) {
            result.append("{");
            for (int j = 0; j < value[0].length; j++) {
                result.append(value[i][j]);
                if (j != value[0].length - 1)
                    result.append(", ");
                else result.append("}");
            }
            if (i != value.length - 1)
                result.append(", ");
        }
        result.append("}");
        return result.toString();
    }
}

