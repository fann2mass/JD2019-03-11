package by.it.eslaikouskaya.calc;


import java.util.Arrays;

class Vector extends Var {

	private double[] value;
	private ResourceManager manager = ResourceManager.INSTANCE;
	private Singleton logger = Singleton.getInstance();

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
				if (this.value.length != ((Vector) other).value.length) {
					logger.log(manager.getString("message.size"));
					throw new CalcException(manager.getString("message.size"));
				}
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
				if (this.value.length != ((Vector) other).value.length) {
					logger.log(manager.getString("message.size"));
					throw new CalcException((manager.getString("message.size")));
				}
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
				if (this.value.length != ((Vector) other).value.length) {
					logger.log(manager.getString("message.size"));
					throw new CalcException((manager.getString("message.size")));
				}
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
				if (((Scalar) other).getValue() == 0) {
					logger.log(manager.getString("message.zero"));
					throw new CalcException((manager.getString("message.zero")));
				}
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


	Vector(String strValue) {
		String[] arr = strValue
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
			delimiter = ", ";
		}
		sb.append("}");
		return sb.toString();
	}
}
