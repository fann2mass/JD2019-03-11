package by.it.eslaikouskaya.jd01_08;

import java.util.Arrays;

class Matrix extends Var {

	private double[][] value;
	public double[][] getValue() {
		return value;
	}


	@Override
	public Var add(Var other) {
		Matrix result = new Matrix(value);
		this.value= Arrays.copyOf(value,value.length);
		if (other instanceof Matrix){
			for (int i = 0; i < result.value.length; i++) {
				for (int j = 0; j < result.value[i].length; j++) {
					result.value[i][j]+=((Matrix) other).getValue()[i][j];
				}
			}
			return result;
		}
		if (other instanceof Scalar){
			for (int i = 0; i < result.value.length; i++) {
				for (int j = 0; j < result.value[i].length; j++) {
					result.value[i][j]+=((Scalar) other).getValue();
				}
			}
			return result;
		}
		return super.add(other);
	}

	@Override
	public Var sub(Var other) {
		Matrix result = new Matrix(value);
		this.value=Arrays.copyOf(value,value.length);
		if (other instanceof Matrix){
			for (int i = 0; i < result.value.length; i++) {
				for (int j = 0; j < result.value[i].length; j++) {
					result.value[i][j]-=((Matrix) other).getValue()[i][j];
				}
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
	public Var mul(Var other) {
		this.value=Arrays.copyOf(value,value.length);
		Matrix result = new Matrix(value);
		if (other instanceof Matrix){
			double[][] result0 = new double[result.value.length][((Matrix) other).value[0].length];
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
				for (int j = 0; j < resultVector.length; j++)
					resultVector[i] += result.value[i][j] * ((Vector) other).getValue()[j];
			return new Vector(resultVector);
		}
		return super.mul(other);
	}



	@Override
	public Var div(Var other) {
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

	Matrix(double[ ][ ] value){
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
		sb.deleteCharAt(0).deleteCharAt(0).deleteCharAt(sb.length() - 1).deleteCharAt(sb.length() - 1);
		String string = sb.toString();
		String[] str = string.split("[{]");
		double[][] matrix = new double[str.length][str.length];
		for (int i = 0; i < str.length; i++) {
			for (int j = 0; j < str.length; j++) {
				String[] row = str[i].split("[^\\d.]+");
				matrix[i][j] = Double.parseDouble(row[j]);
			}
			this.value = matrix;
		}
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
