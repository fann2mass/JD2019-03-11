package by.it.vasiliuk.jd01_03;


import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine(); //читаем линию символов с клавиатуры
        double[] array = InOut.getArray(str); //вызываем метод из которого получаем массив
        InOut.printArray(array);  //выводим этот массив
        InOut.printArray(array,"v",4);
        Helper.findMin(array);
        Helper.findMax(array);
        Helper.sort(array);

        System.out.print("\nВведите количество строк matrix и vector:\n");
        double m = scanner.nextDouble();
        System.out.print("Введите количество столбцов matrix:\n");
        double n = scanner.nextDouble();
        double[][] matrix = new double[(int) m][(int) n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("Введите элемент matrix [" + (i + 1) + "][" + (j + 1) + "] = ");
                matrix[i][j] = scanner.nextInt();
            }
        }
        System.out.println();
        double[] vector = new double[(int) n];
        for (int i = 0; i < n; i++) {
            System.out.print("Введите элемент vector [" + (i + 1) + "] = ");
            vector[i]= scanner.nextInt();

        }
        Helper.mul(matrix,vector);

        System.out.print("\nВведите количество строк matrixLeft и matrixRight:\n");
        double p = scanner.nextDouble();
        System.out.print("Введите количество столбцов matrixLeft и matrixRight:\n");
        double r = scanner.nextDouble();
        double[][] matrixLeft = new double[(int) p][(int) r];
        for (int i = 0; i < p; i++) {
            for (int j = 0; j < r; j++) {
                System.out.print("Введите элемент matrixLeft [" + (i + 1) + "][" + (j + 1) + "] = ");
                matrixLeft[i][j] = scanner.nextInt();
            }
        }
        System.out.println();
        double[][] matrixRight = new double[(int) p][(int) r];
        for (int i = 0; i < p; i++) {
            for (int j = 0; j < r; j++) {
                System.out.print("Введите элемент matrixRight [" + (i + 1) + "][" + (j + 1) + "] = ");
                matrixRight[i][j] = scanner.nextInt();
            }
        }
        Helper.mul(matrixLeft,matrixRight);
    }

}
