package by.it.eslaikouskaya.jd02_04;


import java.util.Arrays;

class Vector extends Var {

	private double[] value;

	public double[] getValue() {
		return value;
	}


	@Override
	public Var add(Var other) throws CalcException {
		Vector result = new Vector(value);
		this.value=Arrays.copyOf(value,value.length);
		if (other instanceof Scalar) {
			for (int i = 0; i < result.value.length; i++) {
				result.value[i] = result.value[i] + ((Scalar) other).getValue();
			}
			return result;
		}
		if (other instanceof Vector) {
			for (int i = 0; i < result.value.length; i++) {
				if (this.value.length!=((Vector) other).value.length)
					throw new CalcException("Размер не подходит");
				result.value[i] = result.value[i] + ((Vector) other).value[i];
			}
			return result;
		}
		return super.add(other);
	}

	@Override
	public Var sub(Var other) throws CalcException {
		Vector result = new Vector(value);
		this.value=Arrays.copyOf(value,value.length);
		if (other instanceof Scalar) {
			for (int i = 0; i < result.value.length; i++) {
				result.value[i] = result.value[i] - ((Scalar) other).getValue();
			}
			return result;
		}
		if (other instanceof Vector) {
			for (int i = 0; i < result.value.length; i++) {
				if (this.value.length!=((Vector) other).value.length)
					throw new CalcException("Размер не подходит");
				result.value[i] = result.value[i] - ((Vector) other).value[i];
			}
			return result;
		}
		return super.sub(other);
	}

	@Override
	public Var mul(Var other) throws CalcException {
		Vector result = new Vector(value);
		this.value=Arrays.copyOf(value,value.length);
		if (other instanceof Scalar) {
			for (int i = 0; i < result.value.length; i++) {
				result.value[i] = result.value[i] * ((Scalar) other).getValue();
			}
			return result;
		}

		if (other instanceof Vector) {
			double sum = 0;
			for (int i = 0; i < result.value.length; i++) {
				if (this.value.length!=((Vector) other).value.length)
					throw new CalcException("Размер не подходит");
				result.value[i] = result.value[i] * ((Vector) other).value[i];
				sum=sum+result.value[i];
			}
			return new Scalar(sum);
		}
		return super.mul(other);
	}

	@Override
	public Var div(Var other) throws CalcException {
		Vector result = new Vector(value);
		this.value=Arrays.copyOf(value,value.length);
		if (other instanceof Scalar) {
			for (int i = 0; i < result.value.length; i++) {
				if (((Scalar) other).getValue()==0) throw new CalcException("Деление на ноль");
				result.value[i] = result.value[i] / ((Scalar) other).getValue();
			}
			return result;
		}
		return super.div(other);
	}

	Vector(double[] value){
		this.value=Arrays.copyOf(value,value.length);
	}


	Vector(Vector vector){
		this.value=vector.value;
	}


	Vector(String strVector){
		String[] arr = strVector
				.replace("{", "")
				.replace("}", "")
				.split(",");
		value=new double[arr.length];
		for (int i = 0; i < value.length; i++) {
			value[i]=Double.parseDouble(arr[i]);
		}
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("{");
		String delimiter = "";
		for (double element : value) {
			sb.append(delimiter).append(element);
			delimiter=", ";
		}
		sb.append("}");

		return sb.toString();
	}
}
