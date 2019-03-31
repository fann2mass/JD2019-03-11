package by.it.akhmelev.jd01_09;

public class Matrix  extends Var {

    private double[][] value;

    public double[][] getValue() {
        return value;
    }

    public Matrix(double[][] value) {
        this.value = value;
    }

    public Matrix(String stubString) {

    }

    @Override
    public String toString() {
        return "Matrix";
    }
}
