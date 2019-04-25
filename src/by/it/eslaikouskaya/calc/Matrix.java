package by.it.eslaikouskaya.calc;

import java.util.Arrays;

class Matrix extends Var {

	private double[][] value;
	public double[][] getValue() {
		return value;
	}

	private ResourceManager manager = ResourceManager.INSTANCE;

	@Override
	public Var add(Var other) throws CalcException {
		Matrix result = new Matrix(value);
		this.value= Arrays.copyOf(value,value.length);
		if (other instanceof Matrix){
			for (int i = 0; i < result.value.length; i++) {
				for (int j = 0; j < result.value[i].length; j++) {
					if (result.value[i].length != ((Matrix) other).value[j].length) {
						throw new CalcException(manager.getString("message.size"));
					}
					result.value[i][j]+=((Matrix) other).getValue()[i][j];
				}
			}
			return result;
		}
		if (other instanceof Scalar){
			for (int i = 0; i < result.value.length; i++) {
				for (int j = 0; j < result.value[i].length; j++){
					result.value[i][j]+=((Scalar) other).getValue();
				}
			}
			return result;
		}
		return super.add(other);
	}

	@Override
	public Var sub(Var other) throws CalcException {
		Matrix result = new Matrix(value);
		this.value=Arrays.copyOf(value,value.length);

		if (other instanceof Matrix){
			for (int i = 0; i < result.value.length; i++)
				for (int j = 0; j < result.value[0].length; j++) {
					if (result.value[j].length!=((Matrix) other).value[j].length)
						throw new CalcException(manager.getString("message.size"));
					result.value[i][j]-=((Matrix) other).getValue()[i][j];
				}
			return result;
		}

		if (other instanceof Scalar){
			for (int i = 0; i < result.value.length; i++) {
				for (int j = 0; j < result.value[i].length; j++) {
					result.value[i][j]-=((Scalar) other).getValue();
				}
			}
			return result;
		}
		return super.sub(other);
	}

	@Override
	public Var mul(Var other) throws CalcException {
		this.value=Arrays.copyOf(value,value.length);
		Matrix result = new Matrix(value);

		if (other instanceof Matrix){
			double[][] result0 = new double[result.value.length][((Matrix) other).value[0].length];
			if (result.value.length!=((Matrix) other).value[0].length)
				throw new CalcException(manager.getString("message.size"));
			for (int i = 0; i < result.value.length; i++)
				for (int j = 0; j < ((Matrix) other).value[0].length; j++)
					for (int k = 0; k < ((Matrix) other).value.length; k++)
						result0[i][j] += result.value[i][k] * ((Matrix) other).value[k][j];
			return new Matrix(result0);
		}

		if (other instanceof Scalar){
			for (int i = 0; i < result.value.length; i++) {
				for (int j = 0; j < result.value[i].length; j++) {
					result.value[i][j]*=((Scalar) other).getValue();
				}
			}
			return result;
		}

		if (other instanceof Vector){
			double[] resultVector = new double[value.length];
			for (int i = 0; i < result.value.length; i++)
				for (int j = 0; j < resultVector.length; j++) {
					if (result.value[i].length != ((Vector) other).getValue().length) {
						throw new CalcException(manager.getString("message.size"));
					}
					resultVector[i] += result.value[i][j] * ((Vector) other).getValue()[j];
				}
			return new Vector(resultVector);
		}
		return super.mul(other);
	}



	@Override
	public Var div(Var other) throws CalcException {
		this.value=Arrays.copyOf(value,value.length);
		Matrix result = new Matrix(value);
		if (other instanceof Scalar){
			for (int i = 0; i < result.value.length; i++) {
				for (int j = 0; j < result.value[i].length; j++) {
					result.value[i][j]/=((Scalar) other).getValue();
				}
			}
			return result;
		}
		return super.div(other);

	}

	private Matrix(double[][] value){
		double[][] value2 = new double[value.length][value[0].length];
		for (int i = 0; i < value2.length; i++)
			System.arraycopy(value[i], 0, value2[i], 0, value2[0].length);
		this.value = value2;
	}

	Matrix(Matrix matrix){
		this.value=matrix.value;
	}

	Matrix(String strMatrix) {
		StringBuilder sb = new StringBuilder(strMatrix);
		sb.deleteCharAt(0).deleteCharAt(0).
				deleteCharAt(sb.length() - 1).deleteCharAt(sb.length() - 1);
		String[] rows = sb.toString().split("(},\\s?\\{)");
		String[] cols = rows[0].split("[, ]+");

		double[][] resMatrix = new double[rows.length][cols.length];
		for (int i = 0; i < rows.length; i++) {
			String[] colsM = rows[i].split("[, ]+");
			for (int j = 0; j < colsM.length; j++) {
				resMatrix[i][j] = Double.parseDouble(colsM[j]);
			}
		}
		this.value = resMatrix;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("{{");
		String delimiter = "";
		for (int i = 0; i < value.length; i++) {
			for (int j = 0; j < value[i].length; j++) {
				sb.append(delimiter).append(value[i][j]);
				delimiter = ", ";
			}
			if (i!=value.length-1)
			sb.append("}, {");
			delimiter = "";
		}
		sb.append("}}");
		return sb.toString();
	}
}
