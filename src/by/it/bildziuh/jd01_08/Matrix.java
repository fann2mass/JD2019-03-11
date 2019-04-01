package by.it.bildziuh.jd01_08;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Matrix extends Var {

    private double[][] value;

    public double[][] getValue() {
        return value;
    }

    Matrix(double[][] value) {
        double[][] thisMatrix = new double[value.length][value[0].length];
        for (int i = 0; i < thisMatrix.length; i++)
            for (int j = 0; j < thisMatrix[0].length; j++)
                thisMatrix[i][j] = value[i][j];
        this.value = thisMatrix;
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
                sb.append(", ");
            delimiter = "";
        }
        sb.append("}");
        return sb.toString();
    }


    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            Matrix resAddScalar = new Matrix(value);
            for (int i = 0; i < resAddScalar.value.length; i++) {
                for (int j = 0; j < resAddScalar.value.length; j++) {
                    resAddScalar.value[i][j] = resAddScalar.value[i][j] + ((Scalar) other).getValue();
                }
            }
            return new Matrix(resAddScalar);

        } else if (other instanceof Matrix) {
            Matrix resAddMatrix = new Matrix(value);
            for (int i = 0; i < resAddMatrix.value[0].length; i++) {
                for (int j = 0; j < resAddMatrix.value.length; j++) {
                    resAddMatrix.value[i][j] = resAddMatrix.value[i][j] + ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(resAddMatrix);

        }
        return super.add(other);

    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            Matrix resSubScalar = new Matrix(value);
            for (int i = 0; i < resSubScalar.value[0].length; i++) {
                for (int j = 0; j < resSubScalar.value.length; j++) {
                    resSubScalar.value[i][j] = resSubScalar.value[i][j] - ((Scalar) other).getValue();
                }
            }
            return new Matrix(resSubScalar);

        } else if (other instanceof Matrix) {
            Matrix resSubMatrix = new Matrix(value);
            for (int i = 0; i < resSubMatrix.value[0].length; i++)
                for (int j = 0; j < resSubMatrix.value.length; j++)
                    resSubMatrix.value[i][j] = resSubMatrix.value[i][j] - ((Matrix) other).value[i][j];

            return new Matrix(resSubMatrix);
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            Matrix resMulScalar = new Matrix(value);
            for (int i = 0; i < resMulScalar.value[0].length; i++) {
                for (int j = 0; j < resMulScalar.value.length; j++) {
                    resMulScalar.value[i][j] = resMulScalar.value[i][j] * ((Scalar) other).getValue();
                }
            }
            return new Matrix(resMulScalar);
        }
        if (other instanceof Vector) {
            Matrix MulVector = new Matrix(value);
            double[] resMulVector = new double[value.length];
            for (int i = 0; i < MulVector.value[0].length; i++) {
                for (int j = 0; j < MulVector.value.length; j++) {
                    resMulVector[i] = resMulVector[i] + MulVector.value[i][j] * ((Vector) other).getValue()[j];
                }
            }
            return new Vector(resMulVector);
        }

        if (other instanceof Matrix) {
            Matrix MulMatrix = new Matrix(value);
            double[][] resMulMatrix = new double[MulMatrix.value.length][((Matrix) other).value[0].length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[0].length; j++) {
                    for (int k = 0; k < value.length; k++) {
                        resMulMatrix[i][j] = resMulMatrix[i][j] + this.value[i][k] * ((Matrix) other).value[k][j];
                    }
                }
            }
            return new Matrix(resMulMatrix);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        return super.div(other);
    }
}






