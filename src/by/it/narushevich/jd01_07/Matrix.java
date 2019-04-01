package by.it.narushevich.jd01_07;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

public class Matrix extends Var {

    private double[][] value;

    Matrix(double[][] value) {
        this.value = Arrays.copyOf(Arrays.copyOf(value, value[0].length), value.length);;
    }

    Matrix(Matrix matrix){
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
    public String toString() {
        StringBuilder sb = new StringBuilder("{{");
        AtomicReference<String> delimiter = new AtomicReference<>("");
        for (int i = 0; i < value.length; i++) {
            delimiter.set("");
            for (int j = 0; j < value[0].length; j++) {
                sb.append(delimiter.get()).append(value[i][j]);
                delimiter.set(", ");
            }
            if (i != value.length-1) sb.append("}, {");
            else sb.append("}}");
        }
        return sb.toString();
    }
}
