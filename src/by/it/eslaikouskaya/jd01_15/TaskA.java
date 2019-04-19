package by.it.eslaikouskaya.jd01_15;

import java.io.*;

public class TaskA {

	public static void main(String[] args) {
		int [][] matrix = createMatrix(4, 6, 15);
		String filename=getFileName(TaskA.class,"matrix.txt");
		saveMatrix(matrix, filename);
		showFile(filename);
	}

	private static int[][] createMatrix(int rows, int colls, int max) {
		int [][] matrix = new int[colls][rows];
		boolean maxOk, minOk;
		do {
			maxOk=false;
			minOk=false;
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[i].length; j++) {
					matrix[i][j] = (int) (Math.random() * (max*2+1)) - 15;
					if (matrix[i][j]==max) maxOk=true;
					if (matrix[i][j]==-max) minOk=true;
				}
			}
		} while (!(maxOk && minOk));
		return matrix;
	}


	private static String getFileName(Class<?> cl, String name) {
		String src = System.getProperty("user.dir") + File.separator + "src" + File.separator;
		String strPackage = cl.getPackage().getName().replace(".", File.separator);
		return src + strPackage + File.separator + name;
	}


	private static void saveMatrix(int[][] matrix, String filename) {
		try (PrintWriter out=new PrintWriter(new FileWriter(filename))){
			for (int[] row : matrix) {
				for (int element : row) {
					out.printf("%3d ",element);
				}
				out.println();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void showFile(String filename) {
		try (BufferedReader in=new BufferedReader(new FileReader(filename))){
			String line;
			while ((line=in.readLine())!=null){
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
