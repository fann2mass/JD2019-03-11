package by.it.eslaikouskaya.calc;

import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {

	private static Map<String,Var> vars = new HashMap<>();

	public static Map<String, Var> getVars() {
		return vars;
	}

	static void saveVar(String name,Var var){
		vars.put(name, var);
	}

	static Var createVar(String strVar) throws CalcException{
		if (strVar.matches(Patterns.SCALAR))
			return new Scalar(strVar);
		else if (strVar.matches(Patterns.VECTOR))
			return new Vector(strVar);
		else if (strVar.matches(Patterns.MATRIX))
			return new Matrix(strVar);
		else if (vars.containsKey(strVar))
			return vars.get(strVar);
		throw new CalcException("Невозможно создать "+strVar);
	}


	@Override
	public Var add(Var other) throws CalcException {
		throw new CalcException("Сложение " + this + " + " + other + " невозможно!");
	}

	@Override
	public Var sub(Var other) throws CalcException{
		throw new CalcException("Вычитание " + this + " + " + other + " невозможно!");
	}

	@Override
	public Var mul(Var other) throws CalcException{
		throw new CalcException("Умножение " + this + " + " + other + " невозможно!");
	}

	@Override
	public Var div(Var other) throws CalcException{
		throw new CalcException("Деление " + this + " + " + other + " невозможно!");
	}

	@Override
	public String toString() {
		return "Это класс Abstract Var";
	}
}
