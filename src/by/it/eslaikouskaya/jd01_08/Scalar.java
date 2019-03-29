package by.it.eslaikouskaya.jd01_08;

class Scalar extends Var {

	private double value;

	public double getValue() {
		return value;
	}

	@Override
	public Var add(Var other) {
		if (other instanceof Scalar)
			return new Scalar(this.value + ((Scalar) other).value);
		return other.add(this);
	}

	@Override
	public Var sub(Var other) {
		if (other instanceof Scalar)
			return new Scalar(this.value - ((Scalar) other).value);
		//Scalar minus1=new Scalar(-1);
		return this.sub(other);
		//return other.sub(this).mul(minus1);
	}

	@Override
	public Var mul(Var other) {
		if (other instanceof Scalar)
			return new Scalar(this.value * ((Scalar) other).value);
		return other.mul(this);
	}

	@Override
	public Var div(Var other) {
		if (other instanceof Scalar)
			return new Scalar(this.value / ((Scalar) other).value);
		return super.div(other);
	}

	Scalar(double value) {
		this.value = value;
	}

	Scalar(String str){
		this.value=Double.parseDouble(str);
	}

	Scalar(Scalar scalar){
		this.value=scalar.value;
	}


	@Override
	public String toString() {
		return Double.toString(value);
	}
}
