package by.it.bildziuh.jd01_08;

import java.util.Arrays;

public class Matrix extends Var {

    private double[][] value;

    Matrix(double[][] value) {
        double[][] thisMatrix = new double[value[0].length][value.length];
        for (int i = 0; i < thisMatrix[0].length; i++)
            for (int j = 0; j < thisMatrix.length; j++)
                thisMatrix[i][j] = value[i][j];
        this.value = thisMatrix;
        //что-то не так
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
        double[][] matrix = new double[splitedString.length][2];
        for (int i = 0; i < splitedString.length; i++) {
            for (int j = 0; j < 2; j++) {
                String[] row = splitedString[i].split("[^\\d.]+");
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
          //   Matrix resAddScalar = new Matrix(value);
            double[][] resAddScalar = Arrays.copyOf(value, value.length);
            for (int i = 0; i < resAddScalar[0].length; i++) {
                for (int j = 0; j < resAddScalar.length; j++) {
                    resAddScalar[i][j] = resAddScalar[i][j] + ((Scalar) other).getValue();
                }
            }
            return new Matrix(resAddScalar);
        } else if (other instanceof Matrix) {
            double[][] resAddMatrix = Arrays.copyOf(value, value.length);
            for (int i = 0; i < resAddMatrix[0].length; i++) {
                for (int j = 0; j < resAddMatrix.length; j++) {
                    resAddMatrix[i][j] = resAddMatrix[i][j] + ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(resAddMatrix);

        }
        return super.add(other);

    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double[][] resSubScalar = Arrays.copyOf(value, value.length);
            for (int i = 0; i < resSubScalar[0].length; i++) {
                for (int j = 0; j < resSubScalar.length; j++) {
                    resSubScalar[i][j] = resSubScalar[i][j] - ((Scalar) other).getValue();
                }
            }
            return new Matrix(resSubScalar);
        } else if (other instanceof Matrix) {
            double[][] resSubMatrix = Arrays.copyOf(value, value.length);
            for (int i = 0; i < resSubMatrix[0].length; i++)
                for (int j = 0; j < resSubMatrix.length; j++)
                    resSubMatrix[i][j] = resSubMatrix[i][j] - ((Matrix) other).value[i][j];

            return new Matrix(resSubMatrix);
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double[][] resMulScalar = Arrays.copyOf(value, value.length);
            for (int i = 0; i < resMulScalar[0].length; i++) {
                for (int j = 0; j < resMulScalar.length; j++) {
                    resMulScalar[i][j] = resMulScalar[i][j] * ((Scalar) other).getValue();
                }
            }
            return new Matrix(resMulScalar);
        }
        //
/*
        if (other instanceof Matrix) {
            double[][] resMulMatrix = Arrays.copyOf(value, value.length);
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[0].length; j++) {
                    for (int k = 0; k < value.length; k++) {
                        resMulMatrix[i][j] = resMulMatrix[i][j] + ((Matrix) other).value[i][k] * ((Matrix) other).value[k][j];
                    }
                }
            }
            return new Matrix(resMulMatrix);
        }
*/
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {

        return super.div(other);
    }
}






