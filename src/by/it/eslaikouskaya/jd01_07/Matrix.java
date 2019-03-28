package by.it.eslaikouskaya.jd01_07;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Matrix extends Var{

	private double[][] value;

	Matrix(double[ ][ ] value){
		this.value=value;
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
			sb.append("},{");
			delimiter = "";
		}
		sb.append("}}");
		return sb.toString();
	}
}
