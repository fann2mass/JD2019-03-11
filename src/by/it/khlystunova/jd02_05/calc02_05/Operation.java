package by.it.khlystunova.jd02_05.calc02_05;

interface Operation {

 Var add(Var other) throws CalcException;
 Var sub(Var other) throws CalcException;
 Var mul(Var other) throws CalcException;
 Var div(Var other) throws CalcException;
}
