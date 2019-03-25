package by.it.narushevich.jd01_03;


import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {

        System.out.println("Введите строку чисел: ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        double[] array = InOut.getArray(str);
        System.out.println("\n" + "Получен массив чисел: ");
        InOut.printArray(array);

        System.out.println("Вот форматированный вариант: ");
        InOut.printArray(array, "m", 4);

        System.out.print("\n" + "Минимальное число в массиве: " + "\n");
        Helper.findMin(array);

        System.out.print("\n" + "Максимальное число в массиве: " + "\n");
        Helper.findMax(array);

        System.out.println("\n" + "Ваш массив отсортирован по возрастанию: ");
        Helper.sort(array);

        System.out.println("\n" + "\n" + "Исходная матрица: ");
        double[][] matrix = InOut.createMatrix(3, 4);

        System.out.println("\n" + "Исходный вектор: ");
        double[] vector = InOut.createArray(3);

        System.out.println("\n" + "Результирующий вектор: ");
        double[] resultVector = Helper.mul(matrix, vector);

        System.out.println("\n" + "\n" + "Исходная матрица 1: ");
        double[][] matrixLeft = InOut.createMatrix(2, 3);

        System.out.println("\n" + "Исходная матрица 2: ");
        double[][] matrixRight = InOut.createMatrix(3, 2);

        System.out.println("\n" + "Результат произведения матрицы 1 на матрицу 2: ");
        double[][] mulMatrix = Helper.mul(matrixLeft, matrixRight);
    }
}
