package by.it.khlystunova.thinkAboutIndexOf;

public interface ScalarOperation {
    Var add(Scalar other);
    Var sub(Scalar other);
    Var mul(Scalar other);
    Var div(Scalar other);//не работает Scalar/Scalar

}
