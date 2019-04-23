package by.it.akhmelev.calc_v6;

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
