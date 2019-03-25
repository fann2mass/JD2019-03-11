package by.it.bildziuh.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int workersNum = scanner.nextInt();
        System.out.println("Введите Фамилии рабочих");
        String[] workersName = new String[workersNum];
        int[][] salary = new int[workersNum][4];
        int[] salarySum = new int[workersNum];
        int salarySumAll = 0;
        double salaryAvgAll;

        for (int i = 0; i < workersName.length; i++) {
            workersName[i] = scanner.next();
        }

        for (int i = 0; i < workersNum; i++) {
            System.out.println("Введите зарплату для " + workersName[i]);
            for (int j = 0; j < 4; j++) {
                salary[i][j] = scanner.nextInt();
                salarySum[i] = salarySum[i] + salary[i][j];
            }
            salarySumAll = salarySumAll + salarySum[i];
        }

        salaryAvgAll = salarySumAll*1.0/(workersNum*4);

        System.out.println("-------------------------------------------------------");
        System.out.printf("%-10s%-10s%-10s%-10s%-10s%-10s\n", "Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");
        System.out.println("-------------------------------------------------------");
        for (int i = 0; i < workersNum; i++) {
            System.out.printf("%-10s%-10d%-10d%-10d%-10d%-10d", workersName[i], salary[i][0], salary[i][1], salary[i][2], salary[i][3], salarySum[i]);
            System.out.println();
        }
        System.out.println("-------------------------------------------------------");
        System.out.printf("%-10s%-10d\n", "Итого", salarySumAll);
        System.out.printf("%-10s%-10.4f\n", "Средняя", salaryAvgAll);

    }

}

