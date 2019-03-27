package by.it.narushevich.jd01_08;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

public class Matrix extends Var {

    private double[][] value;

    public double[][] getValue() {
        return value;
    }

    Matrix(double[][] value) {
        this.value = Arrays.copyOf(value,value.length);
    }

    Matrix(Matrix matrix) {
        this.value = matrix.value;
    }

    Matrix(String strMatrix) {
        StringBuilder sb = new StringBuilder(strMatrix);
        for (int i = 0; i < 2; i++) {
            sb.deleteCharAt(0).deleteCharAt(sb.length() - 1);
        }
        String str = sb.toString();
        String[] arrStr = str.split("}");
        String[] rowsM = new String[arrStr.length];
        rowsM[0] = arrStr[0];
        String[] colsInRow = rowsM[0].split("[, ]+");
        for (int i = 1; i < arrStr.length; i++) {
            String rowM = arrStr[i].replaceFirst("[, {]+","");
            rowsM[i] = rowM;
        }
        double[][] resMatrix = new double[rowsM.length][colsInRow.length];
        for (int i = 0; i < rowsM.length; i++) {
            String[] colsM = rowsM[i].split("[, ]+");
            for (int j = 0; j < colsM.length; j++) {
                resMatrix[i][j] = Double.parseDouble(colsM[j]);
            }
        }
        this.value = resMatrix;
    }


    @Override
    public Var add(Var other) {
        Matrix result1 = new Matrix(value);
        Matrix result2 = new Matrix(value);
        if (other instanceof Scalar) {
            for (int i = 0; i < this.value.length; i++)
                for (int j = 0; j < this.value[0].length; j++)
                    result1.value[i][j] = this.value[i][j] + ((Scalar) other).getValue();
            return result1;
        }
        if (other instanceof Vector) {
            System.out.println("Сложение " + this + " + " + other + " невозможно!");
        }

        if (other instanceof Matrix) {
            for (int i = 0; i < this.value.length; i++)
                for (int j = 0; j < this.value[0].length; j++)
                    result2.value[i][j] = this.value[i][j] + ((Matrix) other).value[i][j];
            return result2;
        }

        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        Matrix result = new Matrix(value);
        if (other instanceof Scalar) {
            for (int i = 0; i < this.value.length; i++)
                for (int j = 0; j < this.value[0].length; j++)
                    result.value[i][j] = result.value[i][j] - ((Scalar) other).getValue();
            return result;
        }

        if (other instanceof Matrix) {
            for (int i = 0; i < this.value.length; i++)
                for (int j = 0; j < this.value[0].length; j++)
                    result.value[i][j] = this.value[i][j] - ((Matrix) other).value[i][j];
            return result;
        }

        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        Matrix result = new Matrix(value);
        if (other instanceof Scalar) {
            for (int i = 0; i < this.value.length; i++)
                for (int j = 0; j < this.value[0].length; j++)
                    result.value[i][j] = result.value[i][j] * ((Scalar) other).getValue();
        }
        return result;
    }


    @Override
    public Var div(Var other) {
        return super.div(other);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{{");
        AtomicReference<String> delimiter = new AtomicReference<>("");
        for (int i = 0; i < value.length; i++) {
            delimiter.set("");
            for (int j = 0; j < value[0].length; j++) {
                sb.append(delimiter.get()).append(value[i][j]);
                delimiter.set(", ");
            }
            if (i != value.length - 1) sb.append("}, {");
            else sb.append("}}");
        }
        return sb.toString();
    }
}
