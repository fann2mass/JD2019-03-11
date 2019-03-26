package by.it.eslaikouskaya.jd01_07;

class Matrix extends Var{

	private double[][] value;

	Matrix(double[ ][ ] value){
		this.value=value;
	}

	Matrix(Matrix matrix){
		this.value=matrix.value;
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
			{sb.append("},{");}
			delimiter = "";
		}
		sb.append("}}");
		return sb.toString();
	}
}
