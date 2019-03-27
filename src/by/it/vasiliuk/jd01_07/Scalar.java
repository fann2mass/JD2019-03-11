package by.it.vasiliuk.jd01_07;

public class Scalar extends Var {
    private double value;
    Scalar(double value){
        this.value = value;
    }

    Scalar(Scalar scalar) {
        this.value = scalar.value;
    }

    Scalar(String value) {
        this.value = Double.parseDouble(value);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}
