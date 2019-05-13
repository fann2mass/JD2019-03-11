package by.it.bildziuh.calc;

import java.util.Arrays;

class Vector extends Var  {

    private String DIVIDEDBYZERO = Localization.manager.getString(Msg.DIVIDEDBYZERO);

    private double[] value;

    public double[] getValue() {
        return value;
    }

    Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    Vector(Vector vector) {
        this.value = vector.value;
    }

    Vector(String strVector) {

        StringBuilder sb = new StringBuilder(strVector);
        sb.deleteCharAt(0).deleteCharAt(sb.length() - 1);
        String str = sb.toString();
        String[] arrayString = str.split("[^\\d.]+");
        double[] arrayDouble = new double[arrayString.length];
        for (int i = 0; i < arrayString.length; i++) {
            arrayDouble[i] = Double.parseDouble(arrayString[i]);
        }
        this.value = arrayDouble;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (int i = 0; i < value.length; i++) {
            double element = value[i];
            sb.append(delimiter).append(element);
            delimiter = ", ";
        }
        sb.append("}");
        return sb.toString();
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] + ((Scalar) other).getValue();
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            double[] res = Arrays.copyOf(value, value.length);
            if (((Vector) other).value.length != this.value.length)
                throw new CalcException(Localization.manager.getString(Msg.INCONSISTENTDIM));
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] + ((Vector) other).value[i];
            }
            return new Vector(res);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] - ((Scalar) other).getValue();
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            double[] res = Arrays.copyOf(value, value.length);
            if (((Vector) other).value.length != this.value.length)
                throw new CalcException(Localization.manager.getString(Msg.INCONSISTENTDIM));
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] - ((Vector) other).value[i];
            }
            return new Vector(res);
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) {
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] * ((Scalar) other).getValue();
            }
            return new Vector(res);
        } else if (other instanceof Vector) {
            double[] thisVector = Arrays.copyOf(value, value.length);
            if (((Vector) other).value.length != this.value.length)
                throw new CalcException(Localization.manager.getString(Msg.INCONSISTENTDIM));
            double res = 0;
            for (int i = 0; i < thisVector.length; i++) {
                thisVector[i] = thisVector[i] * ((Vector) other).value[i];
                res = res + thisVector[i];
            }
            return new Scalar(res);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) {
            if ((((Scalar) other).getValue()) == 0)
                throw new CalcException(DIVIDEDBYZERO);
            double[] thisVector = Arrays.copyOf(value, value.length);
            for (int i = 0; i < thisVector.length; i++) {
                thisVector[i] = thisVector[i] / ((Scalar) other).getValue();
            }
            return new Vector(thisVector);
        }
        return super.div(other);
    }

}
